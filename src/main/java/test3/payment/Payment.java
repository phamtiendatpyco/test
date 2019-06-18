package test3.payment;

import java.math.BigDecimal;
import test3.model.Bill;

public interface Payment {

  BigDecimal calculatePrice(Bill bill);
}
