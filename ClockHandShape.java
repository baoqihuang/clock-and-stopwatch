import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Clock Hand Icon class
 * @author michaelhuang
 */
public class ClockHandShape
{	
	//instinct variables
	private int x;
	private int y;
	private float width;
	private int height;
	private Color color;
	private String type;
	private double pointTo;
	private int radius;
	/**
	 * Constructor of ClockHandShpae
	 * @param theX
	 * @param theY
	 * @param theWidth
	 * @param theHeight
	 * @param color
	 * @param type
	 * @param radius
	 */
	public ClockHandShape(int theX, int theY, float theWidth, int theHeight, Color color, String type, int radius)
	{
		this.x = theX;
		this.y = theY;
		this.width = theWidth;
		this.height = theHeight;
		this.color = color;
		this.type = type;
		this.radius = radius;
	}
	/**
	 * get current time as a string with [hour minute second] formate
	 * @return
	 */
	public String[] getCurrentTime()
	{
		// Get current time
		Date dt = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(dt);
		
		String time = ""; // Initial empty string
		// Store the time to the array
		int hour = calendar.get(Calendar.HOUR);
		if(hour < 12)
		{
			time += hour + " ";
		}
		else
		{
			time += hour - 12 + " ";
		}		
		time += calendar.get(Calendar.MINUTE) + " ";
		time += calendar.get(Calendar.SECOND);
		String[] currentTime = time.split(" ");
		return currentTime;  // Return the array
	}
	/**
	 * Draws the shape.
    	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
	    String time[] = getCurrentTime();
	    int cX = x + (this.radius);
	    int cY = y + (this.radius);
	    this.drawHand(time, cX, cY, g2);
	}
	/**
	 * Draw hand with the different type: hour minte second
	 * @param time
	 * @param cX
	 * @param cY
	 * @param g2
	 */
	public void drawHand(String time[], int cX, int cY, Graphics2D g2)
	{
	    double length = this.height;
	    String timeType = "";
	    // Style of hour hand
	    if(this.type.equals("hour"))
	    {
		    timeType = time[0];
		    pointTo = Double.parseDouble(timeType) * 5;
		    length *= 0.8;
	    }
	    // Style of minute hand
	    else if(this.type.equals("minute"))
	    {
	    		timeType = time[1];
		    pointTo = Double.parseDouble(timeType);
	    		length *= 0.9;
	    }
	    // Style of second hand
	    else if(this.type.equals("second"))
	    {
	    		timeType = time[2];
		    pointTo = Double.parseDouble(timeType);
	    }
	    double d = (double)pointTo; // tick num as double for easier math
	    double AngleFrom12 = d/60.0*2.0*Math.PI; // angle from 12
	    double AngleFrom3 = Math.PI/2.0-AngleFrom12; //angle from 3
	    Stroke hourTickStroke = new BasicStroke(width); 
	    GeneralPath hourTicksPath = new GeneralPath();

	    hourTicksPath.moveTo((float)(cX), (float)(cY));
	          // Draw line inward along radius for length of tick mark
	    hourTicksPath.lineTo(	    		
	    		(float)(cX + Math.cos(AngleFrom3) * length),
	    		(float)(cY - Math.sin(AngleFrom3) * length));
	      // Draw the full shape onto the graphics context.
	    g2.setColor(this.color);
	    g2.setStroke(hourTickStroke);
	    g2.draw(hourTicksPath);
	}
}
