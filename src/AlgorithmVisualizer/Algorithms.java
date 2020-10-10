package AlgorithmVisualizer;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

public class Algorithms {
	
	public Algorithms() {
		
	}

	public void bubbleSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		makeRecsWhite(rectangles);

		gameplay.drawBackground(gameplay.getGraphics());
		gameplay.drawRectangles(gameplay.getGraphics());
		for(int i = 0; i < rectangles.length; i++) {
			for(int j = 1; j < rectangles.length - i; j++) {
				if(rectangles[j - 1].getHeight() > rectangles[j].getHeight()) {
					// Switch rectangles
					int temp = rectangles[j - 1].getHeight();
					rectangles[j - 1].setHeight(rectangles[j].getHeight());
					rectangles[j].setHeight(temp);
					
					// Makes drawing slower //
					rectangles[j].setColor(Color.blue);
					gameplay.drawBackground(gameplay.getGraphics());
					gameplay.drawRectangles(gameplay.getGraphics());
					TimeUnit.MILLISECONDS.sleep(35);
					rectangles[j].setColor(Color.white);
					// Makes drawing slower //
				}
			}
			rectangles[rectangles.length - i - 1].setColor(Color.magenta);
			gameplay.drawBackground(gameplay.getGraphics());
			gameplay.drawRectangles(gameplay.getGraphics());
			TimeUnit.MILLISECONDS.sleep(35);
		}
		gameplay.drawBackground(gameplay.getGraphics());
		gameplay.drawRectangles(gameplay.getGraphics());
	}

	public void insertionSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		makeRecsWhite(rectangles);

		for(int i = 1; i < rectangles.length; i++) {
			int key = rectangles[i].getHeight();
			int j = i - 1;
			while(j >= 0 && rectangles[j].getHeight() > key) {
				rectangles[j + 1].setHeight(rectangles[j].getHeight());
				rectangles[j + 1].setColor(Color.magenta);
				// Makes drawing slower //
				rectangles[j].setColor(Color.blue);
				
				gameplay.drawBackground(gameplay.getGraphics());
				gameplay.drawRectangles(gameplay.getGraphics());
				TimeUnit.MILLISECONDS.sleep(35);
				rectangles[j].setColor(Color.magenta);
				// Makes drawing slower //

				j--;
			}

			rectangles[j + 1].setHeight(key);
//			rectangles[j + 1].setColor(Color.blue);
			gameplay.drawBackground(gameplay.getGraphics());
			gameplay.drawRectangles(gameplay.getGraphics());
//			rectangles[j + 1].setColor(Color.magenta);
			TimeUnit.MILLISECONDS.sleep(35);
		}		
		gameplay.drawBackground(gameplay.getGraphics());
		gameplay.drawRectangles(gameplay.getGraphics());
	}
	
	public void selectionSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		makeRecsWhite(rectangles);
		for(int i = 0; i < rectangles.length - 1; i++) {
			int minHeight = rectangles[i].getHeight();
			int minIndex = i;
			for(int j = i + 1; j < rectangles.length; j++) {
				if(rectangles[j].getHeight() < minHeight) {
					minHeight = rectangles[j].getHeight();
					rectangles[minIndex].setColor(Color.blue);
					gameplay.drawBackground(gameplay.getGraphics());
					gameplay.drawRectangles(gameplay.getGraphics());
					TimeUnit.MILLISECONDS.sleep(200);
					rectangles[minIndex].setColor(Color.white);
					minIndex = j;
				}
			}
			// Switch rectangles
			int temp = rectangles[i].getHeight();
			rectangles[i].setHeight(minHeight);
			rectangles[i].setColor(Color.magenta);
			rectangles[minIndex].setHeight(temp);
			rectangles[minIndex].setColor(Color.blue);
			gameplay.drawBackground(gameplay.getGraphics());
			gameplay.drawRectangles(gameplay.getGraphics());
			TimeUnit.MILLISECONDS.sleep(35);
			if(minIndex != i) {
				rectangles[minIndex].setColor(Color.white);
			} else {
				rectangles[minIndex].setColor(Color.magenta);
			}

		}
		rectangles[rectangles.length - 1].setColor(Color.magenta);
		gameplay.drawBackground(gameplay.getGraphics());
		gameplay.drawRectangles(gameplay.getGraphics());
	}
	
	public void quickSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		makeRecsWhite(rectangles);
		quickSortRec(rectangles, 0, rectangles.length - 1, gameplay);

	}
	
	public void quickSortRec(Rectangle[] rectangles, int low, int high, Gameplay gameplay) throws InterruptedException {
		if(low < high) {
			int pivot = partition(rectangles, low, high, gameplay);
			gameplay.drawBackground(gameplay.getGraphics());
			gameplay.drawRectangles(gameplay.getGraphics());
			TimeUnit.MILLISECONDS.sleep(50);
			quickSortRec(rectangles, low, pivot - 1, gameplay);
			quickSortRec(rectangles, pivot + 1, high, gameplay);


		} else {
			return;
		}
	}
	
	public int partition(Rectangle[] rectangles, int low, int high, Gameplay gameplay) throws InterruptedException {
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
				rectangles[i].setHeight(rectangles[currSmallIndex].getHeight());
				rectangles[currSmallIndex].setHeight(temp);
				
				rectangles[currSmallIndex].setColor(Color.magenta);
				rectangles[i].setColor(Color.blue);			
				gameplay.drawBackground(gameplay.getGraphics());
				gameplay.drawRectangles(gameplay.getGraphics());
				TimeUnit.MILLISECONDS.sleep(35);
				rectangles[i].setColor(Color.magenta);			
			}
		}
		// Put the pivot rectangle in it's correct place, such that all of the rectangles to it's left are shorter than it
		int temp = rectangles[currSmallIndex + 1].getHeight();
		rectangles[currSmallIndex + 1].setHeight(rectangles[pivot].getHeight());
		rectangles[pivot].setHeight(temp);
		
		rectangles[currSmallIndex + 1].setColor(Color.magenta);
		rectangles[pivot].setColor(Color.magenta);


		return currSmallIndex + 1;
	}
	
	public void mergeSort(Rectangle[] rectangles, Gameplay gameplay) throws InterruptedException {
		makeRecsWhite(rectangles);
		mergeSortRec(rectangles, gameplay, 0, rectangles.length - 1);
	}
	
	public void mergeSortRec(Rectangle[] rectangles, Gameplay gameplay, int low, int high) throws InterruptedException {
		int mid = (low + high) / 2;
		if(low < high) {
			gameplay.drawBackground(gameplay.getGraphics());
			gameplay.drawRectangles(gameplay.getGraphics());
			TimeUnit.MILLISECONDS.sleep(50);
			// Divide the sub arrays and sort them
			mergeSortRec(rectangles, gameplay, low, mid);
			mergeSortRec(rectangles, gameplay, mid + 1, high);
			
			// Merge the two sorted sub arrays
			merge(rectangles, gameplay, low, mid, high);

		}
	}
	
	public void merge(Rectangle[] rectangles, Gameplay gameplay, int low, int mid, int high) throws InterruptedException {
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
			if(leftRectangles[i].getHeight() < rightRectangles[j].getHeight()) {
				rectangles[currIndex].setHeight(leftRectangles[i].getHeight());
				i++;
			} else {
				rectangles[currIndex].setHeight(rightRectangles[j].getHeight());

				j++;
			}
			rectangles[currIndex].setColor(Color.magenta);
			currIndex++;
			
			gameplay.drawBackground(gameplay.getGraphics());
			gameplay.drawRectangles(gameplay.getGraphics());
			TimeUnit.MILLISECONDS.sleep(35);
		}
		
		// Copies the rest of the elements in the left rectangles sub array, if there are any left
		while(i < arrSize1) {
			rectangles[currIndex].setHeight(leftRectangles[i].getHeight());
			rectangles[currIndex].setColor(Color.magenta);
			currIndex++;
			i++;
			gameplay.drawBackground(gameplay.getGraphics());
			gameplay.drawRectangles(gameplay.getGraphics());
			TimeUnit.MILLISECONDS.sleep(35);
		}
		
		// Copies the rest of the elements in the right rectangles sub array, if there are any left
		while(j < arrSize2) {
			rectangles[currIndex].setHeight(rightRectangles[j].getHeight());
			rectangles[currIndex].setColor(Color.magenta);
			currIndex++;
			j++;
			gameplay.drawBackground(gameplay.getGraphics());
			gameplay.drawRectangles(gameplay.getGraphics());
			TimeUnit.MILLISECONDS.sleep(35);
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
}
