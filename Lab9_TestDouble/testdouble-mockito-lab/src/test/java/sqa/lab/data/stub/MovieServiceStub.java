package sqa.lab.data.stub;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import java.util.Arrays;
import java.util.List;

import sqa.lab.api.Lab9_1.Movie;
import sqa.lab.api.Lab9_1.MovieService;

public class MovieServiceStub implements MovieService {

    public List<Movie> getNowPlaying(String location, String date) {
        return Arrays.asList(
                new Movie("The Odyssey", "IMAX with Laser"),
                new Movie("Spider-Man: Brand New Day", "IMAX with Laser"),
                new Movie("The End of Oak Street", "IMAX with Laser"),
                new Movie("Wicked: For Good", "VIP Cinema"),
                new Movie("Zootopia 2", "VIP Cinema"),
                new Movie("Avatar: Fire and Ash", "Standard")
        );
    }
}
