package Task5;

import java.util.Arrays;

@SuppressWarnings("hiding")
public class CustomArrayList <CustomLinkedList>
{
	private static int INITIAL_CAPACITY = 10;
	private int size = 0;
	private Object elementData[] = {};

	public CustomArrayList() 
	{
	       elementData = new Object[INITIAL_CAPACITY];
	}
	public void add(CustomLinkedList e) 
	{
	       if (size == elementData.length) 
	       {
	              increaseCapacity(); 
	       }
	       elementData[size++] = e;
	}
	@SuppressWarnings("unchecked")
	public CustomLinkedList get(int index) 
	{
	       if (index < 0 || index > size) {
	              throw new IndexOutOfBoundsException("Index: " + index + ", Size "
	                           + size);
	       }
	       return (CustomLinkedList)elementData[index]; 
	}
	
	public Object remove(int index) 
	{
	    if (index < 0 || index > size) {
	              throw new IndexOutOfBoundsException("Index: " + index + ", Size "
	                           + index);
	       }

	       Object removedElement = elementData[index];
	       for (int i = index; i <= size - 1; i++) {
	              elementData[i] = elementData[i + 1];
	       }
	       size--; 

	       return removedElement;
	}

	private void increaseCapacity() 
	{
	       int newIncreasedCapacity = elementData.length * 2;
	       elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
	      
	}
	
	public void display() 
	{
	       System.out.print("Displaying list : ");
	       for (int i = 0; i < size; i++) {
	              System.out.print(elementData[i] + " ");
	       }
	}
	
	public int size()
	{
		return size;
	}

	
}
