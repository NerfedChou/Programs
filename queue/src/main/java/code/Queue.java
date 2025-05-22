package code;

import java.util.Scanner;

public class Queue
{
    private int maxSize;
    private String[] queue;
    private int front;
    private int rear;
    public String empty = "Queue is empty";
    public String full = "Queue is full";

    public Queue(int size) {
        maxSize = size;
        queue = new String[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    public void eQ (String value) {
        if (isFull()) {
            System.out.println(full);
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            queue[rear] = value;
        }
    }
    public String dQ() {
        if (isEmpty()) {
            System.out.println(empty);
            return null;
        } else {
            String value = queue[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            return value;
        }
    }
    public String peek() {
        if (isEmpty()) {
            System.out.println(empty);
            return null;
        } else {
            return queue[front];
        }
    }
    public void display() {
        if (isEmpty()) {
            System.out.println(empty);
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        scanner.nextLine(); 
        Queue queue = new Queue(size);

        while (true) {
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek\n4. Display\n5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "enqueue":
                case "1":
                while (true) {
                    System.out.print("Enter value to enqueue: ");
                    String value = scanner.next();
                    if (value.equalsIgnoreCase("exit")) {
                        scanner.nextLine(); // Clear the buffer
                        break;
                    }
                    queue.eQ(value);
                }
                    break;
                case "dequeue":
                case "2":
                    while (true) {
                    String remove = scanner.nextLine();
                    if(remove.equalsIgnoreCase("done")) break;
                    
                    System.out.println("Dequeued: " + queue.dQ());
                    }
                    break;
                case "peek":
                case "3":
                    String peek = queue.peek();
                    if (peek == null) {
                        System.out.println("Queue is empty, nothing to peek.");
                    } else {
                        System.out.println("Peek: " + peek);
                    }
                    
                    break;
                case "display":
                case "4":
                    queue.display();
                    break;
                case "exit":
                case "5":
                   scanner.close();
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
