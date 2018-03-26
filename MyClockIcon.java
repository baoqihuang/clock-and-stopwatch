import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
/**
 * My clock Icon with three hands and clock face
 * @author michaelhuang
 */
public class MyClockIcon implements Icon
{
	//instinct variables
	private ClockFaceShape clockFace;
	private ClockHandShape hourHand;
	private ClockHandShape minuteHand;
	private ClockHandShape secondHand;
	private int height;
	private int width;
	/**
	 * Constructor of MyClockIcon
	 * @param width
	 * @param height
	 */
	public MyClockIcon(int width, int height)
	{
		this.width = width;
		this.height = height;
		clockFace = new ClockFaceShape(0, 0, this.width, 1);
		hourHand = new ClockHandShape(0, 0, 8, this.width/2, Color.BLACK, "hour", this.width/2);
		minuteHand = new ClockHandShape(0, 0, 4, this.width/2, Color.BLUE, "minute", this.width/2);
		secondHand = new ClockHandShape(0, 0, 3, this.width/2, Color.RED, "second", this.width/2);
	}
	/**
	 * pantIcon method
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;	
		// Draw the clock face and three time ticks
		this.clockFace.draw(g2);
		this.hourHand.draw(g2);
		this.minuteHand.draw(g2);
		this.secondHand.draw(g2);
	}
	@Override
	public int getIconHeight() 
	{
		return height;
	}

	@Override
	public int getIconWidth() 
	{
		return width;
	}
}
