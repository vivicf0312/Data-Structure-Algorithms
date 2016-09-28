public class LinkedList1<E> {
	private cyclicNode<E> head = null;
	private cyclicNode<E> tail = null;
	private cyclicNode<E> temp = null;
	private int counter = 0;

	public LinkedList1() {
	}

	public void print(){
		for(cyclicNode n = head; n != null; n = n.next){
			System.out.println(" " + n.elem.toString());
		}
		System.out.println(" ");
	}
	public int size() {
		return counter;
	}

	public void add(E elem) {
		//if we don't have any elems in our LinkedList
		if (head == null) {
			head = new cyclicNode<E>();
			tail = head;
			head.elem = elem;
			head.next = tail;
			
		} else {
			tail.next = new cyclicNode();//add a new node to the end of the list
			tail = tail.next;//set the tail pointer to that node
			tail.elem = elem;//set elem to be store to the end node
		}
		counter++;
	}

	// if it was doubly Linked List
	public void add(int index, E elem) {
		/*
		 * If the user wants to add it to the end of the list call the other
		 * add() method, which is more efficient and then end this method
		 */
		if (index == size()) {
			add(elem);
			return;
		} else if (index == 0) {
			cyclicNode<E> temp = new cyclicNode<E>();
			temp.elem = elem;
			temp.next = head;
			head.previous = temp;
			head = temp;
			counter++;
			return;
		}
		/*
		 * Here, we start to see the temp node come into play. We use it to
		 * track the current node without modifying the head node.
		 */
		temp = head;
		for (int i = 0; i < index - 1; i++)
			temp = temp.next;// move to the next node

		cyclicNode<E> myNode = new cyclicNode<E>();// create a new node
		myNode.elem = elem;// and set the elem
		myNode.next = temp.next; // set it to point to the next elem
		temp.next = myNode;// set the previous elem to point to it
		counter++;// increment the count
	}

	public E get(int index) {
		// forces the index to be valid
		assert (index >= 0 && index < size());
		temp = head; // start at the head of the list
		// iterate to the correct node
		for (int i = 0; i < index; i++)
			temp = temp.next;
		return temp.elem;// and return the corresponding element
	}

	// returns first index of the given elem
	// retuns -1 if the element not found
	public int get(E elem) {
		return indexOf(elem);
	}

	public int indexOf(E elem) {
		temp = head;// start at the beginning of the list
		int i = 0;// create counter field that isn't local to a loop

		// while we haven't found the elem we are looking for, keep looking
		for (; !(temp.elem).equals(elem) && temp != null; i++)
			temp = temp.next;
		if (i == size())
			return -1;// if the elem was not found, return -1
		return i; // otherwise, return the index
	}

	public E remove(int index) {
		assert (index >= 0 && index < size());//force valid index
		temp = head;//start at the beginning of the list

		// iterate to the position before the index
		for (int i = 0; i < index; i++){
			temp = temp.next;
		}
		cyclicNode<E> two = temp.next;

		// set temp.next to point to the Node next to the Node to be removed
		temp.next = two.next;
		E elem = two.elem;// store the element to return
		two = null;// remove the Node
		return elem;
	}

	public E remove(E elem) {
		temp = head;
		cyclicNode<E> two = null;

		if (head.elem.equals(elem)) {
			head = head.next;
			head.previous = null;
			counter--;
			return elem;
		} else if (tail.elem.equals(elem)) {
			tail = tail.previous;
			tail.next = null;
			counter--;
			return elem;
		}
		// while the elem hasn't been found but there is another node
		while (temp != null && !temp.equals(elem)) {
			two = temp;// have a reference to the element before the one to
						// remove
			temp = temp.next;// in this method, temp will be the element to
								// remove
		}
		// if the element was not found, return null
		if (temp == null)
			return null;

		two.next = temp.next;
		E spare = temp.elem;// return element
		temp = null;
		counter--;
		return spare;

	}
	public static void main(String[] args){
		LinkedList1<Integer> ll = new LinkedList1<Integer>();
		
		for(int i=0;i<10;i++){
			ll.add(i);
		}
		assert(ll.size() == 10);
		ll.print();
		
		Integer v = ll.remove(1);
		System.out.println("removed: " + v);
		ll.print();
		assert(ll.size()== 9);
	}
}

class cyclicNode<E> {
	E elem;
	cyclicNode<E> next, previous;

}