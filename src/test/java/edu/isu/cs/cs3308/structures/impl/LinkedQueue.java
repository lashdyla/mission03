package test.java.edu.isu.cs.cs3308.structures.impl;

public class LinkedQueue
{
    public static boolean scan(StackObj stackO, int x)
    {
        QueueObj queueO = new QueueObj(stackO.getSize());
        boolean located =false;
        while(!stackO.isEmpty()){
            if(((Integer)stackO.top()).intValue() == x)
            {
                located = true;
                break;
            }
            queueO.enqueue(stackO.pop());
        }
        //Return ordered s elements.
        while(!queueO.isEmpty())
        {
            for(int i=1; i < queueO.getSize(); i++) {
                queueO.enqueue(queueO.dequeue());
            }
            stackO.push(queueO.dequeue());
        }
        return located;
    }
}
