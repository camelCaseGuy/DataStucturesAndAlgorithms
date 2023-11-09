
public class Test {
	static Node head;
	Node tmp;

	Test(Node newNode) {
		if (this.head == null) {
			this.head = newNode;
			tmp = this.head;
			System.out.println("head.val>" + head.val);
		} else {
			if (head.next == null) {
				head.next = newNode;
			} else {
				while (tmp.next != null) {
					tmp = newNode.next;
					
				}
			}
		}
	}

	class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public void printNodes(Test testToPrint) {

		System.out.println(testToPrint);
	}

	public static void main(String[] args) {
		Test myTest = new Test(head);
		Test.Node head = myTest.new Node(5);
		myTest.new Node(4);
		myTest.new Node(7);
		myTest.printNodes(myTest);
	}
}
