package org.example;

public class Main {
    public static void main(String[] args) {

        MaxPriorityQueue maxHeap = new MaxPriorityQueue(); // Instantiate a MaxHeap object

        // Insert elements into the MaxHeap
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);

        // Display and extract elements from the MaxHeap
        while (!maxHeap.isEmpty()) {
            System.out.println("Peeked from MaxHeap: " + maxHeap.peek());
            System.out.println("Extracted from MaxHeap: " + maxHeap.extract());
            System.out.println("Peeked from MaxHeap: " + maxHeap.peek());

        }

        // Create and demonstrate the MinHeap class
        System.out.println("\nMinHeap Demonstration:");
        MinPriorityQueue minHeap = new MinPriorityQueue(); // Instantiate a MinHeap object

        // Insert elements into the MinHeap
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(15);

        // Display and extract elements from the MinHeap
        while (!minHeap.isEmpty()) {
            System.out.println("Peeked from MinHeap: " + minHeap.peek());
            System.out.println("Extracted from MinHeap: " + minHeap.extract());
            System.out.println("Peeked from MinHeap: " + minHeap.peek());
        }
    }


}