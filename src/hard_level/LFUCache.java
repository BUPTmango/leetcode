package hard_level;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LRU LFU 缓存
 * 460. LFU 缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量capacity 初始化对象
 * int get(int key)- 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value)- 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * 进阶：
 *
 * 你是否可以在O(1)时间复杂度内执行两项操作？
 * 
 * 示例：
 *
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * 解释：
 * LFUCache lFUCache = new LFUCache(2);
 * lFUCache.put(1, 1);
 * lFUCache.put(2, 2);
 * lFUCache.get(1);      // 返回 1
 * lFUCache.put(3, 3);   // 去除键 2
 * lFUCache.get(2);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 * lFUCache.put(4, 4);   // 去除键 1
 * lFUCache.get(1);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 * lFUCache.get(4);      // 返回 4
 *
 * 提示：
 *
 * 0 <=capacity, key, value <= 104
 * 最多调用 105 次 get 和 put 方法
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/10 8:59 上午
 */
public class LFUCache {
    /** key到val的映射 */
    private Map<Integer, Integer> keyToVal;
    /** key到freq的映射 */
    private Map<Integer, Integer> keyToFreq;
    /** freq到key列表的映射 */
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    /** 记录最小的频次 */
    private int minFreq;
    /** 记录最大容量 */
    private int cap;

    public LFUCache(int capacity) {
        cap = capacity;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 增加key对应的freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        // 如果key已经存在 修改对应的val即可
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
        } else {
            // 如果容量已经满了 淘汰一个key
            if (cap <= keyToVal.size()) {
                removeMinFreqKey();
            }
            // 插入KV表
            keyToVal.put(key, value);
            // 插入KF表
            keyToFreq.put(key, 1);
            // 插入FK表
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            // 插入新key后 最小的freq肯定是1
            minFreq = 1;
        }
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        int deletedKey = keyList.iterator().next();
        // 更新FK表
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(minFreq);
            // 这里不需要再更新minFreq 因为remove之后put会将minFreq更新为1
        }
        // 更新KV表
        keyToVal.remove(deletedKey);
        // 更新KF表
        keyToFreq.remove(deletedKey);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        // 更新KF表
        keyToFreq.put(key,freq + 1);
        // 更新FK表
        // 先将key从freq的列表中删除
        freqToKeys.get(freq).remove(key);
        // 再将key加入到freq+1的列表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // 如果freq对应的列表空了 移除了这个freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个freq恰好是minFreq 更新minFreq
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }
}
