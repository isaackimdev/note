package commerce;

import java.util.List;

public class Order {
    private String orderNumber;
    private Customer customer;
    private List<Product> products;
    private String status;

    public Order(String orderNumber, Customer customer, List<Product> products) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.products = products;
        this.status = "Pending";
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
