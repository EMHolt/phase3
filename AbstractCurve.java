package phase2;

import java.util.ArrayList;

/**
 * Name: Emma Holt, Ian McGinness, Braden Samson
 * Date: September 2024
 * Hour: 3rd Hour AP CSA
 * Description: AbstractCurve is the parent program for ConsumerCurve and 
 * 	ProducerCurve. It has a basic ArrayList constructor, a constructor 
 * 	that allows for a number of points, start point, and slope. The user can add
 * 	or remove points, as well as print out the points in the ArrayList.
 */

public abstract class AbstractCurve {
	
	protected ArrayList<Point> myCurve; 
	
	/**
	 * Constructs a basic ArrayList with 10 points starting at (1, 1.0) 
	 *   and a slope of +1
	 */
	public AbstractCurve() 
	{
		myCurve = new ArrayList<Point>();
		
		for(int i = 1; i <= 10; i++)
		{
			Point point = new Point (i, (double) i);
			myCurve.add(point);
		}
	}

	/**
	 * Constructs an ArrayList with a certain amount of points, a starting point,
	 * 	and a slope (deltaX & deltaY).
	 * Precondition: AbstractCurve is a linear function, so the slope between each
	 * 	2 points will be the same (when first constructed).
	 * @param n: number of points
	 * @param startPoint: starting point
	 * @param deltaX: change in x value between two given points
	 * @param deltaY: change in y value between two given points
	 */
	public AbstractCurve (int n, Point startPoint, int deltaX, double deltaY)
	{
		int j = 0;
		double k = 0.0;
		myCurve = new ArrayList<>();
		Point point = new Point();
		for(int i = 1; i <= n; i++)
		{
			myCurve.add(point);
		}
		myCurve.set(0, startPoint);
		for(int i = 1; i < n; i++)
		{
			j = j + deltaX;
			k = k + deltaY;
			int x = startPoint.getQuantity() + j;
			double y = startPoint.getPrice() + k;
			myCurve.set(i, new Point(x,y));
		}
		
	}
	
	/**
	 * Prints out each point in the ArrayList
	 * Precondition:myCurve is an ArrayList of (at least 1) valid points
	 */
	public String toString() 
	{
		String str1 = "{" ;
		for(Point p: myCurve) {
			str1 = str1.concat(p.toString());
		}
		str1 = str1.concat("}");
		return str1;
	}
	
	/**
	 * Precondition: There are valid points in the ArrayList
	 * Postcondition: Adds a point to the ArrayList in its correct order based
	 * 	on quantity (x value). If the quantity of the added point is the same as the 
	 * 	quantity of an existing point, the existing point will be replaced by the 
	 * 	added point.
	 * @param p
	 * @return
	 */
	public boolean add(Point p)
	{
		if(p.getQuantity() < 1 || p.getPrice() <= 0) return false;
		if(searchQuantity(p) > -1)
		{
			for(int i = 0; i < myCurve.size(); i++)
			{
				if(searchQuantity(p) == i)
				{
					myCurve.set(i, p);
				}
			}
		}
		else
		{
			int insertIndex = -1;
			for(int i = 0; i<myCurve.size(); i++)
			{
				if(p.getQuantity() < myCurve.get(i).getQuantity())
				{
					insertIndex = i;
					break;
				}
				insertIndex = i + 1;
			}
			myCurve.add(insertIndex, p);
		}
		return true;
	}
	
	/**
	 * Precondition: There are valid points already in the ArrayList
	 * Postcondition: The specified point will be removed from the ArrayList
	 * 	and the points after it will be moved up by an index. If the point specified
	 * 	does not exist in the ArrayList, the method will return false.
	 * @param p
	 * @return
	 */
	public boolean remove(Point p)
	{
		{
			int indexFound = searchIndex(p);
			if (indexFound == -1) return false;
			for(int i = 0; i<myCurve.size(); i++)
			{
				Point pC = myCurve.get(i);
				if(pC.equals(p) == true)
				{
					myCurve.remove(i);
					i--;
				}
			}
			return true;
		}
	}
	
	/**
	 * Precondition: There are valid points already in the ArrayList
	 * Postcondition: If the specified point is in the ArrayList, the method
	 * 	will return true. If the point does not exist in the ArrayList,
	 * 	the method will return false.
	 * @param p
	 * @return
	 */
	public boolean contains(Point p)
	{
		int index = searchIndex(p);
		if (index < 0) return false;
		else return true;
	}
	
	/**
	 * Searches to see if a specified point is in the ArrayList.
	 * Precondition: There are valid points already in the ArrayList.
	 * Postcondition: returns the value of the index that the specified point
	 * 	is in. If the point does not exist in the ArrayList, it will return
	 * 	-1.
	 * @param p
	 * @return
	 */
	private int searchIndex(Point p)
	{
		int index = -1;
		for (int i = 0; i<myCurve.size(); i++)
		{
			Point pC = myCurve.get(i);
			if(pC.equals(p) == true)
			{
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Searches to see if a specified point's quantity exists in the 
	 * 	ArrayList
	 * Precondition: There are valid points already in the ArrayList
	 * Postcondition: It will return the index of the point that the quantity
	 * 	of the specified point is in. If the quantity does not exist, the method 
	 * 	will return -1.
	 * @param p
	 * @return
	 */
	private int searchQuantity(Point p)
	{
		int qIndex = -1;
		for(int i = 0; i<myCurve.size(); i++)
		{
			Point pC = myCurve.get(i);
			if(pC.getQuantity() == p.getQuantity())
			{
				qIndex = i;
			}
		}
		return qIndex;
	}
	
	public int getSize()
	{
		return myCurve.size();
	}
	
	public Point getPoint(int i)
	{
		return myCurve.get(i);
	}
	
	/**
	 * Forces extension programs to have a sort method.
	 */
	public abstract void sort();
}
