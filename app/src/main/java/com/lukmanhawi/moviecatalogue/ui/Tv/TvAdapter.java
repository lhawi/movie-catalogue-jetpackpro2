package com.lukmanhawi.moviecatalogue.ui.Tv;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lukmanhawi.moviecatalogue.R;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.databinding.ItemsTvBinding;
import com.lukmanhawi.moviecatalogue.ui.detail.DetailTvActivity;

import java.util.ArrayList;
import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    private final List<TvEntity> listTv = new ArrayList<>();

    void setTv(List<TvEntity> listCourses) {
        if (listCourses == null) return;
        this.listTv.clear();
        this.listTv.addAll(listCourses);
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsTvBinding binding = ItemsTvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TvViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvViewHolder holder, int position) {
        TvEntity tv = listTv.get(position);
        holder.bind(tv);
    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    static class TvViewHolder extends RecyclerView.ViewHolder {

        private final ItemsTvBinding binding;

        TvViewHolder(ItemsTvBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(TvEntity tv) {
            binding.tvItemTitle.setText(tv.getTitle());
            binding.tvItemDate.setText(tv.getDate());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailTvActivity.class);
                intent.putExtra(DetailTvActivity.EXTRA_TV, tv.getTvId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(tv.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgPoster);
        }
    }
}