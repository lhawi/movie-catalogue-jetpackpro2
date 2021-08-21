package com.lukmanhawi.moviecatalogue.data.source.remote;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.response.MovieResponse;
import com.lukmanhawi.moviecatalogue.data.source.remote.response.TVResponse;
import com.lukmanhawi.moviecatalogue.utils.DataSource;
import com.lukmanhawi.moviecatalogue.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CatalogueRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remote = mock(RemoteDataSource.class);
    private FakeCatalogueRepository movieCatalogueRepository = new FakeCatalogueRepository(remote);

    private List<MovieResponse> movieResponses = DataSource.generateDummyMovies();
    private String courseId = movieResponses.get(0).getMovieId();
    private List<TVResponse> tvShowResponses = DataSource.generateDummyTvShows();
    private String tvShowId = tvShowResponses.get(0).getTvId();


    @Test
    public void getMovies() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[0])
                    .onItemsReceived(movieResponses);
            return null;
        }).when(remote).getMovies(any(RemoteDataSource.LoadMovieCallback.class));
        List<MovieEntity> courseEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovies());
        verify(remote).getMovies(any(RemoteDataSource.LoadMovieCallback.class));
        assertNotNull(courseEntities);
        assertEquals(movieResponses.size(), courseEntities.size());
    }

    @Test
    public void getTvShows() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTvCallback) invocation.getArguments()[0])
                    .onItemsReceived(tvShowResponses);
            return null;
        }).when(remote).getTvShows(any(RemoteDataSource.LoadTvCallback.class));
        List<TvEntity> courseEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShows());
        verify(remote).getTvShows(any(RemoteDataSource.LoadTvCallback.class));
        assertNotNull(courseEntities);
        assertEquals(tvShowResponses.size(), courseEntities.size());
    }

    @Test
    public void getMovieById() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[0])
                    .onItemsReceived(movieResponses);
            return null;
        }).when(remote).getMovies(any(RemoteDataSource.LoadMovieCallback.class));
        MovieEntity movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovieById(courseId));
        verify(remote).getMovies(any(RemoteDataSource.LoadMovieCallback.class));
        assertNotNull(movieEntities);
        assertEquals(movieResponses.get(0).getMovieId(), movieEntities.getMovieId());
    }

    @Test
    public void getTvShowById() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTvCallback) invocation.getArguments()[0])
                    .onItemsReceived(tvShowResponses);
            return null;
        }).when(remote).getTvShows(any(RemoteDataSource.LoadTvCallback.class));
        TvEntity tvEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShowById(tvShowId));
        verify(remote).getTvShows(any(RemoteDataSource.LoadTvCallback.class));
        assertNotNull(tvEntities);
        assertEquals(tvShowResponses.get(0).getTvId(), tvEntities.getTvId());
    }

}