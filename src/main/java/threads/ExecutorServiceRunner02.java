package threads;

import com.diogonunes.jcolor.Attribute;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.diogonunes.jcolor.Attribute.*;

public class ExecutorServiceRunner02 {
    public static void main(String[] args) {
        /*newSingleThreadExecutor()
          This will execute one thread at time , sequentially
          ExecutorService es = Executors.newSingleThreadExecutor();
          es.execute(new Task1());
          es.execute(new Thread(new Task2()));
          es.shutdown();
         */
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Task(1, Attribute.ITALIC() , BRIGHT_YELLOW_TEXT(), RED_BACK()));
        es.execute(new Task(2, Attribute.ITALIC(), BRIGHT_GREEN_TEXT(), BLUE_BACK()));
        es.execute(new Task(3, Attribute.BOLD() , BRIGHT_MAGENTA_TEXT(), YELLOW_BACK()));
        es.execute(new Task(4, Attribute.BOLD(), BRIGHT_WHITE_TEXT(), GREEN_BACK()));
        es.shutdown();


    }
}
