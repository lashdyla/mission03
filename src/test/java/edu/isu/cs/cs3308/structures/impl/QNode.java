package test.java.edu.isu.cs.cs3308.structures.impl;

public class QNode
{
    int key;
    QNode next;
    QNode prev;
    QNode head;
    QNode tail;
    QNode data;

    // Node constructor.
    public QNode(int key)
    {
        this.key = key;
        this.next = null;
    }

    // Add node to list front.
    public void push(int new_data)
    {
        QNode new_Node = new QNode(new_data);

        new_Node.next = head;
        new_Node.prev = null;

        if (head != null)
            head.prev = new_Node;

        //Assign new node as head.
        head = new_Node;
    }

    //Insert new node after stated node.
    public void AddAfter(QNode prev_Node, int new_data)
    {
        //Check if contents null.
        if (prev_Node == null)
        {
            System.out.println("You cannot choose a null node.");
            return;
        }

        QNode new_node = new QNode(new_data);

        new_node.next = prev_Node.next;

        prev_Node.next = new_node;

        new_node.prev = prev_Node;

        if (new_node.next != null)
        {
            new_node.next.prev = new_node;
        }
    }

    //Add node at end of list
    void addLast(int input)
    {
        QNode input_node = new QNode(input);

        QNode last = head;

        input_node.next = null;

        if (head == null) {
            input_node.prev = null;
            head = input_node;
            return;
        }

        while (last.next != null)
        {
            last = last.next;
        }

        last.next = input_node;

        input_node.prev = last;
    }

    //Check front element.
    public int peek()
    {
        return head.getData();
    }
}
