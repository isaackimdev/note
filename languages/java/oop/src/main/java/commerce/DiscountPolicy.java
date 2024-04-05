package commerce;

import java.util.List;

public interface DiscountPolicy {
    void discount(List<Product> products);
}
