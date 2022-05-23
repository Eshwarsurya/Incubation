package Project;

import java.util.*;

public class QueueMethods<T> {
	private Node head;
	private Node tail;
	private int size;
	public QueueMethods()
	{
		this.size=0;
	}
	public void enqueue()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter value to be inserted:");
		T val=(T)input.next();
		Node node=new Node(val);
		node.next=head;
		head=node;
		if(tail==null)
		{
			tail=head;
		}
		size+=1;
	}
	public Node get(int index)
	{
		Node node=head;
		for(int i=0;i<index;i++)
		{
			node=node.next;
		}
		return node;
	}
	public T poll()
	{
			if(tail==null)
				{
					return null;
				}
			else 
			{
				if(size<=1)
				{
					T value=(T)head.data;
					head=head.next;
					if(head==null)
					{
						tail=head;
					}
					size--;
					return value;
				}
				else
				{
				Node secondLast=get(size-2);
				T value=(T)tail.data;
				tail=secondLast;
				tail.next=null;
				size--;
				return value;
				}
			}
	}
	public T dequeue() 
	{
		try
		{
			if(size<=1)
			{
				T value=(T)head.data;
				head=head.next;
				if(head==null)
				{
					tail=head;
				}
				size--;
				return value;
			}
			else
			{
			Node secondLast=get(size-2);
			T value=(T)tail.data;
			tail=secondLast;
			tail.next=null;
			size--;
			return value;
			}
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	//Peek
	
	public T peek()
	{
		if(size==0)
			return null;
		else
		 return (T)head.data;
	}
	
	//Size
	
	public int Size()
	{
		return size;
	}
	
	//Display
	
	public void display()
	{
		if(head==null)
			System.out.println("Queue is empty");
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+",");
			temp=temp.next;
		}
	}
	
	private class Node<T>
	{
		private T data;
		private Node next;
		public Node(T data)
		{
			this.data=data;
		}

	}
}
