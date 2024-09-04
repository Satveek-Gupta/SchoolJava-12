// SQ.java
public class SQ {
    // Data Members
    private int[] arr;
    private int size;
    private int front;
    private int rear;

    // Constructor to initialize the queue
    public SQ(int s) {
        this.size = s;
        this.arr = new int[size];
        this.front = -1; // Indicates an empty queue
        this.rear = -1;  // Indicates an empty queue
    }

    // Method to add a value at the rear of the queue
    public void addRear(int v) {
        if ((rear + 1) % size == front) {
            // Queue is full
            System.out.println("Queue full at the rear end... OVERFLOW");
        } else {
            if (front == -1) {
                // First element added
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = v;
            System.out.println("Added: " + v);
        }
    }

    // Method to delete a value from the front of the queue
    public int deleteFront() {
        if (front == -1) {
            // Queue is empty
            System.out.println("Queue empty... UNDERFLOW");
            return -999;
        } else {
            int value = arr[front];
            if (front == rear) {
                // Queue becomes empty after this operation
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return value;
        }
    }

    // Method to display elements of the queue
    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            while (true) {
                System.out.print(arr[i] + " ");
                if (i == rear) {
                    break;
                }
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an instance of SQ class with a size of 5
        SQ queue = new SQ(5);

        // Add values to the queue
        queue.addRear(10);
        queue.addRear(20);
        queue.addRear(30);
        queue.addRear(40);
        queue.addRear(50);

        // Attempt to add another value to test overflow
        queue.addRear(60);

        // Display queue elements
        queue.display();

        // Delete values from the queue
        System.out.println("Removed: " + queue.deleteFront());
        System.out.println("Removed: " + queue.deleteFront());

        // Display queue elements after deletion
        queue.display();

        // Attempt to delete from an empty queue to test underflow
        queue.deleteFront();
        queue.deleteFront();
        queue.deleteFront();
    }
}
