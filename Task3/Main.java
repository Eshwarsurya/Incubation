package Project;

import java.util.*;

public class Main 
{

	public static void main(String[] args) throws Exception
	{
		
		while(true)
			{
				try
				{
					System.out.println("Select an option: 1.Stack  2.Queue 3.Exit");
					Scanner input=new Scanner(System.in);
					int option=input.nextInt();
					switch(option)
					{
						case 1 : stackFunction(); break;
						case 2 : queueFunction(); break;
						case 3 : break;
						default : System.out.println("Enter correct option");break;
					}
					if(option==3)
					{
						break;
					}
				}
				catch(InputMismatchException e)
				{
					System.out.println("select correct option");
				}
			}
		
	}
	
	
	
	private static void stackFunction() throws Exception
	{
		
		StackMethods stack=new StackMethods();
		
		while(true)
		{
			try
			{
			System.out.println("Select the operation : 1.Push 2.Pop 3.Peek 4.Size 5.Display 6.Exit");
			Scanner sc=new Scanner(System.in);
			int value=sc.nextInt();
			switch(value)
			{
				case 1 : stack.push();break;
				case 2 : System.out.println(stack.pop());break;
				case 3 : System.out.println(stack.peek()); break;
				case 4 : System.out.println(stack.Size()); break;
				case 5 : stack.display();break;
				case 6 : break;
				default : System.out.println("Enter correct operation");
			}
		
			if(value==6)
				break;
			}
			catch(InputMismatchException e)
			{
				System.out.println("select correct option");
			
			}
		}
	}
	
	
	
	private static void queueFunction()
	{
		QueueMethods queue=new QueueMethods();
	while(true)
	{
		try
		{
		System.out.println("Select the operation : 1.Enqueue 2.Dequeue 3.Peek 4.Poll 5.Size 6.Display 7.Exit");
		Scanner sc=new Scanner(System.in);
		int value=sc.nextInt();
		switch(value)
		{
			case 1 : queue.enqueue();break;
			case 2 : System.out.println(queue.dequeue());break;
			case 3 : System.out.println(queue.peek()); break;
			case 4 : System.out.println(queue.poll()); break;
			case 5 : System.out.println(queue.Size()); break;
			case 6 : queue.display();break;
			case 7 : break;
			default : System.out.println("Enter correct operation");
		}
		
		if(value==7)
			break;
		}
		catch(InputMismatchException e)
		{
			System.out.println("select correct option");
		}
	}
		
	}
}
