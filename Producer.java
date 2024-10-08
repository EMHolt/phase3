package phase2;

/**
 * @authors Emma Holt
 * Date: October 2024
 * Hour: 3rd hour AP CSA
 * Description: Producer has a ProducerCurve that will be used in a
 * 				negotiation.
 */
public class Producer implements Negotiator {

	private ProducerCurve pCurve;
	
	/**
	 * Creates a ProducerCurve with 10 points, starting point
	 * of (1, 10.0), and a decreasing by 1.
	 */
	public Producer()
	{
		pCurve = new ProducerCurve(10, new Point(1, 10.0), 1, 1);
	}
	
	/**
	 * Returns the first point of the ProducerCurve
	 */
	public Point startPoint()
	{
		return pCurve.getPoint(0);
	}
	
	/**
	 * Responds to a given point.
	 * If it is on the curve, reply the same point
	 * If it is above the curve, reply the same point
	 * If it is below the curve, reply the point in the curve
	 * 	that has the quantity one larger of the point given.
	 */
	public Point respondToBid(Point p)
	{ 
		Point respondPoint = new Point();
		if (pCurve.contains(p) == true)
		{
			respondPoint = p;
		}
		else if (pCurve.contains(p) == false)
		{
			for(int i = 0; i < pCurve.getSize(); i++)
			{
				if(p.getQuantity() == pCurve.getPoint(i).getQuantity() && p.getPrice() > pCurve.getPoint(i).getPrice())
				{
					respondPoint = p;
				}
			}
			for (int i = 0; i <= pCurve.getSize() -1 ; i++)
			{
				if(p.getQuantity() == pCurve.getPoint(i).getQuantity() && p.getPrice() < pCurve.getPoint(i).getPrice())
				{
					respondPoint = pCurve.getPoint(i+1);
				}
				if (p.getQuantity() != pCurve.getPoint(i).getQuantity() && i == pCurve.getSize() -1)
				{
					respondPoint = pCurve.getPoint(i);
				}
			}
		}
		return respondPoint;
	}
}
