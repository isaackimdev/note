package commerce;

import java.util.List;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;
    @Override
    public void discount(List<Product> products) {
        for(Product product : products) {
            product.setPrice(product.getPrice() - discountFixAmount);
        }
    }
}
