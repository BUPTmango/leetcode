package hard_level;

import java.util.*;

/**
 * 381. O(1) ʱ����롢ɾ���ͻ�ȡ���Ԫ�� - �����ظ�
 * ���һ��֧����ƽ��ʱ�临�Ӷ�O(1)�£�ִ�����²��������ݽṹ��
 *
 * ע��: ��������ظ�Ԫ�ء�
 *
 * insert(val)���򼯺��в���Ԫ�� val��
 * remove(val)���� val ����ʱ���Ӽ������Ƴ�һ�� val��
 * getRandom�������м����������ȡһ��Ԫ�ء�ÿ��Ԫ�ر����صĸ���Ӧ�������ڼ����е�������������ء�
 * ʾ��:
 *
 * // ��ʼ��һ���յļ��ϡ�
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // �򼯺��в��� 1 ������ true ��ʾ���ϲ����� 1 ��
 * collection.insert(1);
 *
 * // �򼯺��в�����һ�� 1 ������ false ��ʾ���ϰ��� 1 ���������ڰ��� [1,1] ��
 * collection.insert(1);
 *
 * // �򼯺��в��� 2 ������ true ���������ڰ��� [1,1,2] ��
 * collection.insert(2);
 *
 * // getRandom Ӧ���� 2/3 �ĸ��ʷ��� 1 ��1/3 �ĸ��ʷ��� 2 ��
 * collection.getRandom();
 *
 * // �Ӽ�����ɾ�� 1 ������ true ���������ڰ��� [1,2] ��
 * collection.remove(1);
 *
 * // getRandom Ӧ����ͬ���ʷ��� 1 �� 2 ��
 * collection.getRandom();
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/31 8:04 ����
 */
public class RandomizedCollection {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
