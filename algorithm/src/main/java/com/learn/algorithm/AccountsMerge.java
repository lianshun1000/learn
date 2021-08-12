package com.learn.algorithm;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        list1.add("John");
        list1.add("john0@mail.com");
        list1.add("john1@mail.com");


        List<String> list2 = new ArrayList();
        list2.add("John");
        list2.add("john3@mail.com");
        list2.add("john4@mail.com");


        List<String> list3 = new ArrayList();
        list3.add("John");
        list3.add("john4@mail.com");
        list3.add("john5@mail.com");


        List<String> list4 = new ArrayList();
        list4.add("John");
        list4.add("john2@mail.com");
        list4.add("john3@mail.com");

        List<String> list5 = new ArrayList();
        list5.add("John");
        list5.add("john1@mail.com");
        list5.add("john2@mail.com");

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);
        accounts.add(list5);

        List<List<String>> result = accountsMerge(accounts);
        System.out.println(result);

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Map> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            Map<Integer, String> valueMap = new HashMap();
            String value = accounts.get(i).get(0);
            valueMap.put(i, value);
            boolean flag = true;
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (map.containsKey(accounts.get(i).get(j))) {
                    if (flag) {
                        valueMap = map.get(accounts.get(i).get(j));
                    }
                    flag = false;
                    List keyList = getKey(map, map.get(accounts.get(i).get(j)));
                    Map<Integer, String> value2Map = new HashMap();
                    value2Map.put(i, value);
                    List keyList2 = getKey(map, value2Map);
                    keyList.addAll(keyList2);
                    for (int k = 0; k < keyList.size(); k++) {
                        map.put(keyList.get(k).toString(), valueMap);
                    }
                }
                map.put(accounts.get(i).get(j), valueMap);
            }
        }

        List<List<String>> resultList = new ArrayList<>();
        Set<Map> set = new HashSet<>(map.values());
        List<Map> valueList = new ArrayList<>(set);
        for (int i = 0; i < valueList.size(); i++) {
            List<String> addList = new ArrayList<>();
            addList.add(valueList.get(i).values().iterator().next().toString());
            for (int j = 0; j < getKey(map, valueList.get(i)).size(); j++) {
                addList.add(getKey(map, valueList.get(i)).get(j));
            }
            Collections.sort(addList);
            resultList.add(addList);
        }

        return resultList;
    }

    public static List<String> getKey(Map map, Object value) {
        List<String> keyList = new ArrayList<>();
        for (Object key : map.keySet()) {
            if (map.get(key).equals(value)) {
                keyList.add(key.toString());
            }
        }
        return keyList;
    }

    private static String getFirstOrNull(Map<Integer, String> map) {
        String obj = null;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }


}
