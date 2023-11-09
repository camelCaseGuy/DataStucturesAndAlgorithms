// 1. Make a single linked list of integers.  There should be at least 15 nodes.
// The list should not be sorted.
// Traverse the list.
// Now sort the list using Selection Sort  /do not use any other sorting algorithm.
// The list should be sorted such that your program unlinks the nodes and relinks
// them so that they are sorted. (DO NOT SWAP THE VALUES IN THE NODES).
// Traverse the list again.
// Submit the complete code.
// submit Screen shot of your program execution.

import java.io.*;

public class LinkedList {

	static class Node {
		int val;
		Node next;

		// Constructor
		Node(int d) {
			val = d;
			next = null;
		}
	}

	// Method to insert a new node
	public static LinkedList insert(LinkedList list, int val) {
		// Create a new node with given val
		Node new_node = new Node(val);

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	// Method to print the LinkedList.
	public static void printList(LinkedList list) {
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the val at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public static void main() {
		LinkedList list = new LinkedList();

	}
}
