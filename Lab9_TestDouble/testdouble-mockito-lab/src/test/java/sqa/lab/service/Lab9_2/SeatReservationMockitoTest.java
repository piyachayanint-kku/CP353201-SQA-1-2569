package sqa.lab.service.Lab9_2;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeatReservationMockitoTest {

    private SeatDAO seatDAOMock;
    private SeatReservation seatReservation;

    @BeforeEach
    void setup() throws SQLException {
        seatDAOMock = mock(SeatDAO.class);
        seatReservation = new SeatReservation(seatDAOMock);

        List<String> availableSeats = Arrays.asList("A1", "A2", "B5");
        when(seatDAOMock.fetchAvailableSeats()).thenReturn(availableSeats);
    }

    @Test
    void checkSeatAvailability_seatIsAvailable_returnsTrue() throws SQLException {
        assertTrue(seatReservation.checkSeatAvailability("A1"));
    }

    @Test
    void checkSeatAvailability_seatIsNotAvailable_returnsFalse() throws SQLException {
        assertFalse(seatReservation.checkSeatAvailability("C1"));
    }

    @Test
    void checkSeatAvailability_callsFetchAvailableSeatsExactlyOnce() throws SQLException {
        seatReservation.checkSeatAvailability("B5");

        verify(seatDAOMock, times(1)).fetchAvailableSeats();
    }
}
