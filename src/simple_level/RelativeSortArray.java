package simple_level;

import java.util.*;

/**
 * 1122. ������������
 * �����������飬arr1 ��arr2��
 * <p>
 * arr2�е�Ԫ�ظ�����ͬ
 * arr2 �е�ÿ��Ԫ�ض�������arr1��
 * �� arr1�е�Ԫ�ؽ�������ʹ arr1 ��������˳���arr2�е����˳����ͬ��δ��arr2�г��ֹ���Ԫ����Ҫ�����������arr1��ĩβ��
 * <p>
 * ʾ����
 * <p>
 * ���룺arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * �����[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * ��ʾ��
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2�е�Ԫ��arr2[i]������ͬ
 * arr2 �е�ÿ��Ԫ��arr2[i]��������arr1��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/14 10:14 ����
 */
public class RelativeSortArray {
    /**
     * �Զ������� ����ʱ�����
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        // �Զ��������ֹʹ�÷��� ��list��������
        for (int num : arr1) {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Collections.sort(list, (x, y) -> {
            // ����arr2��ʱ �Ƚ����������Ⱥ�
            // һ����һ������ʱ ��arr2�е�����ǰ��
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            // ������arr2�е�ʱ�� �Ƚϱ����С
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

    /**
     * �������� �Ƽ�
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray_another(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        // ������¼Ƶ�ε�����
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            // ͳ���꽫Ƶ�μ�Ϊ0
            frequency[x] = 0;
        }
        // ��������arr2��û�г��ֹ�������
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
