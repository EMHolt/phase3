package phase2;

public class Producer implements Negotiator {

	private ProducerCurve pCurve;
	
	public Producer()
	{
		pCurve = new ProducerCurve(10, new Point(1, 10.0), 1, 1);
	}
	
	public Point startPoint()
	{
		return pCurve.getPoint(0);
	}
	
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
			for (int i = 0; i < pCurve.getSize(); i++)
			{
				if(p.getQuantity() == pCurve.getPoint(i).getQuantity() && p.getPrice() < pCurve.getPoint(i).getPrice())
				{
					respondPoint.setQuantity(p.getQuantity() + 1);
					respondPoint = pCurve.getPoint(i+1);
				}
			}
		}
		return respondPoint;
	}
}
