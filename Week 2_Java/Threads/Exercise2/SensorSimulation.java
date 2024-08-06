package Exercise2;

import java.util.Random;

public class SensorSimulation {

    public static void main(String[] args) {
        
        Sensor s1 = new Sensor("Sound");
        Sensor s2 = new Sensor("Water");
        Sensor s3 = new Sensor("Fire");

        s1.start();
        s2.start();
        s3.start();

        try {

            s1.join();
            s2.join();
            s3.join();
            
        } catch (Exception e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("All sensors have completed data collection.");
    }
    
}

class Sensor extends Thread
{
    public String name;
    public Random num;

    public Sensor(String name)
    {
        this.name = name;
        this.num = new Random();
    }

    @Override

    public void run()
    {
        try {
        for (int i = 0; i < 10; i++) {
            int data = num.nextInt(100);
            System.out.println("Sensor name: " + name + ", data: " + data);

            Thread.sleep(500);
        }
    } catch(InterruptedException e)
    {
         System.out.println(name + " was interrupted");
    }
}
}