package AlgorithmVisualizer;

import javax.swing.JFrame;

public class Main {

	private JFrame frame;
	
	public Main() throws InterruptedException {
		frame = new JFrame();
		Gameplay gameplay = new Gameplay(50);
		Settings settings = new Settings(frame);
		
		Toolbar toolbar = new Toolbar(gameplay, settings);
		frame.pack();
		frame.setBounds(10, 10, 900, 750);
		frame.setTitle("Sorting and Searching Algorithm Visualizer");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(toolbar);
	}

	public static void main(String[] args) throws InterruptedException {
		new Main();
	}

}
