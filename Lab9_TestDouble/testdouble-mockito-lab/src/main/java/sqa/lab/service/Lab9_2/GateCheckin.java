package sqa.lab.service.Lab9_2;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GateCheckin {
	
	private Set<Integer> checkinCustomer;
	
	private TicketCounter ticketCounter;
	
	public GateCheckin(TicketCounter ticketCounter) {
        this.checkinCustomer = new HashSet<Integer>();
        this.ticketCounter = ticketCounter;
    }
	
	public void customerEntry(int ticketId){
        if(customerIsEligible(ticketId)) {
            checkinCustomer.add(ticketId);
            ticketCounter.changeTicketStatus(true);
        }
    }

    public Set<Integer> getPassengersOnBoard() {
        return checkinCustomer;
    }

    public boolean customerIsEligible(int ticketId) {
        return !checkinCustomer.contains(ticketId);
    }

}
