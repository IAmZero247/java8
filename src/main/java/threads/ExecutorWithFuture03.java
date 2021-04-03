package threads;


import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CallableReturn {
    int id;
    List<String> list;

    public CallableReturn(int threadId, List<String> list) {
        this.id = threadId;
        this.list = list;
    }
}


class CallableTask implements Callable<CallableReturn>{
    int id;
    int count;
    Faker faker;

    public CallableTask(int id, int count) {
        this.id = id;
        this.count =count;
        this.faker = new Faker();
    }

    @Override
    public CallableReturn call() throws Exception {
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        List<String> names =  IntStream.rangeClosed(1, count)
                .mapToObj( i -> faker.name().fullName())
                .collect(Collectors.toList());
        return new CallableReturn(id,names);
    }
}

public class ExecutorWithFuture03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /* Future Sample Code
         *ExecutorService es = Executors.newFixedThreadPool(1);
         *Future<CallableReturn> future = es.submit(new CallableTask(1,10));
         *CallableReturn result = future.get();
         *result.list.forEach(System.out::println);
         *es.shutdown();
         */


        /*InvokeAll
         * Future Sample Code - Run many futureTask In parallel
         *ExecutorService es = Executors.newFixedThreadPool(3);
         *List<CallableTask> callableSamples = List.of(new CallableTask(1, 10), new CallableTask(2, 5), new CallableTask(3, 25));
         *List<Future<CallableReturn>> futures = es.invokeAll(callableSamples);
         *for(Future<CallableReturn> f:futures){
         *    System.out.println(f.get().list);
         *}
         *es.shutdown();
         */

        //InvokeAny
        //Future Sample Code - Run many futureTask In parallel and wait only till the fastest is completed
        //fetching data from cassandra/elasticsearch/redis
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<CallableTask> callableSamples = List.of(new CallableTask(1, 15), new CallableTask(2, 5), new CallableTask(3, 25));
        CallableReturn callableReturn = es.invokeAny(callableSamples);
        System.out.println(callableReturn.id);
        System.out.println(callableReturn.list);
        es.shutdown();

    }
}
