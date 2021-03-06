/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 * {@code shop} class represents properties of Product Managemet
 *
 * @version 4.0
 * @author oracle
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProductManager pm = ProductManager.getInstance();
        AtomicInteger clientCount = new AtomicInteger(0);
        Callable<String> client = () -> {
            String clientId = "Client" + clientCount.incrementAndGet();
            String threadName = Thread.currentThread().getName();
            int productId = ThreadLocalRandom.current().nextInt(21) + 101;
            String languageTag = ProductManager.getSupportedLocales()
                    .stream()
                    .skip(ThreadLocalRandom.current().nextInt(4))
                    .findFirst().get();
            StringBuilder log = new StringBuilder();
            log.append(clientId + " " + threadName + "\n-\tstart of log\t-\n");
            
            log.append(pm.getDiscounts(languageTag)
                    .entrySet()
                    .stream()
                    .map(entry->entry.getKey()+"\t"+entry.getValue())
                    .collect(Collectors.joining("\n"))
            );
            Product product=pm.reviewProduct(productId, Rating.FOUR_STAR, "Yet another review");
            log.append(product!=null?"\nProduct"+productId+"reviewed\n":"\nProduct"+productId+"not reviewed\n");
            pm.PrintProductReport(productId, languageTag, clientId);
            log.append(clientId + " generated report for" + productId+" product");
            log.append("\n-\tend of log\t-\n");
            return log.toString();
        };

        List<Callable<String>> clients=Stream.generate(()->client)
                                             .limit(5)
                                             .collect(Collectors.toList());
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> results=executorService.invokeAll(clients);
            executorService.shutdown();
            results.stream().forEach(result->{
                try {
                    System.out.println(result.get());
                } catch (InterruptedException |ExecutionException ex) {
                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error retrieving client log", ex);
                } 
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error invoking clients", ex);
        }
        
        
        
    }

}
