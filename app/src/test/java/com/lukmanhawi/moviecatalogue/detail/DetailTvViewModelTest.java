package com.lukmanhawi.moviecatalogue.detail;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.CatalogueRepository;
import com.lukmanhawi.moviecatalogue.ui.detail.DetailViewModel;
import com.lukmanhawi.moviecatalogue.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailTvViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Context context;

    private DetailViewModel viewModel;
    private TvEntity dummyCourse = DataDummy.generateDummyTv().get(0);
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new DetailViewModel(catalogueRepository);
    }

    @Test
    public void getTv() {
        MutableLiveData<TvEntity> tv = new MutableLiveData<>();
        tv.setValue(dummyCourse);
        String tvId = dummyCourse.getTvId();
        when(catalogueRepository.getTvShowById(tvId)).thenReturn(tv);
        viewModel.setSelectedData(context, tvId);
        Observer<TvEntity> observer = mock(Observer.class);
        viewModel.getTvShow().observeForever(observer);
        verify(catalogueRepository).getTvShowById(tvId);
        TvEntity tvEntity = viewModel.getTvShow().getValue();
        assertNotNull(tvEntity);
        assertEquals(dummyCourse.getTvId(), tvEntity.getTvId());
        assertEquals(dummyCourse.getDate(), tvEntity.getDate());
        assertEquals(dummyCourse.getDescription(), tvEntity.getDescription());
        assertEquals(dummyCourse.getImagePath(), tvEntity.getImagePath());
        assertEquals(dummyCourse.getTitle(), tvEntity.getTitle());

        viewModel.getTvShow().observeForever(observer);
        verify(observer).onChanged(dummyCourse);
    }
}