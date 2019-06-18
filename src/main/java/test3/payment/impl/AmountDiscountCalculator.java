package test3.payment.impl;

import static test3.util.DiscountUtil.isNegativeNumber;

import java.math.BigDecimal;
import test3.payment.DiscountCalculator;

public class AmountDiscountCalculator implements DiscountCalculator<BigDecimal> {

  private static final int AMOUNT_DISCOUNT_CONDITION = 100;
  private static final int AMOUNT_DISCOUNT = 5;

  @Override
  public BigDecimal calculateDiscount(final BigDecimal price) {
    if(isNegativeNumber(price)) {
      throw new IllegalArgumentException("Price is not allowed as a negative number!");
    }
    int discount = price.intValue() / AMOUNT_DISCOUNT_CONDITION;
    return price.subtract(BigDecimal.valueOf(discount * AMOUNT_DISCOUNT));
  }
}
