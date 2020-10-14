package AlgorithmVisualizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Settings extends JPanel implements MouseListener{
	private Gameplay gameplay;
	private JButton bubbleSortButton;
	private JButton insertionSortButton;
	private JButton selectionSortButton;
	private JButton quickSortButton;
	private JButton mergeSortButton;
	private JButton binarySearchButton;
	private JButton shuffleButton;

	private JFrame frame;
	private Algorithms algorithms = new Algorithms();
	
	public Settings(JFrame frame) {
		addMouseListener(this);
		this.frame = frame;
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

		this.setLayout(new MigLayout());
		JLabel algoLabel = new JLabel("Choose Algorithm:");
		algoLabel.setForeground(Color.white);
		algoLabel.setFont(font);
		
		bubbleSortButton = new JButton("Bubble Sort");
		insertionSortButton = new JButton("Insertion Sort");
		selectionSortButton = new JButton("Selection Sort");
		quickSortButton = new JButton("Quick Sort");
		mergeSortButton = new JButton("Merge Sort");
		binarySearchButton = new JButton("Binary Search");
		shuffleButton = new JButton("Shuffle");
		
		bubbleSortButton.addMouseListener(this);
		insertionSortButton.addMouseListener(this);
		selectionSortButton.addMouseListener(this);
		quickSortButton.addMouseListener(this);
		mergeSortButton.addMouseListener(this);
		binarySearchButton.addMouseListener(this);
		shuffleButton.addMouseListener(this);

		bubbleSortButton.setFocusable(false);
		insertionSortButton.setFocusable(false);
		selectionSortButton.setFocusable(false);
		quickSortButton.setFocusable(false);
		mergeSortButton.setFocusable(false);
		binarySearchButton.setFocusable(false);
		shuffleButton.setFocusable(false);

		this.add(algoLabel, "wrap");
		this.add(bubbleSortButton, "wrap");
		this.add(insertionSortButton, "wrap");
		this.add(selectionSortButton, "wrap");
		this.add(quickSortButton, "wrap");
		this.add(mergeSortButton, "wrap");
		this.add(binarySearchButton, "wrap");
		this.add(shuffleButton, "wrap");

		this.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		Toolbar toolbar = (Toolbar) this.getParent();
		gameplay = toolbar.getGameplay();
		Rectangle rectangles[] = gameplay.getRectangles();
		if(e.getSource() == bubbleSortButton) {
			try {
				algorithms.bubbleSort(rectangles, gameplay);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource() == insertionSortButton) {
			try {
				algorithms.insertionSort(rectangles, gameplay);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource() == selectionSortButton) {
			try {
				algorithms.selectionSort(rectangles, gameplay);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource() == quickSortButton) {
			try {
				algorithms.quickSort(rectangles, gameplay);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource() == mergeSortButton) {
			try {
				algorithms.mergeSort(rectangles, gameplay);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource() == binarySearchButton) {
			try {
				algorithms.binarySearch(rectangles, gameplay, 20);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		else if(e.getSource() == shuffleButton) {
			try {
				algorithms.shuffle(gameplay);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
