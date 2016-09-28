public class Queue {

	int maxSize;
	int arr[];
	int rear;// tail
	int front;// front
	int currentSize;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
		this.rear = -1;
		this.front = -1;
		this.currentSize = 0;
	}

	public void enqueue(int value) {

		if (isFull()) {
			System.out.println("Overflow! Unable to add more elements" + value);
		} else {
			rear++;
			if (rear == maxSize) {
				rear = 0;
			}
			arr[rear] = value;
			currentSize++;
			System.out.println("Element " + value
					+ " has been added to the queue");
		}
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Underflow, unable to remove more elements");
		} else {

			// ***Method B, decreasing array***
			// front++;
			// if (front == arr.length - 1) {
			// System.out.println("removed: " + arr[front]);
			// front = 0;
			// }
			// else {
			// System.out.println("removed: " + arr[front]);
			// }

			// currentSize--;

			// *** Method A, shift the remaining elements one position***
//			if (rear == 0) {
//				System.out.println("removed: " + arr[rear]);
//				rear = -1;
//			} else {
				for (int i = 0; i <= rear; i++) {
					if (i == rear) {
						System.out.println("removed: " + arr[i]);
						currentSize = 0;
					} else {
						System.out.println("removed: " + arr[i]);
						arr[i] = arr[i + 1];
					}
				}
			//}
		}
	}

	public boolean isFull() {
		boolean status = false;
		if (currentSize == maxSize) {
			status = true;
		}
		return status;
	}

	public boolean isEmpty() {
		boolean status = false;
		if (currentSize == 0) {
			status = true;
		}
		return status;
	}

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);

		while (!queue.isEmpty()) {
			queue.dequeue();
		}
	}

}
