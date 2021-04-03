package threads;


import com.diogonunes.jcolor.Attribute;
import utils.ColorCodesUtilities;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

class  TestingSynchronized{

    private TestingSynchronized(){}

    //Bill Pugh Singleton Implementation
    private static class SingletonHelper{
        private static final TestingSynchronized INSTANCE = new TestingSynchronized();
    }

    public static TestingSynchronized getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public synchronized void  printColorize(long threadId, Attribute text , Attribute textColor, Attribute background){
        //only one thread will execute this method at a time
        //object lock principle
        for(int i =0 ; i<500; i ++){
            String textToPrint = "ThreadId : "+ threadId +" , Count " + i;
            System.out.println(colorize(textToPrint, text, textColor, background));
        }
    }
}


class Task1 extends Thread{
    public void run() {
        long id = Thread.currentThread().getId();
        TestingSynchronized tsync = TestingSynchronized.getInstance();
        tsync.printColorize(id, BOLD(), BRIGHT_YELLOW_TEXT(), GREEN_BACK());
    }
}

class Task2 implements  Runnable{
    @Override
    public void run() {
        long id = Thread.currentThread().getId();

        for(int i =0 ; i<100; i ++){
            System.out.println(ColorCodesUtilities.ANSI_RED + "ThreadId : "+ id +" , count " + i + ColorCodesUtilities.ANSI_RESET);
        }
    }
}

class Task extends Thread{
    int id;
    Attribute text ;
    Attribute textColor;
    Attribute background;

    public Task(int id, Attribute text, Attribute textColor, Attribute background) {
        this.id = id;
        this.text = text;
        this.textColor = textColor;
        this.background = background;
    }

    public void run() {
        long threadId = Thread.currentThread().getId();
        String textToPrint = "ThreadId : "+ id + " Started with ThreadId " + threadId + "!";
        System.out.println(colorize(textToPrint, text, textColor, background));

        TestingSynchronized tsync = TestingSynchronized.getInstance();
        tsync.printColorize(threadId,  text, textColor, background);
        textToPrint = "ThreadId : "+ id + " Ended with ThreadId " + threadId + "!";
        System.out.println(colorize(textToPrint, text, textColor, background));
    }
}



public class BasicsOfThreadsRunner01 {
    /*2 ways of creating threads
     *Extends thread
     *Implementing runnable interface
     */

    /*States Of Thread
     *1)NEW
     *2)RUNNABLE
     *  RUNNING
     *3)BLOCKED/WAITING
     *4)TERMINATED/DEAD
     */

    /* Priority
     * MIN_PRIORITY 1
     * MAX_PRIORITY 1
     * NORMAL_PRIORITY 5
     */

    /*
     *Thread.sleep()
     *Thread.yield()
     *synchronized
     */

    public static void main(String[] args) {
            Task1 t1 = new Task1();
            t1.start();
            Thread t2 = new Thread(new Task2());
            t2.start();
            Task t3 = new Task(1 , BOLD(), BRIGHT_RED_TEXT(), BRIGHT_MAGENTA_BACK());
            t3.start();


            /*
             Thread task1&2 should complete before t1 starts
             */
            Thread t4 = new Thread(new Runnable(){

                @lombok.SneakyThrows
                @Override
                public void run(){
                    t1.join(); //wait for t1 and t2 to complete
                    t2.join();
                    long id = Thread.currentThread().getId();
                    for(int i =0 ; i<100 ; i ++){
                        System.out.println(ColorCodesUtilities.ANSI_GREEN + "ThreadId : "+ id +" , count " + i + ColorCodesUtilities.ANSI_RESET);
                    }
                }
            });

            t4.start();
    }
}

