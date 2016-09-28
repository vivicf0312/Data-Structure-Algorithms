import java.util.Arrays;

public class MyStack {

	private int maxSize;
	private long[] stackArray;
	private int top;

	public MyStack(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new long[maxSize];
		this.top = -1;//stack is empty
	}

	public void push(long j) {
		stackArray[++top] = j;
	}

	public long pop() {
		return stackArray[top--];
	}

	public long peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {
		
		MyStack theStack = new MyStack(10);
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);
		
		System.out.println("Values getting removed from the stack: ");
		while (!theStack.isEmpty()) {
			long value = theStack.pop();
			System.out.print(value);
			System.out.println(" ");
		}
		System.out.println("");
	}

}
