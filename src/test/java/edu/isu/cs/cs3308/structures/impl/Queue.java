package test.java.edu.isu.cs.cs3308.structures.impl;

public class Queue
{
    QNode front, rear = null;
    int size = 0;

    public Queue()
    {
        front = null;
        rear = null;
        size = 0;
    }

    //Check if null.
    public boolean isEmpty()
    {
        return front == null;
    }

    //Get queue size.
    public int getSize()
    {
        return size;
    }

    // Add key to the queue.
    void enqueue(int key)
    {

        // Create linked list node.
        QNode temporary = new QNode(key);

        // Check empty queue.
        if (this.rear == null)
        {
            this.front = this.rear = temporary;
            return;
        }

        // Add new node to end of queue
        this.rear.next = temporary;
        this.rear = temporary;
    }

    // Remove a key from queue. (method)
    QNode dequeue()
    {
        // If empty queue, null output.
        if (this.front == null)
        {
            return null;
        }

        // Adjust front node.
        QNode temporaryHold = this.front;
        this.front = this.front.next;

        // If front null, and null.
        if (this.front == null)
        {
            this.rear = null;
        }
        return temporaryHold;
    }

}
