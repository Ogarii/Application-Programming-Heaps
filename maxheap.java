package org.example;

import java.util.ArrayList;

// Class representing a max heap, implementing the PriorityQueue interface
class MaxPriorityQueue implements PriorityQueue {
    private ArrayList<Integer> heap; // ArrayList to store the heap elements

    // Constructor to initialize the heap
    public MaxPriorityQueue() {
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

        // Bubble up to restore the heap property if the current value is greater than its parent
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex)); // Swap with the parent if current value is greater
            currentIndex = parent(currentIndex); // Move up to the parent index
        }
    }

    // Extracts and returns the maximum value from the heap
    @Override
    public int extract() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty"); // Throw exception if the heap is empty
        }

        int max = heap.get(0); // The maximum value is at the root
        int lastElement = heap.remove(heap.size() - 1); // Remove and store the last element

        if (!heap.isEmpty()) {
            heap.set(0, lastElement); // Move the last element to the root

            // Bubble down to restore the heap property
            int currentIndex = 0;
            while (true) {
                int left = leftChild(currentIndex); // Index of the left child
                int right = rightChild(currentIndex); // Index of the right child
                int largest = currentIndex; // Assume the largest value is at the current index

                // Check if the left child exists and is greater than the current largest value
                if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                    largest = left; // Update largest if left child is greater
                }

                // Check if the right child exists and is greater than the current largest value
                if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                    largest = right; // Update largest if right child is greater
                }

                if (largest == currentIndex) {
                    break; // If the current index is the largest, the heap property is restored
                }

                swap(currentIndex, largest); // Swap with the largest child
                currentIndex = largest; // Move down to the largest child's index
            }
        }

        return max; // Return the maximum value
    }

    // Checks if the heap is empty
    @Override
    public boolean isEmpty() {
        return heap.isEmpty(); // Return true if the heap is empty
    }
}