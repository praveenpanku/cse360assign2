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
	private int listSize = 10;
	
	/**
	 * Constructor. Create an array to hold 10 integers and set count to 0.
	 */
	public SimpleList()
	{
		
		count = 0;
		list = new int[listSize];
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
		
		if(count == listSize)
		{
			if(listSize == 1)       //because (int)1 * 1.5 = 1; 
				listSize = 2;
			else 
				listSize = (int) (listSize * 1.5);
			
			int[] newList = new int[listSize];
			for(int index = 0;index < count; index++)
				newList[index] = list[index];
			list = newList;
		}
		
		for(int index = count;index > 0; index--)
		{
			list[index] = list[index-1];
		}
		list[0] = element;
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
		
		if(count < (int)(listSize*0.75))
		{
			listSize = (int) (listSize*0.75);
			int[] newList = new int[listSize];
			for(int index = 0;index < count; index++)
				newList[index] = list[index];
			list = newList;
		}
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
	
	/**
	 * Appends an integer at end of list. Increments list size 
	 * 	by 50% when list is full.
	 * @param element to be appended 
	 */
	public void append(int element)
	{
		if(count == listSize)
		{
			if(listSize == 1)
				listSize = 2;
			else 
				listSize = (int) (listSize * 1.5);
			
			int[] newList = new int[listSize];
			for(int index = 0;index < count; index++)
				newList[index] = list[index];
			list = newList;
		}
		
		list[count] = element;
		count++;
	}
	
	/**
	 * 
	 * @return first element of list
	 */
	public int first()
	{
		if(count == 0)
			return -1;
		return list[0];
	}
	
	/**
	 * 
	 * @return last element of list
	 */
	public int last()
	{
		if(count == 0)
			return -1;
		return list[count-1];
	}
	
	/**
	 * 
	 * @return number of possible locations in list
	 */
	public int size()
	{
		return listSize;
	}
	
	public static void main(String[] args)
	{
		SimpleList a = new SimpleList();
		a.add(10);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(20);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(30);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(40);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(50);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(60);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(70);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(80);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(40);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(30);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(20);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.append(5);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.append(3);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.append(3);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(50);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(60);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(70);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(80);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(10);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(5);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(3);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.remove(3);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(10);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(20);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(20);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(20);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
		a.add(20);
		System.out.println(a.listSize + "  " + a.count + "  " + a.toString());
	}

	
}
