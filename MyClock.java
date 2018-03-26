import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * MyClock class panel
 * @author michaelhuang
 *
 */
public class MyClock
{
	// instinct variables
	private int width;
	private MyClockIcon myClock;
	/**
	 * Constructor of MyClock
	 * @param width
	 */
	public MyClock(int width)
	{
		this.width = width;
		this.myClock = new MyClockIcon(this.width, this.width);
	}
	/**
	 * return the clock panel
	 * @return
	 */
	public Component getMyClock()
	{
		final JLabel label = new JLabel(myClock);  // Initialized a label with myClock icon
		label.setPreferredSize(new Dimension(500,500));  // Set dimension
		JPanel panel = new JPanel();  // Initial a JPanel
		panel.setLayout(new FlowLayout()); // Set layout
		panel.add(label); // Add the label to the panel
		return panel;  // Return the clock panel
	}
	
}
