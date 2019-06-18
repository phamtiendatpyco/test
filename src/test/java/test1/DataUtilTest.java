package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class DataUtilTest {

  @Test
  public void testStoreData() {
    // Given
    final List<Map<String, String>> arrayMap = new ArrayList<>();
    Map<String, String> map1 = new HashMap<>();
    map1.put("key1", "value1");
    map1.put("key2", "value2");
    arrayMap.add(map1);

    Map<String, String> map2 = new HashMap<>();
    map2.put("keyA", "valueA");
    arrayMap.add(map2);

    // When
    String text = DataUtil.storeData(arrayMap);

    // Then
    Assert.assertEquals("key1=value1;key2=value2\nkeyA=valueA\n", text);
  }

  @Test
  public void testLoadData() {
    // Given
    final List<Map<String, String>> arrayMap = new ArrayList<>();
    Map<String, String> map1 = new HashMap<>();
    map1.put("key1", "value1");
    map1.put("key2", "value2");
    arrayMap.add(map1);

    Map<String, String> map2 = new HashMap<>();
    map2.put("keyA", "valueA");
    arrayMap.add(map2);

    // When
    List<Map<String, String>> maps = DataUtil.loadData("key1=value1;key2=value2\nkeyA=valueA\n");

    // Then
    Assert.assertEquals(arrayMap, maps);
  }
}
