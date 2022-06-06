package railway;

public class Ticket 
{
	private static int tempId=1;
	private BerthPreference allotedBerth;
	private int seatNumber;
	private int ticketId=tempId++;
	
	
	public int getTicketId() {
		return ticketId;
	}
	public BerthPreference getAllotedBerth() {
		return allotedBerth;
	}
	public void setAllotedBerth(BerthPreference allotedBerth) {
		this.allotedBerth = allotedBerth;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
}
