package alogrithm.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author created by wuwt
 * @date 2020/4/8 10:46 下午
 * 一个是维护正常key value pair的HashMap<Integer, Integer> keyVals.
 * 第二个是维护每个key的使用次数.
 * 第三个是维护每个count下对应的key set.
 **/
public class LFUCache_60 {
    HashMap<Integer, Integer> keyVals;
    HashMap<Integer, Integer> keyCounts;
    HashMap<Integer, LinkedHashSet<Integer>> countKeySets;
    int capacity;
    int min;

    public LFUCache_60(int capacity) {
        this.capacity = capacity;
        this.min = -1;
        keyVals = new HashMap<Integer, Integer>();
        keyCounts = new HashMap<Integer, Integer>();
        countKeySets = new HashMap<Integer, LinkedHashSet<Integer>>();
        countKeySets.put(1, new LinkedHashSet<Integer>());
    }

    public int get(int key) {
        // get时, key的count要加一, 对应调整keyCounts 和 countKeySets.
        // 若这个key的count恰巧是最少使用次数的最后一个值，那么最少使用次数min++.
        if(!keyVals.containsKey(key)){
            return -1;
        }
        int count = keyCounts.get(key);
        keyCounts.put(key, count+1);
        countKeySets.get(count).remove(key);
        if(count == min && countKeySets.get(count).size() == 0){
            min++;
        }
        if(!countKeySets.containsKey(count+1)){
            countKeySets.put(count+1, new LinkedHashSet<Integer>());
        }
        countKeySets.get(count+1).add(key);
        return keyVals.get(key);
    }

    public void put(int key, int value) {
        //* 当put第一个元素时, min=1, 对应更新keyVals, keyCounts 和 countKeySets.
        if(capacity <= 0){
            return;
        }

        if(keyVals.containsKey(key)){
            keyVals.put(key, value);
            get(key);
            return;
        }
        if(keyVals.size() >= capacity){
            //在达到capacity后在加新key时利用min来找到least frequently used element,
            // 并对应调整keyVals, keyCounts 和 countKeySets.
            int leastFreq = countKeySets.get(min).iterator().next();
            keyVals.remove(leastFreq);
            keyCounts.remove(leastFreq);
            countKeySets.get(min).remove(leastFreq);
        }
        keyVals.put(key, value);
        keyCounts.put(key, 1);
        countKeySets.get(1).add(key);
        min = 1;
    }
}