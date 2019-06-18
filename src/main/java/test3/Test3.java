package test3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import test3.enums.ProductType;
import test3.model.Bill;
import test3.model.Product;
import test3.model.User;
import test3.payment.Payment;
import test3.payment.impl.PaymentImpl;

public class Test3 {

  public static void main(String[] args) {
    Bill bill = new Bill();
    bill.setUser(new User("test", LocalDate.now(), true, false));
    List<Product> products = new ArrayList<>();
    products.add(new Product(BigDecimal.valueOf(100), ProductType.OTHERS));
    products.add(new Product(BigDecimal.valueOf(300), ProductType.GROCERY));
    bill.setProducts(products);

    Payment payment = new PaymentImpl();
    BigDecimal totalPrice = payment.calculatePrice(bill);

    System.out.println(totalPrice);
  }
}
