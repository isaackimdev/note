package commerce;

import java.util.List;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;
    @Override
    public void discount(List<Product> products) {
        for(Product product : products) {
            product.setPrice(product.getPrice() - (product.getPrice() * discountPercent / 100));
        }
    }
}
