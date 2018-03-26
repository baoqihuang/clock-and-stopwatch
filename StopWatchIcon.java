import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
/**
 * Stop watch icon class
 * @author michaelhuang
 */
public class StopWatchIcon implements Icon
{
	//instinct variables
	private int x;
	private int y;
	private int width;
	private int height;
	private StopWatchDialShape innerDial;
	private StopWatchDialShape outterDial;
	/**
	 * Constructor of StopWatchIcon
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public StopWatchIcon(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.innerDial = new StopWatchDialShape(this.x + this.width /4, this.y + this.width/8, this.width/2, "minute", this.width/4);
		this.outterDial = new StopWatchDialShape(this.x, this.y, this.width, "second", this.width/2);
	}
	/**
	 * paintIcon method
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;	
		this.outterDial.draw(g2);
		this.innerDial.draw(g2);
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
