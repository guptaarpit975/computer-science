package com.selflearning;

public class BinaryHeapDemo {

	public static void main(String[] args) {
		
		BinaryMinHeap minHeap = new BinaryMinHeap(20);
		minHeap.insertVal(9);
		minHeap.insertVal(8);
		minHeap.insertVal(3);
		minHeap.insertVal(6);
		minHeap.insertVal(4);
		minHeap.insertVal(20);
		minHeap.insertVal(11);
		minHeap.insertVal(7);
		minHeap.insertVal(5);
		minHeap.insertVal(10);
		
		minHeap.displayHeapContents();
		
		for(int i=0;i<10;i++) {
			System.out.println(minHeap.extractMinVal());
			//minHeap.displayHeapContents();
		}
	}
	
	// This class implements a Min_Heap (the smallest value is at the Top of the Heap)
	// It is only meant for Integer Values.
	private static class BinaryMinHeap {
		int maxCapacity;
		int currSize;
		int[] heap;
		
		// Parent = (n-1)/2
		// Left child = 2n + 1
		// Right Child = 2n +2
		
		public BinaryMinHeap(int maxCap) {
			maxCapacity = maxCap;
			currSize=0;
			heap = new int[maxCap];
		}
		
		public int extractMinVal() {
			if(currSize == 0) return Integer.MIN_VALUE;
			
			// Extract the top value of the Heap
			int retVal = heap[0];
			int lastVal = heap[currSize-1];
			
			currSize--;
			heap[0] = lastVal;
			
			// Now, the topmost value of the heap is not following the Heap Property
			// So, Heapify
			int idx=0, lc, rc, temp;
			while(isLeftChildPresent(idx)) {
				lc = 2*idx + 1;
				rc = 2*idx + 2;
				int smallestIdx = idx;
				
				if(heap[lc] < heap[idx]) {
					smallestIdx = lc;
				} 
				
				if(isRightChildPresent(idx) && (heap[rc] < heap[smallestIdx])) {
					smallestIdx = rc;
				} 
				
				if(idx == smallestIdx) {
					// The parent is already the smallest among the 3. So, break the loop
					break;
				}
				
				// Swap the values of the idx and the smallestIdx
				temp = heap[idx];
				heap[idx] = heap[smallestIdx];
				heap[smallestIdx] = temp;
				
				idx = smallestIdx;
			}
			return retVal;
		}
		
		public void insertVal(int val) {
			
			if(isHeapFull()) return;
			
			// Insert the element at the bottom of the heap
			heap[currSize] = val;
			currSize++;
			int idx = currSize-1;
			int parent, temp;
			while(idx > 0) {
				parent = (idx-1)/2;
				if(heap[idx] < heap[parent]) {
					temp = heap[idx];
					heap[idx] = heap[parent];
					heap[parent] = temp;
					idx = parent;
				} else {
					break;
				}
			}
		}
		
		private boolean isLeftChildPresent(int n) {
			int x = 2*n + 1;
			return (x<currSize);
		}

		private boolean isRightChildPresent(int n) {
			int x = 2*n + 2;
			return (x<currSize);
		}

		private boolean isHeapFull() {
			return (currSize >= maxCapacity);
		}
		
		public void displayHeapContents() {
			System.out.println("Heap Contents ::-");
			//System.out.println(heap.toString());
			
			for(int i=0; i<currSize; i++) {
				System.out.print(heap[i] + ", ");
			}
			System.out.println();	
		}
		
	}
}
