package sqa.lab.service.Lab9_2;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import java.sql.SQLException;
import java.util.List;

public class SeatReservation {

    private SeatDAO dao;

    public SeatReservation(SeatDAO dao) {
        this.dao = dao;
    }

    public boolean checkSeatAvailability(String seatName) throws SQLException {

        List<String> seatsAvailable = dao.fetchAvailableSeats();
        return seatsAvailable.contains(seatName);
    }

}