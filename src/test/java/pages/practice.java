package pages;

import io.cucumber.java.it.Ma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class practice {
    public static void main(String[] args) {
        //convert map to list
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "apple");
        map.put(2, "orange");
        map.put(3, "banana");

        List<String> list=new ArrayList<>();

        list.add("United States");
        list.add("France");
        list.add("Germany");

        List<Map<String, String>> listMap=new ArrayList<>();
        System.out.println(map.get(2));
    }
}
