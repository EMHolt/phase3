package phase2;

/**
 * @authors Emma Holt, Ian McGinness, Braden Samson
 * Date: September 2024
 * Hour: 3rd AP CSA
 * Description: An extension of AbstractCurve. Defines the sort method.
 */

// needs a start point method
public class ProducerCurve extends AbstractCurve{
	
	/**
	 * basic constructor. Calls the basic constructor in AbstractCurve.
	 * Creates a line with 10 points and a slope of 1.
	 */
	public ProducerCurve()
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
	public ProducerCurve(int n, Point startPoint, int deltaX, double deltaY)
	{
		super(n, startPoint, deltaX, deltaY * -1);	
	}
	
	/**
	 * Sorts the points in the curve into a decreasing slope.
	 * (insertion sort)
	 */
	public void sort() 
	{
		for(int i = 1; i < myCurve.size(); i++)
		{
			Point k = myCurve.get(i);
			Point m = myCurve.get(i);
			int j = i - 1;
			int q = myCurve.get(i).getQuantity();
			while(j >= 0 && myCurve.get(j).getQuantity() > k.getQuantity())
			{
				if(myCurve.get(j).getPrice() > k.getPrice())
				{
					m.setPrice(k.getPrice());
				}
				m.setQuantity(q);
				myCurve.set(j + 1,  m); 
				j = j - 1;
			}
			myCurve.set(j + 1,  m);
		}
	}
}
