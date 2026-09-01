package sqa.lab.service.Lab9_1;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import java.util.ArrayList;
import java.util.List;

import sqa.lab.api.Lab9_1.Movie;
import sqa.lab.api.Lab9_1.MovieService;

public class NowPlaying {

    private MovieService movieService;

    public NowPlaying(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Returns the titles of movies playing at the given location/date,
     * filtered to the requested cinema/hall type only.
     */
    public List<String> getMovieTitlesByCinemaType(String location, String date, String cinemaType) {
        List<String> filteredTitles = new ArrayList<String>();
        List<Movie> allMovies = movieService.getNowPlaying(location, date);

        for (Movie movie : allMovies) {
            if (movie.getCinemaType().equalsIgnoreCase(cinemaType)) {
                filteredTitles.add(movie.getTitle());
            }
        }
        return filteredTitles;
    }
}
