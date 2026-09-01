package sqa.lab.service.Lab9_2;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GateCheckinMockitoTest {

    private TicketCounter ticketCounterMock;
    private GateCheckin gateCheckin;

    @BeforeEach
    void setup() {
        ticketCounterMock = mock(TicketCounter.class);
        gateCheckin = new GateCheckin(ticketCounterMock);
    }

    @Test
    void customerEntry_validTicket_addsCustomerAndUpdatesCounter() {
        gateCheckin.customerEntry(1001);

        Set<Integer> checkedInCustomers = gateCheckin.getPassengersOnBoard();
        assertEquals(1, checkedInCustomers.size());
        assertTrue(checkedInCustomers.contains(1001));

        verify(ticketCounterMock, times(1)).changeTicketStatus(true);
    }

    @Test
    void customerEntry_duplicateTicket_isNotCheckedInTwice() {
        gateCheckin.customerEntry(2002);
        gateCheckin.customerEntry(2002); // same ticket scanned again at the gate

        assertEquals(1, gateCheckin.getPassengersOnBoard().size());
        verify(ticketCounterMock, times(1)).changeTicketStatus(true);
    }

    @Test
    void customerEntry_multipleValidTickets_countsEveryCheckedInVisitor() {
        gateCheckin.customerEntry(1001);
        gateCheckin.customerEntry(1002);
        gateCheckin.customerEntry(1003);

        assertEquals(3, gateCheckin.getPassengersOnBoard().size());
        verify(ticketCounterMock, times(3)).changeTicketStatus(true);
    }
}
