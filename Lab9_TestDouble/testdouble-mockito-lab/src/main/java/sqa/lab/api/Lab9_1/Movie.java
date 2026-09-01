package sqa.lab.api.Lab9_1;


/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */
public class Movie {

    private String title;
    private String cinemaType;

    public Movie(String title, String cinemaType) {
        this.title = title;
        this.cinemaType = cinemaType;
    }

    public String getTitle() {
        return title;
    }

    public String getCinemaType() {
        return cinemaType;
    }

    @Override
    public String toString() {
        return title + " (" + cinemaType + ")";
    }
}
