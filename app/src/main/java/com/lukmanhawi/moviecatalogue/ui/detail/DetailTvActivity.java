package com.lukmanhawi.moviecatalogue.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.lukmanhawi.moviecatalogue.R;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.utils.CatalogueIdlingResource;
import com.lukmanhawi.moviecatalogue.viewmodel.ViewModelFactory;

public class DetailTvActivity extends AppCompatActivity {

    public static final String EXTRA_TV = "extra_tv";
    private ImageView imagePoster;
    private TextView textTitle, textDate, tvVote, textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        imagePoster = findViewById(R.id.images_poster);
        textTitle = findViewById(R.id.text_ttitle);
        textDate = findViewById(R.id.text_tdate);
        textDescription = findViewById(R.id.text_tdescription);
        tvVote = findViewById(R.id.text_trate);
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        NestedScrollView content = findViewById(R.id.content);

        CatalogueIdlingResource.increment();

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailViewModel viewModel =
                new ViewModelProvider(this, factory)
                        .get(DetailViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String courseId = extras.getString(EXTRA_TV);
            if (courseId != null) {
                progressBar.setVisibility(View.VISIBLE);
                content.setVisibility(View.GONE);
                viewModel.setSelectedData(this, courseId);
                viewModel.getTvShow().observe(this, tvEntity -> {
                    content.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    populateTv(tvEntity);
                });

            }

        }

        if (!CatalogueIdlingResource.getIdlingResource().isIdleNow()) {
            CatalogueIdlingResource.decrement();
        }

    }

    private void populateTv(TvEntity tvEntity) {
        textTitle.setText(tvEntity.getTitle());
        textDate.setText(tvEntity.getDate());
        textDescription.setText(tvEntity.getDescription());
        tvVote.setText(tvEntity.getRate());

        if (tvEntity.getImagePath() != null) {
            Glide.with(this)
                    .load(tvEntity.getImagePath())
                    .transform(new RoundedCorners(20))
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imagePoster);
        }

    }
}