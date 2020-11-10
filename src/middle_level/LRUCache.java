package middle_level;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU LFU 缓存
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个? LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * ?
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在?O(1) 时间复杂度内完成这两种操作？
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/11 10:15 上午
 */
public class LRUCache {
//    /**
//     * 自定义的双链表节点类
//     */
//    class Node {
//        public int key, val;
//        public Node prev, next;
//        public Node (int k, int v) {
//            key = k;
//            val = v;
//        }
//    }
//
//    /**
//     * 双链表数据结构
//     */
//    class DoubleList {
//        // 头尾虚节点
//        private Node head, tail;
//        // 链表元素数
//        private int size;
//
//        public DoubleList() {
//            // 初始化双向链表的数据
//            head = new Node(0, 0);
//            tail = new Node(0, 0);
//            head.next = tail;
//            tail.prev = head;
//            size = 0;
//        }
//
//        // 在链表尾部添加节点x
//        public void addLast(Node x) {
//            x.prev = tail.prev;
//            x.next = tail;
//            tail.prev.next = x;
//            tail.prev = x;
//            size++;
//        }
//
//        // 删除链表中的x节点
//        public void remove(Node x) {
//            x.prev.next = x.next;
//            x.next.prev = x.prev;
//            size--;
//        }
//
//        // 删除链表中的第一个节点并返回
//        public Node removeFirst() {
//            if (head.next == tail) {
//                return null;
//            }
//            Node first = head.next;
//            remove(first);
//            return first;
//        }
//
//        // 返回链表长度
//        public int size() {
//            return size;
//        }
//    }
//
//
//    private Map<Integer, Node> map;
//    private DoubleList cache;
//    private int cap;
//    public LRUCache(int capacity) {
//        cap = capacity;
//        map = new HashMap<>();
//        cache = new DoubleList();
//    }
//
//    /**
//     * 将某个key提升为最近使用的
//     * @param key
//     */
//    private void makeRecently(int key) {
//        Node x = map.get(key);
//        // 先删除节点
//        cache.remove(x);
//        // 重新插到队尾
//        cache.addLast(x);
//    }
//
//    /**
//     * 添加最近使用的元素
//     * @param key
//     * @param val
//     */
//    private void addRecently(int key, int val) {
//        Node x = new Node(key, val);
//        // 链表尾部就是最近使用的元素
//        cache.addLast(x);
//        // 在map中添加key的映射
//        map.put(key, x);
//    }
//
//    /**
//     * 删除某一个key
//     * @param key
//     */
//    private void deleteKey(int key) {
//        Node x = map.get(key);
//        // 从链表中删除
//        cache.remove(x);
//        // 从map中删除
//        map.remove(key);
//    }
//
//    /**
//     * 删除最久未使用的元素
//     */
//    private void removeLeastRecently() {
//        // 链表的第一个元素就是最久未使用的
//        Node deletedNode = cache.removeFirst();
//        // 从map中删除它的key
//        map.remove(deletedNode.key);
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        // 提升为最近使用的
//        makeRecently(key);
//        return map.get(key).val;
//    }
//
//    public void put(int key, int value) {
//        // 已经存在key 修改key为对应的val 并提升为最近使用
//        if (map.containsKey(key)) {
//            // 删除旧的数据
//            deleteKey(key);
//            // 新插入的数据为最近使用的数据
//            addRecently(key, value);
//        } else {
//            // 如果满了
//            if (cache.size() == cap) {
//                // 删除最久未使用的元素
//                removeLeastRecently();
//            }
//            // 添加为最近使用的元素
//            addRecently(key, value);
//        }
//    }

    // 注释掉的表示自己实现的链表
    // 下面是使用jdk中的LinkedHashMap的实现

    private int cap;
    private LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        cap = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
        } else {
            if (cap == cache.size()) {
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, value);
        }
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除并重新放到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}
