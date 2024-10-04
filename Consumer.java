package phase2;

public class Consumer implements Negotiator {

	private ConsumerCurve cCurve;
	
	public Consumer()
	{
		cCurve = new ConsumerCurve(10, new Point(10, 1.0), 1, 1);
	}
	
	public Point startPoint()
	{
		return cCurve.getPoint(0);
	}
	
	public Point respondToBid(Point p)
	{ 
		Point respondPoint = new Point();
		if (cCurve.contains(p) == true)
		{
			respondPoint = p;
		}
		else if (cCurve.contains(p) == false)
		{
			for(int i = 0; i < cCurve.getSize(); i++)
			{
				if(p.getQuantity() == cCurve.getPoint(i).getQuantity() && p.getPrice() > cCurve.getPoint(i).getPrice())
				{
					respondPoint = p;
				}
			}
			for (int i = 0; i < cCurve.getSize(); i++)
			{
				if(p.getQuantity() == cCurve.getPoint(i).getQuantity() && p.getPrice() < cCurve.getPoint(i).getPrice())
				{
					respondPoint.setQuantity(p.getQuantity() + 1);
					respondPoint = cCurve.getPoint(i+1);
				}
			}
		}
		return respondPoint;
	}
}
