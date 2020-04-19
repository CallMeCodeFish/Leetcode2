package contest.Apr18;

import java.util.*;

/**
 * @author Heng Yu
 * @date 4/18/20 10:47 PM
 */


public class DisplayTableOfFoodOrders {
    public static void main(String[] args) {
        DisplayTableOfFoodOrders solution = new DisplayTableOfFoodOrders();
        String[] s1 = {"David","3","Ceviche"};
        String[] s2 = {"Corina","10","Beef Burrito"};
        String[] s3 = {"David","3","Fried Chicken"};
        List<List<String>> orders = new ArrayList<>();
        orders.add(Arrays.asList(s1));
        orders.add(Arrays.asList(s2));
        orders.add(Arrays.asList(s3));
        List<List<String>> result = solution.displayTable(orders);
        System.out.println(result);
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> tables = new TreeSet<>();
        TreeMap<String, Map<String, Integer>> items = new TreeMap<>();

        for (List<String> order : orders) {
            String num = order.get(1);
            String item = order.get(2);
            tables.add(num);
            if (!items.containsKey(item)) {
                items.put(item, new HashMap<>());
            }
            Map<String, Integer> map = items.get(item);
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.replace(num, map.get(num) + 1);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        firstRow.addAll(items.keySet());
        res.add(firstRow);
        List<List<String>> temp = new ArrayList<>();
        for (String table : tables) {
            List<String> row = new ArrayList<>();
            row.add(table);
            for (String item : items.keySet()) {
                Map<String, Integer> map = items.get(item);
                if (map.containsKey(table)) {
                    row.add(String.valueOf(map.get(table)));
                } else {
                    row.add("0");
                }
            }
            temp.add(row);
        }
        temp.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int num1 = Integer.parseInt(o1.get(0));
                int num2 = Integer.parseInt(o2.get(0));
                return num1 - num2;
            }
        });
        res.addAll(temp);
        return res;
    }
}
