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
        pm.CreateProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.PrintProductReport(101);
        pm.reviewProduct(101, Rating.ONE_STAR, "nice hot cup of tea");
        pm.reviewProduct(101, Rating.TWO_STAR, "the best I have ever tasted");
        pm.reviewProduct(101, Rating.THREE_STAR, "great service");
//        pm.PrintProductReport(101);
//        pm.changeLocale("fr-FR");
        pm.CreateProduct(102, "Coffe", BigDecimal.valueOf(5.99), Rating.FOUR_STAR);
//        pm.PrintProductReport(102);
        pm.reviewProduct(102, Rating.FOUR_STAR, "bad service");
        pm.reviewProduct(102, Rating.TWO_STAR, "the coffe is too light");
        pm.reviewProduct(102, Rating.THREE_STAR, "it is expensive");

        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());
        pm.printproducts(ratingSorter);
        pm.printproducts(priceSorter);
        pm.printproducts(ratingSorter.thenComparing(priceSorter).reversed());
//        pm.PrintProductReport(102);
//        Product p3 = pm.CreateProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//        Product p4 = pm.CreateProduct(105, "Cokie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());//new Product();
//        Product p6 = pm.CreateProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
//        Product p7 = pm.CreateProduct(104, "Chocolate", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);
//        Product p9 = p1.applyRating(Rating.TWO_STAR);

//        if(p3 instanceof Food){
//            LocalDate bestBefore=((Food)p3).getBestBefore();
//        }
//            p3.getBestBefore();
//            p2.getBestBefore();
//        p1.setId(101);
//        p1.setName("Tea");
//        p1.setPrice(BigDecimal.valueOf(1.99));
//        System.out.println(p1.getId()+p1.getName()+p1.getPrice()+",DISCOUNT: "+p1.getDiscount()+p1.getRating().getStarts());
//        System.out.println(p2.getId()+p2.getName()+p2.getPrice()+",DISCOUNT: "+p2.getDiscount()+p2.getRating().getStarts());
//        System.out.println(p3.getId()+p3.getName()+p3.getPrice()+",DISCOUNT: "+p3.getDiscount()+p3.getRating().getStarts());
//        System.out.println(p4.getId()+p4.getName()+p4.getPrice()+",DISCOUNT: "+p4.getDiscount()+p4.getRating().getStarts());
//        System.out.println(p5.getId()+p5.getName()+p5.getPrice()+",DISCOUNT: "+p5.getDiscount()+p5.getRating().getStarts());
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        System.out.println(p5);
//        System.out.println(p6.equals(p7));
//        System.out.println(p8);
//        System.out.println(p9);
    }

}