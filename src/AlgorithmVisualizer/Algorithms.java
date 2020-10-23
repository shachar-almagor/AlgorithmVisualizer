package AlgorithmVisualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

public class Algorithms {
	
	public Algorithms() {
		
	}

	public void bubbleSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		Graphics g = gameplay.getGraphics();
		makeRecsWhite(rectangles);

		gameplay.drawBackground(g);
		gameplay.drawRectangles(g);
		for(int i = 0; i < rectangles.length; i++) {
			for(int j = 1; j < rectangles.length - i; j++) {
				if(rectangles[j - 1].getHeight() > rectangles[j].getHeight()) {
					// Make Rectangles gray, same color as background
					drawRec(rectangles, j, g, Color.DARK_GRAY);
					drawRec(rectangles, j - 1, g, Color.DARK_GRAY);

					// Switch rectangles
					int temp = rectangles[j - 1].getHeight();
					rectangles[j - 1].setHeight(rectangles[j].getHeight());
					rectangles[j].setHeight(temp);

					drawRec(rectangles, j, g, Color.white);
					drawRec(rectangles, j - 1, g, Color.white);
					
					// Makes drawing slower //
					drawRec(rectangles, j, g, Color.blue);
					TimeUnit.MILLISECONDS.sleep(20);
					drawRec(rectangles, j, g, Color.white);
					// Makes drawing slower //
				}
			}
			rectangles[rectangles.length - i - 1].setColor(Color.magenta);
			rectangles[rectangles.length - i - 1].draw((Graphics2D) g, true);
			TimeUnit.MILLISECONDS.sleep(35);
		}
	}

	public void insertionSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		Graphics g = gameplay.getGraphics();
		makeRecsWhite(rectangles);

		for(int i = 1; i < rectangles.length; i++) {
			int key = rectangles[i].getHeight();
			int j = i - 1;
			while(j >= 0 && rectangles[j].getHeight() > key) {
				drawRec(rectangles, j, g, Color.DARK_GRAY);
				drawRec(rectangles, j + 1, g, Color.DARK_GRAY);
				rectangles[j + 1].setHeight(rectangles[j].getHeight());
				// Makes drawing slower //				
				drawRec(rectangles, j, g, Color.blue);
				drawRec(rectangles, j + 1, g, Color.magenta);

				TimeUnit.MILLISECONDS.sleep(20);
				rectangles[j].setColor(Color.magenta);				
				// Makes drawing slower //
				j--;
			}

			rectangles[j + 1].setHeight(key);
			gameplay.drawBackground(g);
			gameplay.drawRectangles(g);
			TimeUnit.MILLISECONDS.sleep(35);
		}		
		gameplay.drawBackground(g);
		gameplay.drawRectangles(g);
	}
	
	public void selectionSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		Graphics g = gameplay.getGraphics();
		makeRecsWhite(rectangles);
		gameplay.drawBackground(g);
		gameplay.drawRectangles(g);
		for(int i = 0; i < rectangles.length - 1; i++) {
			int minHeight = rectangles[i].getHeight();
			int minIndex = i;
			for(int j = i + 1; j < rectangles.length; j++) {
				if(rectangles[j].getHeight() < minHeight) {
					minHeight = rectangles[j].getHeight();
					minIndex = j;
					drawRec(rectangles, minIndex, g, Color.blue);
					TimeUnit.MILLISECONDS.sleep(20);
					drawRec(rectangles, minIndex, g, Color.white);
				}
			}
			// Switch rectangles
			drawRec(rectangles, i, g, Color.DARK_GRAY);
			drawRec(rectangles, minIndex, g, Color.DARK_GRAY);
			
			int temp = rectangles[i].getHeight();
			rectangles[i].setHeight(minHeight);
			rectangles[minIndex].setHeight(temp);
			
			drawRec(rectangles, i, g, Color.magenta);
			TimeUnit.MILLISECONDS.sleep(35);
			if(minIndex != i) {
				drawRec(rectangles, minIndex, g, Color.white);
			} else {
				drawRec(rectangles, minIndex, g, Color.magenta);
			}

		}
		rectangles[rectangles.length - 1].setColor(Color.magenta);
		gameplay.drawBackground(g);
		gameplay.drawRectangles(g);
	}
	
	public void quickSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		makeRecsWhite(rectangles);
		gameplay.drawBackground(gameplay.getGraphics());
		gameplay.drawRectangles(gameplay.getGraphics());
		quickSortRec(rectangles, 0, rectangles.length - 1, gameplay);
		gameplay.drawBackground(gameplay.getGraphics());
		gameplay.drawRectangles(gameplay.getGraphics());
	}
	
	public void quickSortRec(Rectangle[] rectangles, int low, int high, Gameplay gameplay) throws InterruptedException {
		Graphics g = gameplay.getGraphics();
		if(low < high) {
			int pivot = partition(rectangles, low, high, gameplay);
			drawRec(rectangles, pivot, g, Color.BLUE);		
			TimeUnit.MILLISECONDS.sleep(50);
			drawRec(rectangles, pivot, g, Color.magenta);
			quickSortRec(rectangles, low, pivot - 1, gameplay);
			quickSortRec(rectangles, pivot + 1, high, gameplay);
		} else {
			return;
		}
	}
	
	public int partition(Rectangle[] rectangles, int low, int high, Gameplay gameplay) throws InterruptedException {
		Graphics g = gameplay.getGraphics();
		int pivot = (low + high) / 2;
		int currSmallIndex = low - 1;
		for(int i = low; i <= high; i++) {
			if(rectangles[i].getHeight() < rectangles[pivot].getHeight()) {
				currSmallIndex++;
				// Make this rectangle be to the left of the pivot, and increment currSmallIndex
				int temp = rectangles[i].getHeight();
				if(currSmallIndex == pivot) {
					// If the pivot is switched, update it's index
					pivot = i;
				}
				// Make Rectangles gray, same color as background
				drawRec(rectangles, i, g, Color.DARK_GRAY);
				drawRec(rectangles, currSmallIndex, g, Color.DARK_GRAY);
				
				rectangles[i].setHeight(rectangles[currSmallIndex].getHeight());
				rectangles[currSmallIndex].setHeight(temp);
						
				drawRec(rectangles, currSmallIndex, g, Color.magenta);
				drawRec(rectangles, i, g, Color.magenta);
				TimeUnit.MILLISECONDS.sleep(35);
			}
		}
		// Make Rectangles gray, same color as background
		drawRec(rectangles, currSmallIndex + 1, g, Color.DARK_GRAY);
		drawRec(rectangles, pivot, g, Color.DARK_GRAY);
		
		// Put the pivot rectangle in it's correct place, such that all of the rectangles to it's left are shorter than it
		int temp = rectangles[currSmallIndex + 1].getHeight();
		rectangles[currSmallIndex + 1].setHeight(rectangles[pivot].getHeight());
		rectangles[pivot].setHeight(temp);
		
		drawRec(rectangles, currSmallIndex + 1, g, Color.magenta);
		drawRec(rectangles, pivot, g, Color.magenta);

		return currSmallIndex + 1;
	}
	
	public void mergeSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		makeRecsWhite(rectangles);
		gameplay.drawBackground(gameplay.getGraphics());
		gameplay.drawRectangles(gameplay.getGraphics());
		mergeSortRec(rectangles, gameplay, 0, rectangles.length - 1);
	}
	
	public void mergeSortRec(Rectangle[] rectangles, Gameplay gameplay, int low, int high) throws InterruptedException {
		int mid = (low + high) / 2;
		if(low < high) {
			TimeUnit.MILLISECONDS.sleep(5);
			// Divide the sub arrays and sort them
			mergeSortRec(rectangles, gameplay, low, mid);
			mergeSortRec(rectangles, gameplay, mid + 1, high);
			
			// Merge the two sorted sub arrays
			merge(rectangles, gameplay, low, mid, high);

		}
	}
	
	public void merge(Rectangle[] rectangles, Gameplay gameplay, int low, int mid, int high) throws InterruptedException {
		Graphics g = gameplay.getGraphics();
		int arrSize1 = mid - low + 1;
		int arrSize2 = high - mid;
		
		Rectangle[] leftRectangles = new Rectangle[arrSize1];
		Rectangle[] rightRectangles = new Rectangle[arrSize2];
		
		// Insert the rectangles to the two sub arrays
		for(int i = 0; i < arrSize1; i++) {
			Rectangle currRect = new Rectangle(rectangles[low + i].getHeight(), gameplay.getRectangleWidth(), Color.magenta);
			leftRectangles[i] = currRect;
		}
		for(int j = 0; j < arrSize2; j++) {
			Rectangle currRect = new Rectangle(rectangles[mid + 1 + j].getHeight(), gameplay.getRectangleWidth(), Color.magenta);
			rightRectangles[j] = currRect;
		}
		
		int i = 0;
		int j = 0;
		int currIndex = low;
		
		// Merge the two sub arrays
		while(i < arrSize1 && j < arrSize2) {
			drawRec(rectangles, currIndex, g, Color.DARK_GRAY);
			if(leftRectangles[i].getHeight() < rightRectangles[j].getHeight()) {
				rectangles[currIndex].setHeight(leftRectangles[i].getHeight());
				i++;
			} else {
				rectangles[currIndex].setHeight(rightRectangles[j].getHeight());
				j++;
			}
			drawRec(rectangles, currIndex, g, Color.magenta);
			currIndex++;
			
			TimeUnit.MILLISECONDS.sleep(10);
		}
		
		// Copies the rest of the elements in the left rectangles sub array, if there are any left
		while(i < arrSize1) {
			drawRec(rectangles, currIndex, g, Color.DARK_GRAY);
			rectangles[currIndex].setHeight(leftRectangles[i].getHeight());
			drawRec(rectangles, currIndex, g, Color.magenta);
			currIndex++;
			i++;
			TimeUnit.MILLISECONDS.sleep(10);
		}
		
		// Copies the rest of the elements in the right rectangles sub array, if there are any left
		while(j < arrSize2) {
			drawRec(rectangles, currIndex, g, Color.DARK_GRAY);
			rectangles[currIndex].setHeight(rightRectangles[j].getHeight());
			drawRec(rectangles, currIndex, g, Color.magenta);
			currIndex++;
			j++;
			TimeUnit.MILLISECONDS.sleep(35);
		}
	}
	
	// Add user controlled values to be searched
	public void binarySearch(Rectangle[] rectangles, Gameplay gameplay, int result) throws InterruptedException {
		binarySearchRec(rectangles, gameplay, 0, rectangles.length - 1, result);
	}
	
	public void binarySearchRec(Rectangle[] rectangles, Gameplay gameplay, int left, int right, int result) throws InterruptedException {
		Graphics g = gameplay.getGraphics();
		if(left > right) return;
		// Get initial color to set back after searching
		Color initialColor = rectangles[left].getColor();
		
		drawRec(rectangles, left, g, Color.black);
		drawRec(rectangles, right, g, Color.black);
		TimeUnit.MILLISECONDS.sleep(350);

		int mid = (left + right) / 2;
		drawRec(rectangles, left, g, initialColor);
		drawRec(rectangles, right, g, initialColor);

		if(mid == result) {
			drawRec(rectangles, mid, g, Color.green);
			return;
		} else if(mid > result) {
			binarySearchRec(rectangles, gameplay, left, mid - 1, result);
		} else {
			binarySearchRec(rectangles, gameplay, mid + 1, right, result);
		}
		
	}
	
	public void shuffle(Gameplay gameplay) throws InterruptedException {
		gameplay.shuffleRectangles();
	}
	
	public void makeRecsWhite(Rectangle[] rectangles) {
		for(int i = 0; i < rectangles.length; i++) {
			rectangles[i].setColor(Color.white);
		}
	}
	
	public void drawRec(Rectangle[] rectangles, int index, Graphics g, Color color) {
		rectangles[index].setColor(color);
		if(color == Color.darkGray || color == Color.blue || color == Color.white) {
			rectangles[index].draw((Graphics2D) g, false);
		} else {
			rectangles[index].draw((Graphics2D) g, true);
		}
	}
}
