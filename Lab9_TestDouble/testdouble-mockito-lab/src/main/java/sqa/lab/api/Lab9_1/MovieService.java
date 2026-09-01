package sqa.lab.api.Lab9_1;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import java.util.List;

public interface MovieService {

    List<Movie> getNowPlaying(String location, String date);

}
