import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Tester class
 * @author michaelhuang
 *
 */
public class TimeTester 
{
	private static final int CLOCK_RADIUS = 500;  
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();   // Initial a JFrame
		frame.setLayout(new BorderLayout());  // Set layout
		frame.setSize(CLOCK_RADIUS, CLOCK_RADIUS); // Set size of the frame
		// Top part panel contains two buttons
		JPanel topNav = new JPanel(new FlowLayout());  // Set top panel as the flow layout
		JButton clockButton1 = new JButton("clock");   // clock button
		JButton stopWatchButton1 = new JButton("stopWatch");  // stopWatch button
		topNav.add(clockButton1);  // Add clock button to top panel
		topNav.add(stopWatchButton1);  // Add stopWatch button to the top panel
		frame.add(topNav, BorderLayout.NORTH);   // Add the panel to the top part of the frame

		StopWatch stopWatch = new StopWatch(0, 0,CLOCK_RADIUS, CLOCK_RADIUS);   //stopWatch
		MyClock clock = new MyClock(CLOCK_RADIUS);   // Clock
		Component c = clock.getMyClock();  // get clock component
		Component s = stopWatch.getStopWatch();  // get stopWatch component

		frame.add(c, BorderLayout.CENTER);  // Add clock to the center of the frame
		final int DELAY = 1000;  // Set delay
		Timer clockTime = new Timer(DELAY, event -> c.repaint());  // Set clock timer
		clockTime.start(); 

		Timer stopWatchTime = new Timer(DELAY, event -> s.repaint());  //Set stopWatch timer
		// Add listener to stopWatch button
		stopWatchButton1.addActionListener(e -> 
		{
			frame.remove(c);
			clockTime.stop();
			frame.add(s);
			frame.validate();
			frame.add(topNav, BorderLayout.NORTH);
			stopWatchTime.start();
		});
		// Add listener to clock button
		clockButton1.addActionListener(e -> 
		{
			frame.remove(s);
			stopWatchTime.stop();
			frame.add(c);
			frame.validate();
			frame.add(topNav, BorderLayout.NORTH);	
			clockTime.start();
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

}
