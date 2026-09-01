package sqa.lab.service.Lab9_2;

/**
 * ชื่อ: นายปิยชญานินท์ โทนะพันธ์ รหัสนักศึกษา: 673380049-4
 */

public class TicketCounter {
	
	private Integer noCheckinCustomer = 0;
	
	public void changeTicketStatus(boolean isValidTicket) {
		
		if (isValidTicket) {
			noCheckinCustomer++;
		}			
	}
	
	public int getNoCheckinCustomer() {
		return noCheckinCustomer;
	}
	
	public void resetNoCheckinCustomer() {
		noCheckinCustomer = 0;
	}

}
