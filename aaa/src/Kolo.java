import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Kolo extends Ellipse2D.Double{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public double r;
	public double area;
	public double circumference;


	public Kolo(double promien)
	{
		this.r = promien;
	}
	
	
	
	public Kolo(double x, double y, double promien)
	{

		super(x, y, 2*Math.abs(promien),2*Math.abs(promien));
		r = Math.abs(promien);
		calcArea();
		calcCircumference();
	}


	
	
	public void calcArea()
	{
		area = Math.PI * r * r;
	}

	public void calcCircumference()
	{
		circumference = 2 * Math.PI * r;
	}

	
	
	
}