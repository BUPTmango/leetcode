package middle_level;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU LFU ����
 * 146. LRU�������
 * �����������յ����ݽṹ����ƺ�ʵ��һ��? LRU (�������ʹ��) ������ơ���Ӧ��֧�����²����� ��ȡ���� get �� д������ put ��
 * <p>
 * ��ȡ���� get(key) - ����ؼ��� (key) �����ڻ����У����ȡ�ؼ��ֵ�ֵ�����������������򷵻� -1��
 * д������ put(key, value) - ����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���/ֵ���������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
 * <p>
 * ?
 * <p>
 * ����:
 * <p>
 * ���Ƿ������?O(1) ʱ�临�Ӷ�����������ֲ�����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/11 10:15 ����
 */
public class LRUCache {
//    /**
//     * �Զ����˫����ڵ���
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
//     * ˫�������ݽṹ
//     */
//    class DoubleList {
//        // ͷβ��ڵ�
//        private Node head, tail;
//        // ����Ԫ����
//        private int size;
//
//        public DoubleList() {
//            // ��ʼ��˫�����������
//            head = new Node(0, 0);
//            tail = new Node(0, 0);
//            head.next = tail;
//            tail.prev = head;
//            size = 0;
//        }
//
//        // ������β����ӽڵ�x
//        public void addLast(Node x) {
//            x.prev = tail.prev;
//            x.next = tail;
//            tail.prev.next = x;
//            tail.prev = x;
//            size++;
//        }
//
//        // ɾ�������е�x�ڵ�
//        public void remove(Node x) {
//            x.prev.next = x.next;
//            x.next.prev = x.prev;
//            size--;
//        }
//
//        // ɾ�������еĵ�һ���ڵ㲢����
//        public Node removeFirst() {
//            if (head.next == tail) {
//                return null;
//            }
//            Node first = head.next;
//            remove(first);
//            return first;
//        }
//
//        // ����������
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
//     * ��ĳ��key����Ϊ���ʹ�õ�
//     * @param key
//     */
//    private void makeRecently(int key) {
//        Node x = map.get(key);
//        // ��ɾ���ڵ�
//        cache.remove(x);
//        // ���²嵽��β
//        cache.addLast(x);
//    }
//
//    /**
//     * ������ʹ�õ�Ԫ��
//     * @param key
//     * @param val
//     */
//    private void addRecently(int key, int val) {
//        Node x = new Node(key, val);
//        // ����β���������ʹ�õ�Ԫ��
//        cache.addLast(x);
//        // ��map�����key��ӳ��
//        map.put(key, x);
//    }
//
//    /**
//     * ɾ��ĳһ��key
//     * @param key
//     */
//    private void deleteKey(int key) {
//        Node x = map.get(key);
//        // ��������ɾ��
//        cache.remove(x);
//        // ��map��ɾ��
//        map.remove(key);
//    }
//
//    /**
//     * ɾ�����δʹ�õ�Ԫ��
//     */
//    private void removeLeastRecently() {
//        // ����ĵ�һ��Ԫ�ؾ������δʹ�õ�
//        Node deletedNode = cache.removeFirst();
//        // ��map��ɾ������key
//        map.remove(deletedNode.key);
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        // ����Ϊ���ʹ�õ�
//        makeRecently(key);
//        return map.get(key).val;
//    }
//
//    public void put(int key, int value) {
//        // �Ѿ�����key �޸�keyΪ��Ӧ��val ������Ϊ���ʹ��
//        if (map.containsKey(key)) {
//            // ɾ���ɵ�����
//            deleteKey(key);
//            // �²��������Ϊ���ʹ�õ�����
//            addRecently(key, value);
//        } else {
//            // �������
//            if (cache.size() == cap) {
//                // ɾ�����δʹ�õ�Ԫ��
//                removeLeastRecently();
//            }
//            // ���Ϊ���ʹ�õ�Ԫ��
//            addRecently(key, value);
//        }
//    }

    // ע�͵��ı�ʾ�Լ�ʵ�ֵ�����
    // ������ʹ��jdk�е�LinkedHashMap��ʵ��

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
        // ɾ�������·ŵ���β
        cache.remove(key);
        cache.put(key, val);
    }
}
