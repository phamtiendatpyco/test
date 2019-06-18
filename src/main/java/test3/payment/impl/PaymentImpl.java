package test3.payment.impl;

import java.math.BigDecimal;
import test3.model.Bill;
import test3.payment.Payment;

public class PaymentImpl implements Payment {

  @Override
  public BigDecimal calculatePrice(final Bill bill) {
    // Calculate percentage discount price
    final PercentageDiscountCalculator percentageDiscountCalculator = new PercentageDiscountCalculator();
    final BigDecimal percentageDiscountPrice = percentageDiscountCalculator.calculateDiscount(bill);

    // Calculate amount discount price
    final AmountDiscountCalculator amountDiscountCalculator = new AmountDiscountCalculator();
    return amountDiscountCalculator.calculateDiscount(percentageDiscountPrice);
  }

}
