package railway;

import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

public class RailwayReservation 
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		boolean loop=true;
		while(loop)
		{
			try
			{
				System.out.println("1.Admin 2.User 3.Exit");
				Scanner sc=new Scanner(System.in);
				int choice=sc.nextInt();
				if(choice==1)
				{
					Scanner var=new Scanner(System.in);
					System.out.println("Enter the username");
					String uName=var.nextLine();
					System.out.println("Enter password");
					String pWord=var.nextLine();
					if(Admin.validate(uName,pWord))
					{
						System.out.println("Enter the total number of tickets");
						Scanner scan=new Scanner(System.in);
						int noOfTickets=scan.nextInt();
						Seat.fixSeatNumbers(noOfTickets);
						if(Seat.fixSeatNumbers(noOfTickets))
						{
							System.out.println("Seats alloted");
						}
						else
						{
							System.out.println("Enter correctly");
						}
					}
					else
					{
						System.out.println("Username or Password is incorrect");
					}
				}
				
				if(choice==2)
				{
					boolean temp=true;
					while(temp)
					{
					  try
					  {
						sc=new Scanner(System.in);
						System.out.println("1.Book 2.Cancel 3.Available Tickets 4.Booked Tickets 5.Exit");
						int userChoice=sc.nextInt();
							switch(userChoice)
							{
								case 1:
									{
										Passenger p=new Passenger();
										Scanner var=new Scanner(System.in);
										System.out.println("Enter the Passenger Name:");
										String name=var.next();
										p.setName(name);
										System.out.println("Enter the Passenger Age:");
										while(true)
										{
											try
											{
												var=new Scanner(System.in);
												int age=var.nextInt();
												p.setAge(age);
												break;
											}
											catch(InputMismatchException e)
											{
												System.out.println("Enter correctly");
											}
										}
										System.out.println("Choose the Passenger Gender: 1.MALE 2.FEMALE 3.TRANSGENDER"); 
										while(true)
										{
											try
											{
												var=new Scanner(System.in);
												int gender=var.nextInt();
												switch(gender)
												{
													case 1 :
														{
															p.setGender(Gender.MALE);
															break;
														}
													case 2 :
														{
															p.setGender(Gender.FEMALE);
															System.out.println("Are you traveling with your child whose age is below 5?  1.Yes 2.No");
															var=new Scanner(System.in);
															int child=var.nextInt();
															if(child==1)
															{
																var=new Scanner(System.in);
																System.out.println("Enter child name");
																String childName=var.nextLine();
																RailwayDB.childDB.put(p.getPassengerId(), childName);
																break;
																
															}
															else if(child==2)
															{
																break;
															}
															else
															{
																System.out.println("Enter correct option");
															}
														}
													case 3 :
														{
															p.setGender(Gender.TRANSGENDER);
															break;
														}
													default :
													{
														System.out.println("Choose correct option");
														continue;
													}
												}
												break;
											}
											catch(InputMismatchException e)
											{
												System.out.println("Enter corrrectly");
											}
										}
										if(p.getAge()<60)
										{
										System.out.println("Choose the Berth Preference : 1.LOWER 2.MIDDLE 3.UPPER");
										while(true)
										{
											try
											{
												var=new Scanner(System.in);
												int berthPreference=var.nextInt();
												switch(berthPreference)
												{
													case 1 :
														{
															p.setBerthPreference(BerthPreference.LOWER);
															break;
														}
													case 2 :
														{
															p.setBerthPreference(BerthPreference.MIDDLE);
															break;
														}
													case 3 :
														{
															p.setBerthPreference(BerthPreference.UPPER);
															break;
														}
													default :
													{
														System.out.println("Choose correct option");
														continue;
													}
												}
												break;
											}
											catch(InputMismatchException e)
											{
												System.out.println("Enter corrrectly");
											}
										}
										}
										
//										if(TicketManagement.bookTicket(p))
//										{
//											System.out.println("Booked Successfully");
//											
//										}
//										else
//										{
//											System.out.println("No tickets available");
//										}
										if(Seat.waitingListSeats.size()==0)
										{
											System.out.println("No tickets available");
										}
										else
										{
										
											Ticket t=TicketManagement.bookTicket(p);
											if(t!=null)
											{
												if(p.getGender()==Gender.FEMALE)
												{
													if(RailwayDB.childDB.size()==0)
													{
														System.out.println("Ticket Number:" +t.getTicketId());
														System.out.println("Passenger Name:" + p.getName());
														System.out.println("Passenger Age:" +p.getAge());
														System.out.println("Passenger Gender:" + p.getGender());
														System.out.println("Alloted Seat: "+t.getSeatNumber()+t.getAllotedBerth());
														System.out.println("Booked successfully");
														break;
													}
													else
													{
														for(Entry<Integer,String> c: RailwayDB.childDB.entrySet())
														{
															
															if(c.getKey()==p.getPassengerId()&&c.getValue()!=null)
															{
																System.out.println("You have child so we allot lower berth");
																System.out.println("Ticket Number:" +t.getTicketId());
																System.out.println("Passenger Name:" + p.getName());
																System.out.println("Passenger Age:" +p.getAge());
																System.out.println("Passenger Gender:" + p.getGender());
																System.out.println("Child name:" +c.getValue());
																System.out.println("Alloted Seat: "+t.getSeatNumber()+t.getAllotedBerth());
																System.out.println("Booked successfully");
																break;
															}
															else if(!(RailwayDB.childDB.containsKey(p.getPassengerId())))
															{
																System.out.println("Ticket Number:" +t.getTicketId());
																System.out.println("Passenger Name:" + p.getName());
																System.out.println("Passenger Age:" +p.getAge());
																System.out.println("Passenger Gender:" + p.getGender());
																System.out.println("Alloted Seat: "+t.getSeatNumber()+t.getAllotedBerth());
																System.out.println("Booked successfully");
																break;
															}
														}
													}
												}
												else
												{
													System.out.println("Ticket Number:" +t.getTicketId());
													System.out.println("Passenger Name:" + p.getName());
													System.out.println("Passenger Age:" +p.getAge());
													System.out.println("Passenger Gender:" + p.getGender());
													System.out.println("Alloted Seat: "+t.getSeatNumber()+t.getAllotedBerth());
													System.out.println("Booked successfully");
												}
											}
											else
											{
												System.out.println("Booking interupted.please try again");
											}
											
										}
										
									}
									break;
									
								case 2: 
									{
										Scanner input=new Scanner(System.in);
										System.out.println("Enter the Ticket number:");
										int id=input.nextInt();
										if(TicketManagement.cancelTicket(id))
										{
											System.out.println("Ticket cancelled succuessfully");
										}
										else
										{
											System.out.println("No passenger id found");
										}
										break;
									}
								case 3: 
									{
										availableTickets();
										break;
									}
								case 4: 
									{
										bookedTickets();
										break;
									}
										
								case 5: 
									{
										temp=false;
										break;
									}
										
								default: 
								{
									System.out.println("Enter correct option");
								}
									
							}
					  }
					  catch(InputMismatchException e)
					  {
						  System.out.println("Enter correctly");
					  }
					}
				}
				
				else if(choice==3)
				{
					loop=false;
					
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter correct option");
			}
		}
	}
	
	public static void availableTickets()
	{
		System.out.println("Available LowerBerth : "+Seat.lowerBerthSeats.size());
		System.out.println("Available MiddleBerth : "+Seat.middleBerthSeats.size());
		System.out.println("Available UpperBerth : "+Seat.upperBerthSeats.size());
		System.out.println("Available RAC : "+Seat.racSeats.size());
		System.out.println("Available Waiting : "+Seat.waitingListSeats.size());
	}
	
	public static void bookedTickets()
	{
		if(RailwayDB.bookedTickets.size() == 0)
		{
			System.out.println("No Passengers Detail Found");
			return;
		}
		else
		{
			for(Entry<Ticket, Passenger> m : RailwayDB.bookedTickets.entrySet())
			{
				if(RailwayDB.childDB.containsKey(m.getValue().getPassengerId()))
				{
					System.out.println("Ticket Number:" + m.getKey().getTicketId());
					System.out.println("Passenger Name:" + m.getValue().getName());
					System.out.println("Passenger Age:" + m.getValue().getAge());
					System.out.println("Passenger Gender:" + m.getValue().getGender());
					for(Entry<Integer,String> c:RailwayDB.childDB.entrySet())
					{
						if(c.getKey()==m.getValue().getPassengerId())
						{
							System.out.println("Child Name:"+c.getValue());
						}
					}
					System.out.println("Alloted Seat: "+m.getKey().getSeatNumber()+m.getKey().getAllotedBerth());
					System.out.println("---------------------------------");
				}
				else
				{
					System.out.println("Ticket Number:" + m.getKey().getTicketId());
					System.out.println("Passenger Name:" + m.getValue().getName());
					System.out.println("Passenger Age:" + m.getValue().getAge());
					System.out.println("Passenger Gender:" + m.getValue().getGender());
					System.out.println("Alloted Seat: "+m.getKey().getSeatNumber()+m.getKey().getAllotedBerth());
					System.out.println("---------------------------------");
				}
			}
		}
	}
}
