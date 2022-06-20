package Task5;

import java.util.Scanner;
public class Main 
{
	@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
	public static void main(String[] args) 
	{
		CustomArrayList<CustomLinkedList> list=new CustomArrayList<CustomLinkedList>();
		boolean exitLoop=true;
		while(exitLoop)
		{
			CustomLinkedList obj=new CustomLinkedList();
			boolean loop=true;
			while(loop)
			{
				try
				{
					Scanner sc = new Scanner(System.in);
					System.out.print("=>");
					String[] command=sc.nextLine().split(" ");
					if(command[0].equalsIgnoreCase("SET"))
					{
						if(obj.set(command[1],command[2]))
						{
							System.out.println("set successfully");
						}
						else
						{
							System.out.println("please try again");
						}
					}
					else if(command[0].equalsIgnoreCase("GET"))
					{
						if(list.size()==0)
						{
							System.out.println(obj.getValue(command[1])); 
						}
						else
						{
							boolean check=false;
							for(int j=list.size()-1;j>=0;j--)
							{
								if(obj.containsKey(command[1]))
								{
									System.out.println(obj.getValue(command[1]));
									check=false;
									break;
								}
								else if(list.get(j).containsKey(command[1]))
								{
									System.out.println(list.get(j).getValue(command[1]));
									check=false;
									break;
								}
								else
								{
									check=true;
								}
							}
							if(check)
							{
								System.out.println("null");
							}
						}
					}
					else if(command[0].equalsIgnoreCase("UNSET"))
					{
						if(list.size()==0)
						{
							if((obj.remove(command[1])))
							{
								System.out.println("Unset successfully");
							}
							else
							{
								System.out.println("Variable not found");
							}
						}
						else if(obj.containsKey(command[1]))
						{
							if((obj.remove(command[1])))
							{
								System.out.println("Unset successfully");
							}
							else
							{
								System.out.println("Variable not found");
							}
						}
						else
						{
							boolean check=false;
							for(int j=list.size()-1;j>=0;j--)
							{
								if(list.get(j).containsKey(command[1]))
								{
									check=true;
								}
							}
							if(check)
							{
								obj.set(command[1],null);
							}
							else
							{
								System.out.println("Variable not found");
							}
					
						}
					}
					
					else if(command[0].equalsIgnoreCase("UPDATE"))
					{
						if(list.size()==0)
						{
							if(obj.update(command[1].trim(), command[2].trim()))
							{
								System.out.println("Updated successfully");
							}
							else
							{
								System.out.println("No variable named \""+command[1]+"\"");
							}
						}
						else if(obj.containsKey(command[1]))
						{
							if(obj.update(command[1].trim(), command[2].trim()))
							{
								System.out.println("Updated successfully");
							}
						}
						else
						{
							boolean check=false;
							for(int j=list.size()-1;j>=0;j--)
							{
								if(list.get(j).containsKey(command[1]))
								{
									check=true;
								}
							}
							if(check)
							{
								obj.set(command[1].trim(), command[2].trim());
								System.out.println("Updated successfully");
							}
							else
							{
								System.out.println("No variable named \""+command[1]+"\"");
							}
						}
						
					}
					else if(command[0].equalsIgnoreCase("COUNT"))
					{
						if(list.size()==0)
						{
							int count=obj.countValue(command[1]);
							if(count==0)
							{
								System.out.println("null");
							}
							else
							{
								System.out.println(count);
							}
						}
						else
						{
							int count=0;
							CustomArrayList<CustomLinkedList> list1=new CustomArrayList<CustomLinkedList>();
							list1.add(obj);
							for(int i=0;i<list.size();i++)
							{
								list1.add(list.get(i));
							}
							CustomLinkedList allValues=new CustomLinkedList();
							for(int j=0;j<list1.size();j++)
							{
								Node temp=list1.get(j).head;
								if(temp!=null)
								{
									while(temp.next!=null)
									{
										if(temp.value!=null)
										{
											allValues.set(temp.key, temp.value);
											temp=temp.next;
										}
										else
										{
											temp=temp.next;
										}
									}
									if(temp.next==null&&temp.value!=null)
									{
										allValues.set(temp.key, temp.value);
									}
									if(temp.value!=null)
									{
										allValues.set(temp.key, temp.value);
									}
								}
							}
							if(allValues.head!=null)
							{
								Node node1=allValues.head;
								Node node2=node1.next;
								while(node1.next!=null)
								{
									if((node1.value!=null)&&!(node1.value.equals(command[1])))
									{
										node1=node1.next;
									}
									else
									{
										while(node2.next!=null)
										{
											if((node2.value!=null)&&node2.value.equals(command[1])&&node2.key.equals(node1.key))
											{
												node2.value=null;
												node2=node2.next;
											}
											else
											{
												node2=node2.next;
											}
										}
										if(node2.next==null)
										{
											if((node2.value!=null)&&node2.value.equals(command[1])&&node2.key.equals(node1.key))
											{
												node2.value=null;
											}
											node1=node1.next;
											node2=node1.next;
										}
									}
								}
							}
							Node temp=allValues.head;
							if(temp!=null)
							{
								while(temp.next!=null)
								{
									if(!(temp.value==null)&&temp.value.equals(command[1]))
									{
										count++;
										temp=temp.next;
									}
									else
									{
										temp=temp.next;
									}
								}
								if(temp.next==null)
								{
									if(temp.value!=null&&temp.value.equals(command[1]))
									{
										count++;
									}
								}
							}
							System.out.println(count);
						}
					}
					else if(command[0].equalsIgnoreCase("EXIT"))
					{
						
						loop=false;
						exitLoop=false;
						
					}
					else if(command[0].equalsIgnoreCase("BEGIN"))
					{
						list.add(obj);
						loop=false;
						
					}  
					else if(command[0].equalsIgnoreCase("ROLLBACK"))
					{
						if(list.size()!=0)
						{
							list.add(obj);
							list.remove(list.size()-1);
//							list1.remove(list.size()-1);
							obj=list.get(list.size()-1);	
						}
					}
					else if(command[0].equalsIgnoreCase("COMMIT"))
					{
						if(list.size()!=0)
						{
							list.add(obj);
							obj=list.get(list.size()-2);
							CustomLinkedList obj1=list.get(list.size()-1);
							list.remove(list.size()-1);
							if(obj1.size()!=0)
							{
								Node temp=obj1.head;
								while(temp.next!=null)
								{
									obj.set(temp.key, temp.value);
									temp=temp.next;
								}
								if(temp.next==null)
								{
									obj.set(temp.key, temp.value);
								}
							}
						}
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println("Enter the corect command");
				}
				
			}

		}

	}
}
