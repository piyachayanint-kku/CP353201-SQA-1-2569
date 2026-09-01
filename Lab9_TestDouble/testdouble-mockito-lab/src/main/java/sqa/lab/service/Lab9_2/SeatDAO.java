package sqa.lab.service.Lab9_2;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {
	
	public List<String> fetchAvailableSeats() throws SQLException {
        List<String> availableSeats = new ArrayList<String>();
        Connection conn = DriverManager.getConnection("DATABASE_URL");
        Statement statement = conn.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("SELECT * FROM ROOMS WHERE AVAILABLE like '1'");
        while(rs.next()){
            availableSeats.add(rs.getString("Seat name"));
        }
        return availableSeats;
    }
}
