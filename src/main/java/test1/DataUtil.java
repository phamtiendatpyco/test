package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;

public class DataUtil {

  private static final String EQUAL_SEPARATOR = "=";
  private static final String LINE_SEPARATOR = "\n";
  private static final String SEMI_COLON_SEPARATOR = ";";
  private static final int KEY_INDEX = 0;
  private static final int VALUE_INDEX = 1;

  private DataUtil() {
    throw new UnsupportedOperationException("Constructor is not allow for this object");
  }

  public static String storeData(List<Map<String, String>> arrayMap) {
    final StringBuilder textBuilder = new StringBuilder();
    for (Map<String, String> map : arrayMap) {

      final Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
      while (iterator.hasNext()) {
        Entry<String, String> nextElement = iterator.next();
        textBuilder.append(nextElement.getKey()).append(EQUAL_SEPARATOR).append(nextElement.getValue());
        textBuilder.append(iterator.hasNext() ? SEMI_COLON_SEPARATOR : LINE_SEPARATOR);
      }

    }
    return textBuilder.toString();
  }

  public static List<Map<String, String>> loadData(final String data) {
    List<Map<String, String>> arrayMap = new ArrayList<>();
    final String[] mapText = StringUtils.split(data, LINE_SEPARATOR);

    for (String text : mapText) {
      final String[] keyValueTexts = StringUtils.split(text, SEMI_COLON_SEPARATOR);
      final Map<String, String> map = new HashMap<>();

      for (String keyValueText : keyValueTexts) {
        final String[] keyValueArray = StringUtils.split(keyValueText, EQUAL_SEPARATOR);
        map.put(keyValueArray[KEY_INDEX], keyValueArray[VALUE_INDEX]);
      }

      arrayMap.add(map);
    }
    return arrayMap;
  }
}
