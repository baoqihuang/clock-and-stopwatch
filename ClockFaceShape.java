import java.awt.*;
import java.awt.geom.*;
/**
 *  A Clock face shape
*/
public class ClockFaceShape
{
	//instinct variables
	private int x;
	private int y;
	private int width;
	private int numberType;
   /**
    * Constructs a Clock
    * @param x the left of the bounding rectangle
    * @param y the top of the bounding rectangle
    * @param width the width of the bounding rectangle
    */
    public ClockFaceShape(int x, int y, int width, int numberType)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.numberType = numberType;
    }
   /**
    * draw method to draw the clock shape
    * @param g2
    */
	public void draw(Graphics2D g2)
   {
      // draw the ticks
      int tickLen = 10;
      int medTickLen = 15;
      int longTickLen = 20;
      
      int r = width/2; //radius of clock
      int cX = x + (width)/2; // x-axis of the center
      int cY = y + (width)/2; // y-axis of the center
      Stroke tickStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f);  // Set stroke style
      GeneralPath ticksPath = new GeneralPath();  // Initial a tickPath
      Ellipse2D.Double clockFace = new Ellipse2D.Double(this.x,this.y,width, width);  // Initial the clock board
      // Fill the board white color
      g2.setColor(Color.WHITE);
      g2.fill(clockFace); 

      for ( int i=1; i<= 60; i++)
      {
          // default tick length is short
          int len = tickLen;
          if ( i % 15 == 0 )
          {
              // Longest tick on quarters (every 15 ticks)
              len = longTickLen;
          } else if ( i % 5 == 0 )
          {
           // Medium ticks on the '5's (every 5 ticks)
           len = medTickLen;
          }

          double di = (double)i; // tick num as double for easier math

          // Get the angle from 12 O'Clock to this tick (radians)
          double angleFrom12 = di/60.0*2.0*Math.PI;

          // Get the angle from 3 O'Clock to this tick
              // Note: 3 O'Clock corresponds with zero angle in unit circle
              // Makes it easier to do the math.
          double angleFrom3 = Math.PI/2.0-angleFrom12;

          // Move to the outer edge of the circle at correct position
          // for this tick.
          ticksPath.moveTo
          (
                  (float)(cX+Math.cos(angleFrom3)*r),
                  (float)(cY-Math.sin(angleFrom3)*r)
          );

          // Draw line inward along radius for length of tick mark
          ticksPath.lineTo
          (
                  (float)(cX+Math.cos(angleFrom3)*(r-len)),
                  (float)(cY-Math.sin(angleFrom3)*(r-len))
          );
      }

      // Draw the full shape onto the graphics context.
      g2.setColor(Color.BLACK);
      g2.setStroke(tickStroke);
      g2.draw(ticksPath);
      // Draw the numbers on the clock face
      g2.setColor(Color.RED);
      for ( int i=1; i<=12; i++)
      {
         String numStr = ""+ i * this.numberType;
         FontMetrics fm = g2.getFontMetrics(g2.getFont());
         int charWidth = fm.stringWidth(numStr);
         int charHeight = fm.getHeight();

         double di = (double)i;
         double angleFrom12 = di/12.0*2.0*Math.PI;
         double angleFrom3 = Math.PI/2.0-angleFrom12;

         int tx = (int)(Math.cos(angleFrom3)*(r-longTickLen-charWidth));
         int ty = (int)(-Math.sin(angleFrom3)*(r-longTickLen-charHeight));

         g2.drawString(numStr, (int)cX+tx, (int)cY+ty);         
      }
   }

}
