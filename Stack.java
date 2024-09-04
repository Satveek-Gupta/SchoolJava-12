// Stack.java
public class Stack {
    // Data Members
    private int[] arr;
    private int size;
    private int top;

    // Constructor to initialize size and top
    public Stack(int s) {
        this.size = s;
        this.arr = new int[size];
        this.top = -1; // Indicates an empty stack
    }

    // Method to push a value onto the stack
    public void pushValues(int v) {
        if (top >= size - 1) {
            System.out.println("Overflow");
        } else {
            arr[++top] = v;
            System.out.println("Pushed: " + v);
        }
    }

    // Method to pop a value from the stack
    public int popValues() {
        if (top < 0) {
            System.out.println("Underflow");
            return -999;
        } else {
            return arr[top--];
        }
    }

    // Method to display the stack elements
    public void display() {
        if (top < 0) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an instance of Stack class with a size of 5
        Stack stack = new Stack(5);

        // Push values onto the stack
        stack.pushValues(10);
        stack.pushValues(20);
        stack.pushValues(30);
        stack.pushValues(40);
        stack.pushValues(50);

        // Attempt to push another value to test overflow
        stack.pushValues(60);

        // Display stack elements
        stack.display();

        // Pop values from the stack
        System.out.println("Popped: " + stack.popValues());
        System.out.println("Popped: " + stack.popValues());

        // Display stack elements after popping
        stack.display();

        // Attempt to pop from an empty stack to test underflow
        stack.popValues();
        stack.popValues();
        stack.popValues();
    }
}
