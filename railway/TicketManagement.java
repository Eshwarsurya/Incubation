package railway;

import java.util.Map.Entry;

public class TicketManagement 
{
	
	public static boolean bookTicket(Passenger p)
	{
		if(Seat.waitingListSeats.size()==0)
		{
			return false;
		}
		else if(p.getAge()> 60  && Seat.lowerBerthSeats.size() > 0)
		{
			if(Seat.lowerBerthSeats.size()>0)
			{
				allotTicket(p,(Seat.lowerBerthSeats.first()),BerthPreference.LOWER);
				Seat.lowerBerthSeats.remove(Seat.lowerBerthSeats.first());
				
			}
			else if(Seat.middleBerthSeats.size()>0)
			{
				allotTicket(p,(Seat.middleBerthSeats.first()),BerthPreference.MIDDLE);
				Seat.middleBerthSeats.remove(Seat.middleBerthSeats.first());
				
			}
			else if(Seat.upperBerthSeats.size()>0)
			{
				allotTicket(p,(Seat.upperBerthSeats.first()),BerthPreference.UPPER);
				Seat.upperBerthSeats.remove(Seat.upperBerthSeats.first());
				
			}
			else if(Seat.racSeats.size()>0)
			{
				allotTicket(p,(Seat.racSeats.first()),BerthPreference.RAC);
				Seat.racSeats.remove(Seat.racSeats.first());
				
			}
			else if(Seat.waitingListSeats.size()>0)
			{
				allotTicket(p,(Seat.waitingListSeats.first()),BerthPreference.WL);
				Seat.waitingListSeats.remove(Seat.waitingListSeats.first());
				
			}
			return true;
		}
		else if((p.getBerthPreference().equals(BerthPreference.LOWER) && Seat.lowerBerthSeats.size() > 0) || (p.getBerthPreference().equals(BerthPreference.MIDDLE) && Seat.middleBerthSeats.size() > 0) || (p.getBerthPreference().equals(BerthPreference.UPPER) && Seat.upperBerthSeats.size() > 0))
		{
			if(p.getBerthPreference().equals(BerthPreference.LOWER))
			{
				allotTicket(p,(Seat.lowerBerthSeats.first()),BerthPreference.LOWER);
				Seat.lowerBerthSeats.remove(Seat.lowerBerthSeats.first());
				
			}
			if(p.getBerthPreference().equals(BerthPreference.MIDDLE))
			{
				allotTicket(p,(Seat.middleBerthSeats.first()),BerthPreference.MIDDLE);
				Seat.middleBerthSeats.remove(Seat.middleBerthSeats.first());
				
			}
			if(p.getBerthPreference().equals(BerthPreference.UPPER))
			{
				allotTicket(p,(Seat.upperBerthSeats.first()),BerthPreference.UPPER);
				Seat.upperBerthSeats.remove(Seat.upperBerthSeats.first());
			}
			
			return true;
		}
		
		//AvailableTicketsGiven
		else if(Seat.lowerBerthSeats.size()>0)
		{
			allotTicket(p,(Seat.lowerBerthSeats.first()),BerthPreference.LOWER);
			Seat.lowerBerthSeats.remove(Seat.lowerBerthSeats.first());
			return true;
		}
		else if(Seat.middleBerthSeats.size()>0)
		{
			allotTicket(p,(Seat.middleBerthSeats.first()),BerthPreference.MIDDLE);
			Seat.middleBerthSeats.remove(Seat.middleBerthSeats.first());
			return true;
		}
		else if(Seat.upperBerthSeats.size()>0)
		{
			allotTicket(p,(Seat.upperBerthSeats.first()),BerthPreference.UPPER);
			Seat.upperBerthSeats.remove(Seat.upperBerthSeats.first());
			return true;
		}
		else if(Seat.racSeats.size()>0)
		{
			allotTicket(p,(Seat.racSeats.first()),BerthPreference.RAC);
			Seat.racSeats.remove(Seat.racSeats.first());
			return true;
		}
		else if(Seat.waitingListSeats.size()>0)
		{
			allotTicket(p,(Seat.waitingListSeats.first()),BerthPreference.WL);
			Seat.waitingListSeats.remove(Seat.waitingListSeats.first());
			return true;
		}
		
		else
		{
			return false;
		}
		
		
	}
	
	private static boolean allotTicket(Passenger p,int seatNumber,BerthPreference allotedBerth)
	{
		Ticket t=new Ticket();
		t.setAllotedBerth(allotedBerth);
		t.setSeatNumber(seatNumber);
		RailwayDB.bookedTickets.put(t, p);
		if(allotedBerth==BerthPreference.RAC)
		{
			RailwayDB.racList.add(t);
		}
		if(allotedBerth==BerthPreference.WL)
		{
			RailwayDB.waitingList.add(t);
		}
		return true;
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
				if(m.getKey().getId()==id)
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
