package test3.util;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

  @Test
  public void testIsOverTwoYear() {
    // When
    boolean overTwoYear = DateUtil.isOverTwoYear(LocalDate.of(2017, 6, 1));

    // Then
    Assert.assertTrue(overTwoYear);
  }
}
