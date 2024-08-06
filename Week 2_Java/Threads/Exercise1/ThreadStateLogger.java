package Exercise1;

class ThreadStateLogger
{
    public static void main(String[] args) {

        simpleThread  st = new simpleThread();

        System.out.println("Before starting: " + st.getState());

        st.start();

        System.out.println("After starting: " + st.getState());

        while(st.isAlive())
        {
            System.out.println("During execution: " + st.getState());
        }

        System.out.println("After execution: " + st.getState());

    }
}

class simpleThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
            }
        } catch (Exception e) {
                e.printStackTrace();
            
        }
    }
}