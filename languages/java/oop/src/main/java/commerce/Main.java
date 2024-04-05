package commerce;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("치킨",10000,10);
        Product product2 = new Product("만두",20000,5);
        Product product3 = new Product("곱창",30000,8);

        Customer customer1 = new Customer("김자바", "서울", "010-1234-5678");
        Customer customer2 = new Customer("김스프", "제주도", "010-9876-5432");

        List<Product> order1Products = new ArrayList<>();
        order1Products.add(product1);
        order1Products.add(product2);
        Order order1 = new Order("00001", customer1, order1Products);
        List<Product> order2Products = new ArrayList<>();
        order2Products.add(product2);
        order2Products.add(product3);
        Order order2 = new Order("00002", customer2, order2Products);

        OrderClient orderClient = new OrderClient();
        orderClient.placeOrder(order1);
        orderClient.placeOrder(order2);

        System.out.println("==========");

        DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
        DiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();
        orderClient.applyDiscountWithAddress(customer1, rateDiscountPolicy, "제주도");
        orderClient.applyDiscountWithAddress(customer2, fixDiscountPolicy, "제주도");

        for (Order order : orderClient.getOrders()) {
            System.out.println("Order Number : " + order.getOrderNumber());
            System.out.println("Customer Name : " + order.getCustomer().getName());
            System.out.println("Order Status : " + order.getStatus());
            System.out.println("Product List : ");
            for(Product product : order.getProducts()) {
                System.out.println("Product Name : " + product.getName() + ", Price : " + product.getPrice() + "원");
            }
            System.out.println("----------");
        }

        for(Order order : orderClient.getOrders()) {
            orderClient.processOrder(order.getOrderNumber());;
        }

        for (Order order : orderClient.getOrders()) {
            System.out.println("Order Number : " + order.getOrderNumber());
            System.out.println("Customer Name : " + order.getCustomer().getName());
            System.out.println("Order Status : " + order.getStatus());
            System.out.println("----------");
        }

        System.out.println("==========");

    }
}
