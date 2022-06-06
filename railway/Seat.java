package railway;


import java.util.SortedSet;
import java.util.TreeSet;

public class Seat 
{
	static SortedSet<Integer> lowerBerthSeats = new TreeSet<Integer>();  
	static SortedSet<Integer> middleBerthSeats = new TreeSet<Integer>();
	static SortedSet<Integer> upperBerthSeats = new TreeSet<Integer>();
	static SortedSet<Integer> racSeats = new TreeSet<Integer>();
	static SortedSet<Integer> waitingListSeats = new TreeSet<Integer>();
	
	
	
	public static boolean fixSeatNumbers(int numberOfTickets)
	{
		int availableWaitingList;
		int availableRAC;
		int availableLowerBerth;
		int availableMiddleBerth;
		int availableUpperBerth;
		availableRAC = ((15*numberOfTickets)/100);
		for(int i=1;i<=availableRAC;i++)
		{
			racSeats.add(i);	 
		}
		
		availableWaitingList=((10*numberOfTickets)/100);
		for(int i=1;i<=availableWaitingList;i++)
		{
			waitingListSeats.add(i);	 
		}
		
		int availableConfirmedSeats=numberOfTickets-(availableRAC+availableWaitingList);
		int dividedSeats=availableConfirmedSeats%3;
		int seats=availableConfirmedSeats/3;
		if(dividedSeats==0)
		{
			availableLowerBerth=seats;
			for(int i=1;i<=availableLowerBerth;i++)
			{
				lowerBerthSeats.add(i);	 
			}
			availableMiddleBerth=seats;
			for(int i=1;i<=availableMiddleBerth;i++)
			{
				middleBerthSeats.add(i);	 
			}
			availableUpperBerth=seats;
			for(int i=1;i<=availableUpperBerth;i++)
			{
				upperBerthSeats.add(i);	 
			}
		}
		else if(dividedSeats==1)
		{
			availableLowerBerth=seats+1;
			for(int i=1;i<=availableLowerBerth;i++)
			{
				lowerBerthSeats.add(i);	 
			}
			availableMiddleBerth=seats;
			for(int i=1;i<=availableMiddleBerth;i++)
			{
				middleBerthSeats.add(i);	 
			}
			availableUpperBerth=seats;
			for(int i=1;i<=availableUpperBerth;i++)
			{
				upperBerthSeats.add(i);	 
			}
		}
		else if(dividedSeats==2)
		{
			availableLowerBerth=seats+1;
			for(int i=1;i<=availableLowerBerth;i++)
			{
				lowerBerthSeats.add(i);	 
			}
			availableMiddleBerth=seats+1;
			for(int i=1;i<=availableMiddleBerth;i++)
			{
				middleBerthSeats.add(i);	 
			}
			availableUpperBerth=seats;
			for(int i=1;i<=availableUpperBerth;i++)
			{
				upperBerthSeats.add(i);	 
			}
		}
		return true;
	}
}
