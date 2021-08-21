package com.lukmanhawi.moviecatalogue.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProvider;

import com.lukmanhawi.moviecatalogue.R;
import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.utils.CatalogueIdlingResource;
import com.lukmanhawi.moviecatalogue.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private ImageView imagePoster;
    private TextView textTitle, textDate, tvVote, textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        imagePoster = findViewById(R.id.image_poster);
        textTitle = findViewById(R.id.text_title);
        textDate = findViewById(R.id.text_date);
        textDescription = findViewById(R.id.text_description);
        tvVote = findViewById(R.id.text_rate);
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        NestedScrollView content = findViewById(R.id.content);

        CatalogueIdlingResource.increment();

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailViewModel viewModel =
                new ViewModelProvider(this, factory)
                        .get(DetailViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String courseId = extras.getString(EXTRA_MOVIE);
            if (courseId != null) {
                progressBar.setVisibility(View.VISIBLE);
                content.setVisibility(View.GONE);
                viewModel.setSelectedData(this, courseId);
                viewModel.getMovie().observe(this, itemEntity -> {
                    content.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    populateMovie(itemEntity);
                });
            }
        }

        if (!CatalogueIdlingResource.getIdlingResource().isIdleNow()) {
            CatalogueIdlingResource.decrement();
        }
    }

    private void populateMovie(MovieEntity movieEntity) {
        textTitle.setText(movieEntity.getTitle());
        textDate.setText(movieEntity.getDate());
        textDescription.setText(movieEntity.getDescription());
        tvVote.setText(movieEntity.getRate());

        if (movieEntity.getImagePath() != null) {
            Glide.with(this)
                    .load(movieEntity.getImagePath())
                    .transform(new RoundedCorners(20))
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imagePoster);
        }
    }
}
