package org.example;

import java.util.ArrayList;

// Class representing a min heap, implementing the PriorityQueue interface
class MinPriorityQueue implements PriorityQueue {
    private ArrayList<Integer> heap; // ArrayList to store the heap elements

    // Constructor to initialize the heap
    public MinPriorityQueue() {
        heap = new ArrayList<>(); // Create an empty ArrayList to store heap elements
    }

    // Returns the index of the parent node
    private int parent(int i) {
        return (i - 1) / 2; // Calculate the parent index based on the current index
    }

    // Returns the index of the left child node
    private int leftChild(int i) {
        return 2 * i + 1; // Calculate the index of the left child
    }

    // Returns the index of the right child node
    private int rightChild(int i) {
        return 2 * i + 2; // Calculate the index of the right child
    }

    // Swaps the elements at indices i and j
    private void swap(int i, int j) {
        int temp = heap.get(i); // Temporarily store the value at index i
        heap.set(i, heap.get(j)); // Set the value at index i to the value at index j
        heap.set(j, temp); // Set the value at index j to the value stored in temp
    }

    // Inserts a new value into the heap
    @Override
    public void insert(int value) {
        heap.add(value); // Add the new value to the end of the heap
        int currentIndex = heap.size() - 1; // Get the index of the newly added value

        // Bubble up to restore the heap property if the current value is less than its parent
        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex)); // Swap with the parent if current value is less
            currentIndex = parent(currentIndex); // Move up to the parent index
        }
    }

    // Extracts and returns the minimum value from the heap
    @Override
    public int extract() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty"); // Throw exception if the heap is empty
        }

        int min = heap.get(0); // The minimum value is at the root
        int lastElement = heap.remove(heap.size() - 1); // Remove and store the last element

        if (!heap.isEmpty()) {
            heap.set(0, lastElement); // Move the last element to the root

            // Bubble down to restore the heap property
            int currentIndex = 0;
            while (true) {
                int left = leftChild(currentIndex); // Index of the left child
                int right = rightChild(currentIndex); // Index of the right child
                int smallest = currentIndex; // Assume the smallest value is at the current index

                // Check if the left child exists and is smaller than the current smallest value
                if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                    smallest = left; // Update smallest if left child is smaller
                }

                // Check if the right child exists and is smaller than the current smallest value
                if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                    smallest = right; // Update smallest if right child is smaller
                }

                if (smallest == currentIndex) {
                    break; // If the current index is the smallest, the heap property is restored
                }

                swap(currentIndex, smallest); // Swap with the smallest child
                currentIndex = smallest; // Move down to the smallest child's index
            }
        }

        return min; // Return the minimum value
    }
    // Returns the maximum value from the heap without removing it
    public int peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty"); // Throw exception if the heap is empty
        }
        return heap.get(0); // Return the maximum value (root of the heap)
    }

    // Checks if the heap is empty
    @Override
    public boolean isEmpty() {
        return heap.isEmpty(); // Return true if the heap is empty
    }
}