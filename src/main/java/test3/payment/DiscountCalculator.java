package test3.payment;

import java.math.BigDecimal;

public interface DiscountCalculator<T> {
  BigDecimal calculateDiscount(T object);
}
