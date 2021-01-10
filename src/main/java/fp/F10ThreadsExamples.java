package fp;

import java.util.stream.IntStream;

public class F10ThreadsExamples {

    public static void main(String[] args) {
        Runnable r1 = () -> {
            for(int i =0 ; i <=100000 ; i++){
                System.out.println(Thread.currentThread().getId() +" -> "+ i);
            }
        };

        Runnable r2 = () ->{
            IntStream.rangeClosed(0, 100000).forEach(i ->System.out.println(Thread.currentThread().getId()  +" -> "+ i));
        };


        Thread t1 = new Thread(r2);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r2);
        t1.start();
        t2.start();
        t3.start();

    }
}
