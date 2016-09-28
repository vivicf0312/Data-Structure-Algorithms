public class CircularLinkedList {

	private Node2 start;
	private int count;

	public void append(int x) {
		count++;
		Node2 temp = new Node2(x);
		if (start == null) {
			start = temp;
		} else {
			Node2 tp = start;
			while (tp.link != start) {
				tp = tp.link;
			}
			tp.link = temp;
		}
		temp.link = start;
	}

	public void addBeg(int x) {
		count++;
		Node2 temp = new Node2(x);
		if (start == null) {
			temp.link = temp;
		} else {
			Node2 tp = start;
			while (tp.link != start) {
				tp = tp.link;
			}
			tp.link = temp;
			temp.link = start;
		}
		start = temp;
	}

	public void addAt(int pos, int x) {
		Node2 temp, tp;
		temp = new Node2(x);
		tp = start;
		for (int i = 0; i < pos; i++) {
			if (tp.link == start)
				break;
			tp = tp.link;
		}
		temp.link = tp.link;
		tp.link = temp;
		count++;
	}

	public void displayList() {
		if (start == null) {
			System.out.println("List is empty");
		} else {
			Node2 temp = start;
			System.out.print("->");
			while (temp.link != start) {
				System.out.println(" " + temp.data);
				temp = temp.link;
			}
			System.out.println(temp.data + " ->");
		}
	}

	public void deteleAt(int position) {
		Node2 current = start;
		Node2 previous = start;
		for (int i = 0; i < position; i++) {
			if (current.link == start)
				break;
			previous = current;
			current = current.link;
		}
		System.out.print(current.data);
		if (position == 0) {
			deleteFirst();
		} else {
			previous.link = current.link;
			count--;
		}
	}

	public void deleteFirst() {
		Node2 temp = start;
		while (temp.link != start) {
			temp = temp.link;
		}
		temp.link = start.link;
		start = start.link;
		count--;
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.addBeg(1);
		cll.addBeg(2);
		cll.addBeg(3);
		cll.addBeg(4);
		cll.addAt(1, 0);
		cll.append(5);
		cll.append(12);
		cll.displayList();
		cll.deteleAt(1);
		System.out.println("After deletion ");
		cll.displayList();

	}

}

class Node2 {
	int data;
	Node2 link;

	public Node2(int data) {
		this.data = data;
	}

	public Node2(int data, Node2 link) {
		this.data = data;
		this.link = link;
	}
}