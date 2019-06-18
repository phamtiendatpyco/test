package test3.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

  public static final int LOYAL_PERIOD_YEAR = 2;

  private DateUtil() {
    throw new UnsupportedOperationException("Constructor is not allow for this object");
  }

  public static boolean isOverTwoYear(final LocalDate createdDate) {
    return Period.between(createdDate, LocalDate.now()).getYears() >= LOYAL_PERIOD_YEAR;
  }
}
