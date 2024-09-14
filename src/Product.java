import java.math.BigDecimal;

public class Product implements Promotion {
    private String name;
    private BigDecimal price;
    private Double weight;

    public Product(String name, BigDecimal price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public BigDecimal getDiscountAmount() {
        switch (name) {
            case "grocery":
                return new BigDecimal("2000");
            case "beauty":
                return new BigDecimal("10000");
            default:
                return BigDecimal.ZERO;  // 할인 금액이 없는 경우
        }
    }
}
