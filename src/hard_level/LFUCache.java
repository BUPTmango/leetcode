package hard_level;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LRU LFU ����
 * 460. LFU ����
 * ����Ϊ �����ʹ�ã�LFU�������㷨��Ʋ�ʵ�����ݽṹ��
 *
 * ʵ�� LFUCache �ࣺ
 *
 * LFUCache(int capacity) - �����ݽṹ������capacity ��ʼ������
 * int get(int key)- ����������ڻ����У����ȡ����ֵ�����򷵻� -1��
 * void put(int key, int value)- ������Ѵ��ڣ�������ֵ������������ڣ�������ֵ�ԡ�������ﵽ������ʱ����Ӧ���ڲ�������֮ǰ��ʹ�����ʹ�õ�����Ч���ڴ������У�������ƽ�֣���������������������ͬʹ��Ƶ�ʣ�ʱ��Ӧ��ȥ�� ���δʹ�� �ļ���
 * ע�⡸���ʹ�ô����������Բ����������������� get �� put �����Ĵ���֮�͡�ʹ�ô������ڶ�Ӧ��Ƴ�����Ϊ 0 ��
 *
 * ���ף�
 *
 * ���Ƿ������O(1)ʱ�临�Ӷ���ִ�����������
 * 
 * ʾ����
 *
 * ���룺
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * �����
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * ���ͣ�
 * LFUCache lFUCache = new LFUCache(2);
 * lFUCache.put(1, 1);
 * lFUCache.put(2, 2);
 * lFUCache.get(1);      // ���� 1
 * lFUCache.put(3, 3);   // ȥ���� 2
 * lFUCache.get(2);      // ���� -1��δ�ҵ���
 * lFUCache.get(3);      // ���� 3
 * lFUCache.put(4, 4);   // ȥ���� 1
 * lFUCache.get(1);      // ���� -1��δ�ҵ���
 * lFUCache.get(3);      // ���� 3
 * lFUCache.get(4);      // ���� 4
 *
 * ��ʾ��
 *
 * 0 <=capacity, key, value <= 104
 * ������ 105 �� get �� put ����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/10 8:59 ����
 */
public class LFUCache {
    /** key��val��ӳ�� */
    private Map<Integer, Integer> keyToVal;
    /** key��freq��ӳ�� */
    private Map<Integer, Integer> keyToFreq;
    /** freq��key�б��ӳ�� */
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    /** ��¼��С��Ƶ�� */
    private int minFreq;
    /** ��¼������� */
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
        // ����key��Ӧ��freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        // ���key�Ѿ����� �޸Ķ�Ӧ��val����
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
        } else {
            // ��������Ѿ����� ��̭һ��key
            if (cap <= keyToVal.size()) {
                removeMinFreqKey();
            }
            // ����KV��
            keyToVal.put(key, value);
            // ����KF��
            keyToFreq.put(key, 1);
            // ����FK��
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            // ������key�� ��С��freq�϶���1
            minFreq = 1;
        }
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        int deletedKey = keyList.iterator().next();
        // ����FK��
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(minFreq);
            // ���ﲻ��Ҫ�ٸ���minFreq ��Ϊremove֮��put�ὫminFreq����Ϊ1
        }
        // ����KV��
        keyToVal.remove(deletedKey);
        // ����KF��
        keyToFreq.remove(deletedKey);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        // ����KF��
        keyToFreq.put(key,freq + 1);
        // ����FK��
        // �Ƚ�key��freq���б���ɾ��
        freqToKeys.get(freq).remove(key);
        // �ٽ�key���뵽freq+1���б���
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // ���freq��Ӧ���б���� �Ƴ������freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // ������freqǡ����minFreq ����minFreq
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }
}
