package cse360assign2;

/**
 * assignment 2
 * @author Praveen Kumar Panku
 * @classID 219
 * @since 02/25/2020
 *
 */

/* a simple list class containing operations on list such as add an element, remove an element
 * get count of element etc. 
 */

public class SimpleList {
	
	private int[] list;
	private int count = 0;
	
	/**
	 * Constructor. Create an array to hold 10 integers and set count to 0.
	 */
	public SimpleList()
	{
		 
		count = 0;
		list = new int[10];
	}
	
	/**
	 * Add the parameter to the list at the beginning
	 * @param element
	 * @return void
	 */
	public void add(int element)
	{
		
		if(count == 0)
		{
			count++;
			list[0] = element;
			return;
		}
		if(count == 10)
			count = 9;
		for(int i = count;i > 0;i--)
		{
			list[i] = list[i-1];
		}
		list[0] = element;
		if(count != 10)
			count++;
	}
	
	/**
	 * Removes a given element of the list
	 * @param element
	 */
	public void remove(int element)
	{
		int pos = search(element);
		if(pos == -1)
			return;
		for(int i = pos;i < count - 1;i++)
		{
			list[i] = list[i+1];
		}
		list[count-1] = 0;
		count--;
	}
	
	/**
	 *  gives number of elements in the list
	 * @return number of elements
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Get list as string
	 * @return a string containing elements of list
	 */
	public String toString()
	{
		String listString = "";
		for(int index = 0;index < count;index++)
		{
			listString = listString + " " + Integer.toString(list[index]); 
		}
		return listString.trim();
	}
	
	/**
	 * Gets the location of the parameter in the list
	 * @param element
	 * @return index of element
	 */
	public int search(int element)
	{
		
		for(int index = 0;index < count;index++)
		{
			if(list[index] == element)
				return index;
		}
		return -1;
	}
}
