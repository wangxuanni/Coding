package leetcode.orther;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-26 17:33
 **/

public class LRUCache {
    LinkedList<Integer> linkedList = new LinkedList<>();
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
//2,1],[1,1],[2,3],[4,1],[1],[2]]
        cache.put(2, 1);
        cache.put(1, 1);    // 该操作会使得密钥 2 作废
        cache.put(2, 3);    // 该操作会使得密钥 2 作废
        cache.put(4, 1);    // 该操作会使得密钥 2 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(2);       // 返回  4

    }

    /**
     * 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     *
     * @param key
     */
    public int get(int key) {
        if (hashMap.containsKey(key)) {
            moveToFirst(key);
            System.out.println(key + "," + hashMap.get(key));
            return -1;

        } else {
            System.out.println(-1);
            return -1;
        }
    }

    /**
     * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；
     * 如果密钥不存在，则插入该组「密钥/数据值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
            if (!hashMap.containsKey(key)) {

                if (hashMap.size() >= capacity) {
                    Integer removeKey = linkedList.removeLast();
                    hashMap.remove(removeKey);
                }
                hashMap.put(key, value);
                linkedList.addFirst(key);
            } else {
                hashMap.put(key, value);
                moveToFirst(key);
            }


    }

    private void moveToFirst(Integer key) {
        linkedList.remove(linkedList.indexOf(key));
        linkedList.addFirst(key);
    }
}
