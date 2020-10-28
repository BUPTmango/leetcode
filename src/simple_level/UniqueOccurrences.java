package simple_level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. ��һ�޶��ĳ��ִ���
 * ����һ����������arr�������æͳ��������ÿ�����ĳ��ִ�����
 *
 * ���ÿ�����ĳ��ִ������Ƕ�һ�޶��ģ��ͷ���true�����򷵻� false��
 *
 * ʾ�� 1��
 *
 * ���룺arr = [1,2,2,1,1,3]
 * �����true
 * ���ͣ��ڸ������У�1 ������ 3 �Σ�2 ������ 2 �Σ�3 ֻ������ 1 �Ρ�û���������ĳ��ִ�����ͬ��
 * ʾ�� 2��
 *
 * ���룺arr = [1,2]
 * �����false
 * ʾ�� 3��
 *
 * ���룺arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * �����true
 * 
 *
 * ��ʾ��
 *
 * 1 <= arr.length<= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/28 9:02 ����
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // ͳ�ƴ���
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        // ��������set��
        for (int key : map.keySet()) {
            Integer times = map.get(key);
            if (set.contains(times)) {
                return false;
            } else {
                set.add(times);
            }
        }
        return true;
    }
}
