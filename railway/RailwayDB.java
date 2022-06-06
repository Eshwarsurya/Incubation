package railway;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RailwayDB 
{
	static Map<Ticket,Passenger> bookedTickets=new LinkedHashMap<Ticket,Passenger>();
	static Map<Integer,String> childDB=new LinkedHashMap<Integer,String>();
	static Queue<Ticket> racList = new LinkedList<Ticket>();
	static Queue<Ticket> waitingList = new LinkedList<Ticket>();
	
	
}
