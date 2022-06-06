package railway;

import java.util.Map.Entry;

public class TicketManagement 
{
	
	public static Ticket bookTicket(Passenger p)
	{
		Ticket t=new Ticket();
		//For Senior citizen
		if(p.getAge()> 60  && Seat.lowerBerthSeats.size() > 0)
		{
			if(Seat.lowerBerthSeats.size()>0)
			{
				t.setAllotedBerth(BerthPreference.LOWER);
				t.setSeatNumber(Seat.lowerBerthSeats.first());
				RailwayDB.bookedTickets.put(t, p);
				Seat.lowerBerthSeats.remove(Seat.lowerBerthSeats.first());
				return t;
			}
			else if(Seat.middleBerthSeats.size()>0)
			{
				t.setAllotedBerth(BerthPreference.MIDDLE);
				t.setSeatNumber(Seat.middleBerthSeats.first());
				RailwayDB.bookedTickets.put(t, p);
				Seat.middleBerthSeats.remove(Seat.middleBerthSeats.first());
				return t;
			}
			else if(Seat.upperBerthSeats.size()>0)
			{
				t.setAllotedBerth(BerthPreference.UPPER);
				t.setSeatNumber(Seat.upperBerthSeats.first());
				RailwayDB.bookedTickets.put(t, p);
				Seat.upperBerthSeats.remove(Seat.upperBerthSeats.first());
				return t;
			}
			else if(Seat.racSeats.size()>0)
			{
				t.setAllotedBerth(BerthPreference.RAC);
				t.setSeatNumber(Seat.racSeats.first());
				RailwayDB.bookedTickets.put(t, p);
				RailwayDB.racList.add(t);
				Seat.racSeats.remove(Seat.racSeats.first());
				return t;
			}
			else if(Seat.waitingListSeats.size()>0)
			{
				t.setAllotedBerth(BerthPreference.WL);
				t.setSeatNumber(Seat.waitingListSeats.first());
				RailwayDB.bookedTickets.put(t, p);
				RailwayDB.waitingList.add(t);
				Seat.waitingListSeats.remove(Seat.waitingListSeats.first());
				return t;
			}
		}
		//For Woman with Child
		for(Entry<Integer,String> c:RailwayDB.childDB.entrySet())
		{
			if(c.getKey()==p.getPassengerId()&&c.getValue()!=null)
			{
				if(Seat.lowerBerthSeats.size()>0)
				{
					t.setAllotedBerth(BerthPreference.LOWER);
					t.setSeatNumber(Seat.lowerBerthSeats.first());
					RailwayDB.bookedTickets.put(t, p);
					Seat.lowerBerthSeats.remove(Seat.lowerBerthSeats.first());
					return t;
				}
				else if(Seat.middleBerthSeats.size()>0)
				{
					t.setAllotedBerth(BerthPreference.MIDDLE);
					t.setSeatNumber(Seat.middleBerthSeats.first());
					RailwayDB.bookedTickets.put(t, p);
					Seat.middleBerthSeats.remove(Seat.middleBerthSeats.first());
					return t;
				}
				else if(Seat.upperBerthSeats.size()>0)
				{
					t.setAllotedBerth(BerthPreference.UPPER);
					t.setSeatNumber(Seat.upperBerthSeats.first());
					RailwayDB.bookedTickets.put(t, p);
					Seat.upperBerthSeats.remove(Seat.upperBerthSeats.first());
					return t;
				}
				else if(Seat.racSeats.size()>0)
				{
					t.setAllotedBerth(BerthPreference.RAC);
					t.setSeatNumber(Seat.racSeats.first());
					RailwayDB.bookedTickets.put(t, p);
					RailwayDB.racList.add(t);
					Seat.racSeats.remove(Seat.racSeats.first());
					return t;
				}
				else if(Seat.waitingListSeats.size()>0)
				{
					t.setAllotedBerth(BerthPreference.WL);
					t.setSeatNumber(Seat.waitingListSeats.first());
					RailwayDB.bookedTickets.put(t, p);
					RailwayDB.waitingList.add(t);
					Seat.waitingListSeats.remove(Seat.waitingListSeats.first());
					return t;
				}
				break;
			}
			
		}
		if((p.getBerthPreference().equals(BerthPreference.LOWER) && Seat.lowerBerthSeats.size() > 0) || (p.getBerthPreference().equals(BerthPreference.MIDDLE) && Seat.middleBerthSeats.size() > 0) || (p.getBerthPreference().equals(BerthPreference.UPPER) && Seat.upperBerthSeats.size() > 0))
		{
			if(p.getBerthPreference().equals(BerthPreference.LOWER))
			{
				t.setAllotedBerth(BerthPreference.LOWER);
				t.setSeatNumber(Seat.lowerBerthSeats.first());
				RailwayDB.bookedTickets.put(t, p);
				Seat.lowerBerthSeats.remove(Seat.lowerBerthSeats.first());
				return t;
			}
			if(p.getBerthPreference().equals(BerthPreference.MIDDLE))
			{
				t.setAllotedBerth(BerthPreference.MIDDLE);
				t.setSeatNumber(Seat.middleBerthSeats.first());
				RailwayDB.bookedTickets.put(t, p);
				Seat.middleBerthSeats.remove(Seat.middleBerthSeats.first());
				return t;
			}
			if(p.getBerthPreference().equals(BerthPreference.UPPER))
			{
				t.setAllotedBerth(BerthPreference.UPPER);
				t.setSeatNumber(Seat.upperBerthSeats.first());
				RailwayDB.bookedTickets.put(t, p);
				Seat.upperBerthSeats.remove(Seat.upperBerthSeats.first());
				return t;
			}
			
		}
		
		//AvailableTicketsGiven
		else if(Seat.lowerBerthSeats.size()>0)
		{
			t.setAllotedBerth(BerthPreference.LOWER);
			t.setSeatNumber(Seat.lowerBerthSeats.first());
			RailwayDB.bookedTickets.put(t, p);
			Seat.lowerBerthSeats.remove(Seat.lowerBerthSeats.first());
			return t;
		}
		else if(Seat.middleBerthSeats.size()>0)
		{
			t.setAllotedBerth(BerthPreference.MIDDLE);
			t.setSeatNumber(Seat.middleBerthSeats.first());
			RailwayDB.bookedTickets.put(t, p);
			Seat.middleBerthSeats.remove(Seat.middleBerthSeats.first());
			return t;
		}
		else if(Seat.upperBerthSeats.size()>0)
		{
			t.setAllotedBerth(BerthPreference.UPPER);
			t.setSeatNumber(Seat.upperBerthSeats.first());
			RailwayDB.bookedTickets.put(t, p);
			Seat.upperBerthSeats.remove(Seat.upperBerthSeats.first());
			return t;
		}
		else if(Seat.racSeats.size()>0)
		{
			t.setAllotedBerth(BerthPreference.RAC);
			t.setSeatNumber(Seat.racSeats.first());
			RailwayDB.bookedTickets.put(t, p);
			RailwayDB.racList.add(t);
			Seat.racSeats.remove(Seat.racSeats.first());
			return t;
		}
		else if(Seat.waitingListSeats.size()>0)
		{
			t.setAllotedBerth(BerthPreference.WL);
			t.setSeatNumber(Seat.waitingListSeats.first());
			RailwayDB.bookedTickets.put(t, p);
			RailwayDB.waitingList.add(t);
			Seat.waitingListSeats.remove(Seat.waitingListSeats.first());
			return t;
		}
		return t;
		
	}
	
	public static boolean cancelTicket(int id)										//Cancellation
	{
		boolean temp=false;
		if(RailwayDB.bookedTickets.size()==0)
		{
			return temp;
		}
		else 
		{
			for(Entry<Ticket, Passenger> m : RailwayDB.bookedTickets.entrySet())
			{
				if(m.getKey().getTicketId()==id)
				{
					temp=true;
					int cancelledSeatNumber=m.getKey().getSeatNumber();
					BerthPreference cancelledBerth=m.getKey().getAllotedBerth();
					RailwayDB.bookedTickets.remove(m.getKey());
					
					if(RailwayDB.racList.size()>0)
					{
						allotCancelledTicket(cancelledSeatNumber,cancelledBerth);
						break;
					}
					else
					{
						if(cancelledBerth==BerthPreference.LOWER)
						{
							Seat.lowerBerthSeats.add(cancelledSeatNumber);
						}
						if(cancelledBerth==BerthPreference.MIDDLE)
						{
							Seat.middleBerthSeats.add(cancelledSeatNumber);
						}
						if(cancelledBerth==BerthPreference.UPPER)
						{
							Seat.upperBerthSeats.add(cancelledSeatNumber);
						}
						break;
					}
				}	
			}
			
			return temp;
		}
	}
	private static void allotCancelledTicket(int number,BerthPreference berth)
	{
	
			Ticket passengerFromRAC=RailwayDB.racList.poll();
			int cancelledRacSeatNumber=passengerFromRAC.getSeatNumber();
			BerthPreference cancelledRacBerth=passengerFromRAC.getAllotedBerth(); 
			passengerFromRAC.setSeatNumber(number);
			passengerFromRAC.setAllotedBerth(berth);
			
			if(RailwayDB.waitingList.size()>0)
			{
				Ticket passengerFromWaitingList=RailwayDB.waitingList.poll();
				
				Seat.waitingListSeats.add(passengerFromWaitingList.getSeatNumber());
				passengerFromWaitingList.setSeatNumber(cancelledRacSeatNumber);
				passengerFromWaitingList.setAllotedBerth(cancelledRacBerth);
				RailwayDB.racList.add(passengerFromWaitingList);
			}
			else
			{
				Seat.racSeats.add(passengerFromRAC.getSeatNumber());
			}	
	}
}
