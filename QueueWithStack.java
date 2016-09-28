import java.util.Stack;

public class QueueWithStack {

	public Stack<Integer> stack1 = new Stack<Integer>();
	public Stack<Integer> stack2 = new Stack<Integer>();
	int currentSize;

	public void enqueue(int value) {
		stack1.push(value);
		System.out.println("The value " + value + " has been added to stack1");
		currentSize++;
	}

	public void dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			while (!stack2.isEmpty()) {
				int temp = 0;
				temp = stack2.pop();

				System.out.println("The value " + temp
						+ " has been removed from stack2");
			}
		}
		currentSize = 0;
	}

	public boolean isEmpty() {
		boolean status = false;
		if (currentSize == 0) {
			status = true;
		}
		return status;
	}

	public static void main(String[] args) {
		QueueWithStack queue = new QueueWithStack();
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
