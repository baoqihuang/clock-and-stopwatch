import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Stop watch panel class
 * @author michaelhuang
 *
 */
public class StopWatch
{
	//instinct variables
	private int x;
	private int y;
	private int width;
	private int height;
	private StopWatchIcon stopWatch;
	/**
	 * Constructor of StopWatch
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public StopWatch(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.stopWatch = new StopWatchIcon(this.x, this.y, this.width, this.height);
	}
	/**
	 * return stop watch component
	 * @return
	 */
	public Component getStopWatch()
	{
		final JLabel label = new JLabel(this.stopWatch); // Create a label with stop watch icon
		label.setPreferredSize(new Dimension(500,500));  // Set label dimension
		JPanel panel = new JPanel();  // Create a panel
		panel.setLayout(new FlowLayout());  // Set panel layout as a flow
		panel.add(label);  // Add label to the panel
		return panel;  // Return the panel
	}
}
