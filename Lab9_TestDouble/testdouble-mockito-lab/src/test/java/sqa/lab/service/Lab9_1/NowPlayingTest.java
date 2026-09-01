package sqa.lab.service.Lab9_1;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import sqa.lab.api.Lab9_1.MovieService;
import sqa.lab.data.stub.MovieServiceStub;

class NowPlayingTest {

    @Test
    void test_filterVIPCinemaMovies_withStub() {
        MovieService movieService = new MovieServiceStub();
        NowPlaying nowPlaying = new NowPlaying(movieService);

        List<String> movieList = nowPlaying.getMovieTitlesByCinemaType(
                "Central Khon Kaen", "2026-08-26", "VIP Cinema");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains("Wicked: For Good"));
        assertTrue(movieList.contains("Zootopia 2"));
    }

    @Test
    void test_filterIMAXMovies_withStub() {
        MovieService movieService = new MovieServiceStub();
        NowPlaying nowPlaying = new NowPlaying(movieService);

        List<String> movieList = nowPlaying.getMovieTitlesByCinemaType(
                "Central Khon Kaen", "2026-08-26", "IMAX with Laser");

        assertEquals(3, movieList.size());
        assertTrue(movieList.contains("The Odyssey"));
        assertTrue(movieList.contains("Spider-Man: Brand New Day"));
        assertTrue(movieList.contains("The End of Oak Street"));
    }

    @Test
    void test_filterCinemaTypeWithNoMatchingMovies_returnsEmptyList() {
        MovieService movieService = new MovieServiceStub();
        NowPlaying nowPlaying = new NowPlaying(movieService);

        List<String> movieList = nowPlaying.getMovieTitlesByCinemaType(
                "Central Khon Kaen", "2026-08-26", "4DX");

        assertEquals(0, movieList.size());
    }
}
