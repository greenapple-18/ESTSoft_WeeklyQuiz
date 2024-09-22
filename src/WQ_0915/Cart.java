package WQ_0915;

import java.math.BigDecimal;

public class Cart {
    Product[] product;

    Cart(Product[] product) {
        this.product = product;
    }

    public int calculateDeliveryCharge() {
        int deliveryFees;

        BigDecimal totalPrice = new BigDecimal(0);
        int totalWeight = 0;

        for (Product value : product) {
            totalPrice = totalPrice.add(value.getPrice().subtract(value.getDiscountAmount()));
            totalWeight += value.getWeight();
        }

        if (totalWeight < 3) {
            deliveryFees = 1000;
        } else if (totalWeight < 10) {
            deliveryFees = 5000;
        } else {
            deliveryFees = 10000;
        }

        if (totalPrice.compareTo(new BigDecimal("30000")) >= 0 && totalPrice.compareTo(new BigDecimal("100000")) < 0) {
            deliveryFees -= 1000;
        } else if (totalPrice.compareTo(new BigDecimal("100000")) >= 0) {
            deliveryFees = 0;
        }

        return deliveryFees;
    }
}
