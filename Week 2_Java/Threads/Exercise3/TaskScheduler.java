package Exercise3;

class TaskScheduler
{
    public static void main(String[] args) {
        
        Task t1 = new Task("wake", 200);
        Task t2 = new Task("brush", 200);
        Task t3 = new Task("bath", 200);

        t1.start();
        t2.start();
        t3.start();


        try{

            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Main thread was interrupted");
        }

        System.out.println("All tasks have completed.");
    }

}

class Task extends Thread{

    String name;
    int sleepTime;

    public Task(String name, int sleepTime)
    {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    @Override

    public void run()
    {
        System.out.println(name + " is starting.");

    try
    {
        for (int i = 0; i<5; i++) {
            System.out.println(name + " is working. Step: " + (i+1));
            Thread.sleep(sleepTime);
            if(i==2)
            {
                System.out.println(name + " yielding to other tasks.");
                Thread.yield();
            }
            
        }

    } catch(InterruptedException ex)
    {
        System.out.println(name + " was interrupted.");
    }
    System.out.println(name + " has completed");
}



}