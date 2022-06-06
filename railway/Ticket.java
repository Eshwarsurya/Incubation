package railway;

public class Ticket 
{
	private static int tempId=1;
	private BerthPreference allotedBerth;
	private int seatNumber;
	private int id=tempId++;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
