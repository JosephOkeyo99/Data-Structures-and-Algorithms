public class QueueOperations {
    private static final int MAX = 5;
    private static int[] queue = new int[MAX];
    private static int front = -1;
    private static int rear = -1;

    // 1. Insert Operation (Enqueue)
    public static void enqueue(int x) {
        if (rear == MAX - 1) {
            System.out.println("Queue is FULL!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            queue[rear] = x;
            System.out.println(x + " has been enqueued");
        }
    }

    // 2. Delete Operation (Dequeue)
    public static int dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is EMPTY!");
            return -1;
        } else {
            int item = queue[front];
            System.out.println(item + " has been dequeued (deleted)");
            front++;
            
            // Reset queue when all elements are removed
            if (front > rear) {
                front = -1;
                rear = -1;
            }
            return item;
        }
    }

    // 3. Update Operation
    public static void update(int oldValue, int newValue) {
        if (front == -1) {
            System.out.println("Queue is EMPTY!");
            return;
        }

        boolean found = false;
        for (int i = front; i <= rear; i++) {
            if (queue[i] == oldValue) {
                queue[i] = newValue;
                System.out.println("Updated " + oldValue + " to " + newValue);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Element " + oldValue + " not found in the queue.");
        }
    }

    // display current queue status
    public static void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Current Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Enqueue / Insert Operations
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);
        enqueue(60); // Triggers "Queue is FULL!" because MAX = 5

        display();

        // Update Operation
        update(30, 35);
        display();

        // Dequeue / Delete Operations
        dequeue();
        dequeue();
        display();
    }
}