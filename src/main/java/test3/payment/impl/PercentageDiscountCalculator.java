package test3.payment.impl;

import static test3.util.DiscountUtil.getPercentageDiscountPrice;

import java.math.BigDecimal;
import test3.model.Bill;
import test3.payment.DiscountCalculator;

public class PercentageDiscountCalculator implements DiscountCalculator<Bill> {

  @Override
  public BigDecimal calculateDiscount(final Bill bill) {
    return bill.getProducts().stream()
        .map(p -> getPercentageDiscountPrice(bill.getUser(), p))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
