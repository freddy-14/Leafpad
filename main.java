import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main implements KeyListener {
	
	public static JTextPane textPane;
	public static JTextArea lineNums = new JTextArea(20, 2);
	public static int lineCount = 101;

	public static void main(String args[]){
		init();
		run();
	}
	
	
	public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_ENTER)
            //lineNums.append(Integer.toString(lineCount) + " \n");
			//lineNums.append("1 \n");
			//lineCount += 1;
			System.out.println("Ball");
    }
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }
	
	
	public static void run() {
		
		int lineCounter = 1;
		int count = 0;
		int oldCount = 0;
		while(true) {
			//System.out.println(lineNums.getText());
		}
	}
	
	
	public static void init() {
		JFrame myFrame = new JFrame("Leafpad");
		
		//scrolling
		textPane = new JTextPane() {
    		public boolean getScrollableTracksViewportWidth() {
        		return getUI().getPreferredSize(this).width <= getParent().getSize().width;
    		} 
		};
		
		
		JScrollPane pane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		String lineString = " ";
		
		for(int i = 1; i < 100; i++) {
			lineString += (Integer.toString(i) + " \n ");
		}
		
		
		
		lineNums.append(lineString);
		//lineNums.setEditable(false);
		lineNums.setBackground(Color.YELLOW);
		
		JScrollPane numPane = new JScrollPane(lineNums);//, JScrollPane.VERTICAL_SCROLLBAR_NEVER, 
											  //JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		BoundedRangeModel model = pane.getVerticalScrollBar().getModel();
		numPane.getVerticalScrollBar().setModel(model);
		
		System.out.println(textPane.getText());
		
		//numPane.setVisible(false);
		
		myFrame.setSize(600,500);
		myFrame.setLayout(new BorderLayout());
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.add(numPane, BorderLayout.WEST);
		myFrame.add(pane, BorderLayout.CENTER);
		myFrame.addKeyListener(this);
		myFrame.setVisible(true);
	}

}