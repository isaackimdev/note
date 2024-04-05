package commerce;

import java.util.ArrayList;
import java.util.List;

public class OrderClient {
    private List<Order> orders;
    public OrderClient() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("주문 대기, 주문 번호: " + order.getOrderNumber());
    }

    public void processOrder(String orderNumber) {
        Order order = findOrder(orderNumber);
        if (order != null) {
            for(Product product : order.getProducts()) {
                product.decreaseStock(1);
            }
            order.setStatus("Proceed");
            System.out.println("주문 완료. 주문 번호 : " + orderNumber);
        } else {
            System.out.println("Invalid order number");
        }
    }
    private Order findOrder(String orderNumber) {
        for(Order order : orders) {
            if(order.getOrderNumber().equals(orderNumber)) {
                return order;
            }
        }
        return null;
    }

    public void applyDiscountWithAddress(Customer customer, DiscountPolicy discountPolicy, String address) {
        if(customer.getAddress().equals(address)) {
            for (Order order : orders) {
                if (order.getCustomer().equals(customer)) {
                    List<Product> copiedProducts = new ArrayList<>();
                    for (Product product : order.getProducts()) {
                        copiedProducts.add(product.clone());
                    }
                    discountPolicy.discount(copiedProducts);
                    order.setProducts(copiedProducts);
                }
            }
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}
