package Project;

import java.util.*;
public class StackMethods<T> {
	private Node head;
	private Node tail;
	private int size;
	
	
	public StackMethods()
	{
		this.size=0;
	}
	
	
	public void push()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value to be inserted:");
		T val=(T)sc.nextLine();
		Node node=new Node(val);
		node.next=head;
		head=node;
		if(tail==null)
		{
			tail=head;
		}
		size+=1;
	}
	
	
	public T pop() throws Exception
	{
		try
		{
	
		T value=(T)head.data;
		head=head.next;
		size--;
		return value;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
//			throw new Exception("No elements in stack");
			return null;
		}
	}
	
	
	public T peek()
	{
		try
		{
		T value=(T)head.data;
		return value;
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public void display()
	{
		if(size==0)
		{
			System.out.print("Stack is empty");
		}
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+",");
			temp=temp.next;
		}
		System.out.println("\n");
	}
	
	
	
	public int Size()
	{
		
		return size;
	}
	
	
	class Node<T >
	{
		private T data;
		private Node next;
		public Node(T data)
		{
			this.data=data;
		}
	}
}
