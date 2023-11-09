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

class LinkedList {
	Node head;
	LinkedList(Node head){
		this.head = head;
	}

	static class Node {
		int val;
		Node next;

		// Constructor to create a new node
		// Next is by default initialized
		// as null
		Node(int v) {
			val = v;
		}
	}

	public static void main() {
		Node node1 = new Node(3);
		LinkedList list = new LinkedList(node1);
	}
}
