package com.flightAggregator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class FlightMain {
    //src to destination and on a particularData
    //call three different service and get the result back
    //we will do it by multi-threaded

    public static void main(String[] args) throws ParseException {
    String dateString = "2024-12-14";

    // Define the date format
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //create three service first
    //indigo,Akaksar, air service
    FlightService indigoService = new IndigoService();
        FlightService airIndiaService = new AirIndiaService();
        FlightService akasaService = new AkasaService();


        //create task out of it
        List<CallableTask > tasks = new ArrayList<>();
        tasks.add(new CallableTask("mumbai","delhi",sdf.parse(dateString),indigoService));
        tasks.add(new CallableTask("mumbai","delhi",sdf.parse(dateString),airIndiaService));
        tasks.add(new CallableTask("mumbai","delhi",sdf.parse(dateString),akasaService));

        //call these three flights and get the result
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //go through all the task and submit it to executor service
//        for(int i=0;i<3;i++){
//
//        }

        //for every task submit it to executor service
        tasks.stream().map(
                new Function<CallableTask, Future<List<FlightData>>>() {
                    @Override
                    public Future<List<FlightData>> apply(CallableTask callableTask) {
                        return executorService.submit(callableTask);
                    }
                }
        ).forEach(
                (currentServiceResult) -> {
                    try {
                        System.out.println(currentServiceResult.get());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }

        );

        executorService.shutdown();





    }
}
