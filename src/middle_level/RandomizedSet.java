package middle_level;

import java.util.*;

/**
 * ���ݽṹ���
 * 380. ����ʱ����롢ɾ���ͻ�ȡ���Ԫ��
 * ���һ��֧����ƽ��ʱ�临�Ӷ� O(1)�£�ִ�����²��������ݽṹ��
 *
 * insert(val)����Ԫ�� val ������ʱ���򼯺��в�����
 * remove(val)��Ԫ�� val ����ʱ���Ӽ������Ƴ����
 * getRandom������������м����е�һ�ÿ��Ԫ��Ӧ������ͬ�ĸ��ʱ����ء�
 * ʾ�� :
 *
 * // ��ʼ��һ���յļ��ϡ�
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // �򼯺��в��� 1 ������ true ��ʾ 1 ���ɹ��ز��롣
 * randomSet.insert(1);
 *
 * // ���� false ����ʾ�����в����� 2 ��
 * randomSet.remove(2);
 *
 * // �򼯺��в��� 2 ������ true ���������ڰ��� [1,2] ��
 * randomSet.insert(2);
 *
 * // getRandom Ӧ������� 1 �� 2 ��
 * randomSet.getRandom();
 *
 * // �Ӽ������Ƴ� 1 ������ true ���������ڰ��� [2] ��
 * randomSet.remove(1);
 *
 * // 2 ���ڼ����У����Է��� false ��
 * randomSet.insert(2);
 *
 * // ���� 2 �Ǽ�����Ψһ�����֣�getRandom ���Ƿ��� 2 ��
 * randomSet.getRandom();
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/2 8:20 ����
 */
public class RandomizedSet {

    private List<Integer> nums;
    private Map<Integer, Integer> valToIndex;
    private Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        // �洢Ԫ�ص�ֵ
        nums = new ArrayList<>();
        // ��¼ÿ��Ԫ�ض�Ӧ��nums�е�����
        valToIndex = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // ����Ѿ����� ����Ҫ����
        if (valToIndex.containsKey(val)) {
            return false;
        }
        // ����map����������numsβ��
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // ��������� ����ɾ��
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        // �ƶ���β�� ��ɾ��
        // �õ�Ҫɾ��Ԫ�ص�����
        int index = valToIndex.get(val);
        // �ҵ����һ��Ԫ��
        int lastNum = nums.get(nums.size() - 1);
        // �������һ��Ԫ�ص�����
        valToIndex.put(lastNum, index);
        // ����ɾ��Ԫ�ص����
        nums.set(index, lastNum);
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
