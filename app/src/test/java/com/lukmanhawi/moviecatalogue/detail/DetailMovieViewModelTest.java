package com.lukmanhawi.moviecatalogue.detail;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
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

public class DetailMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Context context;

    private DetailViewModel viewModel;
    private MovieEntity dummyCourse = DataDummy.generateDummyMovies().get(0);
    private CatalogueRepository movieCatalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new DetailViewModel(movieCatalogueRepository);
    }

    @Test
    public void getMovie() {
        MutableLiveData<MovieEntity> movie = new MutableLiveData<>();
        movie.setValue(dummyCourse);
        String movieId = dummyCourse.getMovieId();
        when(movieCatalogueRepository.getMovieById(movieId)).thenReturn(movie);
        viewModel.setSelectedData(context, movieId);
        Observer<MovieEntity> observer = mock(Observer.class);
        viewModel.getMovie().observeForever(observer);
        verify(movieCatalogueRepository).getMovieById(movieId);
        MovieEntity movieEntity = viewModel.getMovie().getValue();
        assertNotNull(movieEntity);
        assertEquals(dummyCourse.getMovieId(), movieEntity.getMovieId());
        assertEquals(dummyCourse.getDate(), movieEntity.getDate());
        assertEquals(dummyCourse.getDescription(), movieEntity.getDescription());
        assertEquals(dummyCourse.getImagePath(), movieEntity.getImagePath());
        assertEquals(dummyCourse.getTitle(), movieEntity.getTitle());

        viewModel.getMovie().observeForever(observer);
        verify(observer).onChanged(dummyCourse);
    }

//    @Test
//    public void getMovieById() {
//        MutableLiveData<MovieEntity> movie = new MutableLiveData<>();
//        movie.setValue(dummyCourse);
//        String movieById = dummyCourse.getMovieId();
//        when(movieCatalogueRepository.getMovieById(movieById)).thenReturn(movie);
//        viewModel.setSelectedData(context, movieById);
//        Observer<MovieEntity> observer = mock(Observer.class);
//        viewModel.getMovie().observeForever(observer);
//        verify(observer).onChanged(dummyCourse);
//        MovieEntity movieEntity = viewModel.getMovie().getValue();
//        assertNotNull(movieEntity);
//        assertEquals(dummyCourse.getMovieId(), movieEntity.getMovieId());
//        assertEquals(dummyCourse.getDate(), movieEntity.getDate());
//        assertEquals(dummyCourse.getDescription(), movieEntity.getDescription());
//        assertEquals(dummyCourse.getImagePath(), movieEntity.getImagePath());
//        assertEquals(dummyCourse.getTitle(), movieEntity.getTitle());
//
//        viewModel.get().observeForever(courseObserver);
//        verify(courseObserver).onChanged(dummyCourse);
//    }
}