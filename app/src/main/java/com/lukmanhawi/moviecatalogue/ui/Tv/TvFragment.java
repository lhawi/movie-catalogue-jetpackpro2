package com.lukmanhawi.moviecatalogue.ui.Tv;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lukmanhawi.moviecatalogue.databinding.FragmentTvBinding;
import com.lukmanhawi.moviecatalogue.utils.CatalogueIdlingResource;
import com.lukmanhawi.moviecatalogue.viewmodel.ViewModelFactory;

public class TvFragment extends Fragment {

    private FragmentTvBinding fragmentTvBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentTvBinding = FragmentTvBinding.inflate(inflater, container, false);
        return fragmentTvBinding.getRoot();
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvViewModel viewModel = new ViewModelProvider(this, factory).get(TvViewModel.class);
            TvAdapter tvAdapter = new TvAdapter();
            viewModel.getTvShows().observe(this, itemEntities -> {
                fragmentTvBinding.progressBar.setVisibility(View.GONE);
                tvAdapter.setTv(itemEntities);
                tvAdapter.notifyDataSetChanged();
            });
            fragmentTvBinding.rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentTvBinding.rvTv.setHasFixedSize(true);
            fragmentTvBinding.rvTv.setAdapter(tvAdapter);
        }
        CatalogueIdlingResource.increment();
        if (!CatalogueIdlingResource.getIdlingResource().isIdleNow()) {
            CatalogueIdlingResource.decrement();
        }
    }
}