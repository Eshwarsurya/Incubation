package Task5;
@SuppressWarnings({"rawtypes","unchecked"})
public class CustomLinkedList
{
	public Node head;
	public Node tail;
	private  int size;

	public  boolean set(Object key,Object value)
	{
		boolean check=false;
		Node temp=head;
		if(size!=0)
		{
			if(temp.next==null)
			{
				if(temp.key.equals(key))
				{
					temp.value=value;
					check=true;
				}
				else
				{
					Node node=new Node(key,value);
					node.next=head;
					head=node;
					if(tail==null)
					{
						tail=head;
					}
					size+=1;
					check=true;
				}
			}
			else
			{
			while(temp.next	!=null)
			{
				if(temp.key.equals(key))
				{
					temp.value=value;
					check=true;
					break;
				}
				else
				{
					
					Node node=new Node(key,value);
					node.next=head;
					head=node;
					if(tail==null)
					{
						tail=head;
					}
					size+=1;
					check=true;
					break;
				}
			}
		}
		}
		else
		{
			Node node=new Node(key,value);
			node.next=head;
			head=node;
			if(tail==null)
			{
				tail=head;
			}
			size+=1;
			check=true;
		}
		return check;
	}
	
	public  Object getValue(Object key)
	{
		if(size!=0)
		{
			Node temp=head;
			while(temp!=null)
			{
				if(temp.key.equals(key))
				{
					return temp.value;
				}
				else
				{
					temp=temp.next;
				}
			}
		}
		return null;
	}
	
	public  boolean remove(Object key)
	{
		boolean check=false;
		Node temp=head;
		if(size!=0)
		{
			while(temp.next	!=null)
			{
				if(temp.key.equals(key))
				{
					temp.value=null;
					check=true;
					break;
				}
				else
				{
					temp=temp.next;
					check=false;
				}
			}
			if(temp.next==null)
			{
				if(temp.key.equals(key))
				{
					temp.value=null;
					check=true;
				}
				else
				{
					check=false;
				}
			}
		}
		else
		{
			check=false;
		}
		return check;
	}
	
	public  boolean containsKey(Object key)
	{
		boolean check=false;
		Node temp=head;
		if(size!=0)
		{
			while(temp.next	!=null)
			{
				if(temp.key.equals(key))
				{
					check=true;
					break;
				}
				else
				{
					temp=temp.next;
				}
			}
			if(tail.key.equals(key))
			{
				check=true;
			}
		}
		return check;
	}
	
	public  boolean containsValue(Object value)
	{
		boolean check=false;
		Node temp=head;
		if(size!=0)
		{
			while(temp.next	!=null)
			{
				if(temp.value.equals(value)&& temp.value!=null)
				{
					check=true;
					break;
				}
				else
				{
					temp=temp.next;
				}
			}
			if(temp.value!=null&&tail.value.equals(value))
			{
				check=true;
			}
		}
		return check;
	}
	
	public  boolean update(Object key , Object value)
	{
		boolean check=false;
		if(containsKey(key))
		{
			set(key,value);
			check=true;
		}
		return check;
	}
	
	public  int countValue(Object value)
	{
		int count=0;
		Node temp=head;
		if(size!=0)
		{	
			while(temp.next	!=null)
			{
				if(temp.value==null)
				{
					temp=temp.next;
					
				}
				else if( temp.value.equals(value))
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
					if(temp.value!=null && temp.value.equals(value))
					{
					count++;
					}
				}
		}
		
		return count;
	}
	
	public void display()
	{
		if(size==0)
		{
			System.out.print("List is empty");
		}
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.key+","+temp.value);
			temp=temp.next;
		}
		System.out.println("\n");
	}
	
	public int size()
	{
		return size;
	}

}
		
