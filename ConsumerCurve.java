package phase2;

/**
 * @authors Emma Holt, Ian McGinness, Braden Samson
 * Date: September 2024
 * Hour: 3rd AP CSA
 * Description: An extension of AbstractCurve. Defines the sort method.
 *
 */

public class ConsumerCurve extends AbstractCurve{
	
	/**
	 * basic constructor. Calls the basic constructor in AbstractCurve.
	 * Creates a line with 10 points and a slope of 1.
	 */
	public ConsumerCurve()
	{
		super();
	}
	
	/**
	 * Constructor with parameters. It creates a line with a certain
	 * number of points, a starting point, and a slope (deltaX & deltaY).
	 * Calls the constructor with parameters from the AbstractCurve.
	 * @param n: number of points
	 * @param startPoint: starting point
	 * @param deltaX: change in x between two points
	 * @param deltaY: change in y between two points
	 */
	public ConsumerCurve(int n, Point startPoint, int deltaX, double deltaY)
	{
		super(n, startPoint, deltaX, deltaY);
	}
	
	/**
	 * Sorts the points in the curve into a increasing slope.
	 * (selection sort)
	 */
	public void sort() 
	{
		int n = myCurve.size();
		
		for (int i = 0; i < n -1; i++)
		{
			int minIndex = i;
			for (int j = i + 1; j < n; j++)
			{
				if (myCurve.get(j).getQuantity() < myCurve.get(minIndex).getQuantity())
				{
					minIndex = j;
				}
			}
			Point temp = myCurve.get(minIndex);
			myCurve.set(minIndex, myCurve.get(i));
			myCurve.set(i, temp);
		}
		
	}
}
