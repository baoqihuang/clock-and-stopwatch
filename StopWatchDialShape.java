import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Stop watch dial shape class
 * @author michaelhuang
 */
public class StopWatchDialShape
{
	//instinct variables
	private int x;
	private int y;
	private ClockFaceShape clockFaceShape;
	private ClockHandShape clockHand;
	private int width;
	private String type;
	private int radius;
	/**
	 * Constructor of StopWatchDialShape
	 * @param x
	 * @param y
	 * @param width
	 * @param type
	 * @param radius
	 */
	public StopWatchDialShape(int x, int y, int width, String type, int radius)
	{
		this.x = x;
		this.y = y;
		this.type = type;
		this.width = width;
		this.radius = radius;
		this.clockFaceShape = new ClockFaceShape(this.x, this. y, this.width, 5);
		this.clockHand = new ClockHandShape(this.x, this.y, 2, this.width/2, Color.RED, this.type, this.radius);
	}
	/**
	 * draw method
	 * @param g2
	 */
	public void draw(Graphics2D g2)
	{
		this.clockFaceShape.draw(g2);
		this.clockHand.draw(g2);
	}
}
