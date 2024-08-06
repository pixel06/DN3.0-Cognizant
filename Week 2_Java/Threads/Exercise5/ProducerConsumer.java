package Exercise5;

import java.util.*;

public class ProducerConsumer {

    public static void main(String[] args) {

         DataQueue dq = new DataQueue();

        Producer p1 = new Producer(dq);
        Producer p2 = new Producer(dq);
        Consumer c1 = new Consumer(dq);
        Consumer c2 = new Consumer(dq);

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }


    
}

class DataQueue extends Thread
{
    final Queue<Integer> queue = new LinkedList<>();
    final int capacity = 10;

    public synchronized void produce(int data) throws InterruptedException
    {
        while(queue.size() == capacity)
        {
            wait();
        }
        queue.add(data);
        System.out.println("Produced: " + data);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException
    {
        while(queue.isEmpty())
        {
            wait();
        }
        int data = queue.poll();
        System.out.println("Consumed: " + data);
        notifyAll();
        return data;
    }

}

class Producer extends Thread {
     
    final DataQueue dataQueue;

    public Producer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                dataQueue.produce(i);
                Thread.sleep(100); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
     
    final DataQueue dataQueue;

    public Consumer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                dataQueue.consume();
                Thread.sleep(150); // Simulate time taken to consume data
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


