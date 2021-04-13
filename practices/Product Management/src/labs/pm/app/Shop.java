/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
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
        // TODO code application logic here
        ProductManager pm = new ProductManager("en-GB");
        //pm.PrintProductReport(101);
//        pm.CreateProduct(102, "Coffe", BigDecimal.valueOf(50.99), Rating.FOUR_STAR);
//        pm.reviewProduct(102, Rating.FOUR_STAR, "bad service");
//        pm.reviewProduct(102, Rating.TWO_STAR, "the coffe is too light");
//        pm.reviewProduct(102, Rating.THREE_STAR, "it is expensive");
//        //pm.dumpData();
//        //pm.restoreData();
//        pm.PrintProductReport(103);
//        pm.PrintProductReport(102);
//        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
//        Comparator<Product> priceSorter = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());
//        pm.printproducts(p -> p.getPrice().floatValue() < 7, ratingSorter);
//
//        pm.getDiscounts().forEach(
//                (rating, discount) -> System.out.println(rating + "\t" + discount));

    }

}
