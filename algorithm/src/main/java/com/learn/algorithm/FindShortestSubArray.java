package com.learn.algorithm;

import java.util.*;

public class FindShortestSubArray {
    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findShortestSubArray2(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] mapSize = new int[max + 1];
        int[] mapMin = new int[max + 1];
        int[] mapMax = new int[max + 1];
        int maxSize = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (mapSize[num] == 0) {
                mapMin[num] = i;
                mapMax[num] = i;
            } else {
                mapMax[num] = i;
            }
            maxSize = Math.max(maxSize, ++mapSize[num]);
        }
        int ans = Integer.MAX_VALUE;
        for (int num = 0; num <= max; num++) {
            if (maxSize == mapSize[num]) {
                ans = Math.min(ans, mapMax[num] - mapMin[num] + 1);
            }
        }
        return ans;
    }

    public static int findShortestSubArray2(int[] nums) {
        int size = nums.length;
        if(size == 1){
            return 1;
        }
        HashMap<Integer, Integer> counter = new HashMap<>(size);
        HashMap<Integer, Integer> fri = new HashMap<>(size);
        HashMap<Integer, Integer> end = new HashMap<>(size);
        for (int i = 0; i < nums.length; i++) {
            if(counter.containsKey(nums[i])){
                int v = counter.get(nums[i]);
                counter.put(nums[i],++v);
                end.put(nums[i],i);
            }else{
                counter.put(nums[i],1);
                fri.put(nums[i],i);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList(counter.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));
        int maxSize = list.get(0).getValue();
        int result = nums.length;
        if(end.keySet().size() == 0){
            return 1;
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getValue() == maxSize && result > (end.get(list.get(i).getKey()) - fri.get(list.get(i).getKey()) + 1)){
               result = end.get(list.get(i).getKey()) - fri.get(list.get(i).getKey()) + 1;
            }
        }

        return result;
    }
}
