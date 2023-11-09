import java.io.Console;

// 1. Make a single linked list of integers.  There should be at least 15 nodes.
// The list should not be sorted.
// Traverse the list.
// Now sort the list using Selection Sort  /do not use any other sorting algorithm.
// The list should be sorted such that your program unlinks the nodes and relinks
// them so that they are sorted. (DO NOT SWAP THE VALUES IN THE NODES).
// Traverse the list again.
// Submit the complete code.
// submit Screen shot of your program execution.

public class SinglyLinkedList {
	Node head, tail;

	public SinglyLinkedList(int headVal) {
		head = new Node();
		head.val = headVal;
	}

	public SinglyLinkedList() {
		Node head;
	}

	class Node {
		int val;
		Node next;
	}

	void trav(Node h) {
		while (h != null) {
			System.out.println(h.val);
			h = h.next;
		}
	}

	void travrec(Node h) {
		if (h == null)
			return;
		System.out.println(h.val);
		travrec(h.next);
	}

	void insertBefore(Node b, int v) {
		Node tmp = this.head;
		while (tmp != b) {
			tmp = tmp.next;
		}
		Node newNode = new Node();
		newNode.val = v;
		newNode.next = b;
		if (newNode.next == this.head) {
			this.head = newNode;
		}
	}

	void delete(Node tmp, Node n) {
		if (tmp == null) return;
		if (tmp.next == n) {
			tmp.next = n.next;
		} else {
			delete(tmp.next, n);
		}
	}

	void swap(Node a, Node b, SinglyLinkedList thisList) {
		Node current = thisList.head;
		Node temp = a;
		while (current != null) {
			if (current.next == a) {

			}
		}
	}


	void insertAfter(SinglyLinkedList thisList, Node n) {
//		Node tmp = thisList.head;
		if (thisList.head == null) {
			thisList.head = n;
			thisList.head.next = null;
			thisList.tail = thisList.head;
		} else {
			n.next = null;
			thisList.tail.next = n;
			thisList.tail = n;
//			while (tmp.next != null) {
//				tmp = tmp.next;
//			}
//			tmp.next = n;
//			n.next = null;
		}
	}
	
	int count(Node tmp, int count) {
		if(tmp == null) return count;
		else {
			return count(tmp.next, count + 1);
		}
	}

	SinglyLinkedList selectSort(SinglyLinkedList list) {
		SinglyLinkedList sortedList = new SinglyLinkedList();
		sortedList.head = null;
		Node current;
		Node current2;
		Node min;
		Node temp;
		current = list.head;
		while (current != null) {
			min = current;
			current2 = current.next;
			while (current2 != null) {
				if (current2.val < min.val) {
					min = current2;
				}
				current2 = current2.next;
			}

			delete(list.head, min);

//			min.next = list.head;
//			current = min;
//			list.head = min;
			
			insertAfter(sortedList, min);

			int cnt = count(list.head, 0);
			if (current.next == null && cnt > 1) {
				current = list.head;
			} else {
				current = current.next;
			}
		}
		return sortedList;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList(8);
		SinglyLinkedList finalList = new SinglyLinkedList();
		list.insertBefore(list.head, 3);
		list.insertBefore(list.head, 5);
		list.insertBefore(list.head, 12);
		list.insertBefore(list.head, 51);
		list.insertBefore(list.head, 1188);
		list.insertBefore(list.head, 18);
		list.insertBefore(list.head, 10);
		list.insertBefore(list.head, 19);
		list.insertBefore(list.head, 117);
		list.insertBefore(list.head, 161);
		list.insertBefore(list.head, 114);
		list.insertBefore(list.head, 1);
		list.insertBefore(list.head, 1331);
		list.insertBefore(list.head, 118);
//		list.trav(list.head);
		list.travrec(list.head);
		System.out.println("list.head: " + list.head.val);
		finalList = list.selectSort(list);
		finalList.travrec(finalList.head);
		System.out.println("finalList.head: " + finalList.head.val);
	}
}
