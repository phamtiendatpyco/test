package test3.payment.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import test3.enums.ProductType;
import test3.model.Bill;
import test3.model.Product;
import test3.model.User;
import test3.payment.Payment;

public class PaymentImplTest {

  @Test
  public void testCalculatePriceSuccessfully() {
    // Given
    PercentageDiscountCalculator percentageDiscountCalculator = new PercentageDiscountCalculator();
    Bill bill = new Bill();
    bill.setUser(new User("test", LocalDate.now(), true, false));
    List<Product> products = new ArrayList<>();
    products.add(new Product(BigDecimal.valueOf(100), ProductType.OTHERS));
    products.add(new Product(BigDecimal.valueOf(300), ProductType.GROCERY));
    bill.setProducts(products);

    // When
    Payment payment = new PaymentImpl();
    BigDecimal totalPrice = payment.calculatePrice(bill);

    // Then
    Assert.assertEquals(BigDecimal.valueOf(355.0), totalPrice);
  }
}
