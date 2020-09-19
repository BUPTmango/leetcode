package simple_level;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

/**
 * ����ת�㷨������Ƶ���⡷�������� map
 * 350
 * ��������Ľ��� II
 * �����������飬��дһ���������������ǵĽ�����
 *
 * ʾ�� 1:
 *
 * ����: nums1 = [1,2,2,1], nums2 = [2,2]
 * ���: [2,2]
 * ʾ�� 2:
 *
 * ����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * ���: [4,9]
 * ˵����
 *
 * ��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡�
 * ���ǿ��Բ�������������˳��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/22 9:30 ����
 */
public class Intersect {
    /**
     * ��һ��ͨ��map��¼ÿ�����ֳ��ֵĴ���
     * �ڶ��α����ڶ������飬�������
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n)) {
                if (map.get(n) > 0) {
                    resultList.add(n);
                    map.put(n, map.get(n) - 1);
                }
            }
        }
        // List<Integer> -> Integer[] -> int[]
        return Arrays.stream(resultList.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }
}
