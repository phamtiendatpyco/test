package test1;

import java.util.List;
import java.util.Map;

public class Test1 {

  public static void main(String[] args) {
    List<Map<String, String>> maps = DataUtil.loadData("key1=value1;key2=value2\nkeyA=valueA\n");
    System.out.println("*******************************************************");
    System.out.println("Load Data:");
    System.out.println(maps);
    System.out.println("*******************************************************");
    System.out.println("Store Data:");
    String text = DataUtil.storeData(maps);
    System.out.println(text);
    System.out.println("*******************************************************");
  }
}
