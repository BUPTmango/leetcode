package simple_level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * ����ת�㷨������Ƶ���⡷�������� set
 * 349. ��������Ľ���
 * �����������飬��дһ���������������ǵĽ�����
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺nums1 = [1,2,2,1], nums2 = [2,2]
 * �����[2]
 * ʾ�� 2��
 *
 * ���룺nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * �����[9,4]
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/1 2:38 ����
 */
public class Intersection {
    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) {
            if (set2.contains(s)) {
                output[idx++] = s;
            }
        }

        return Arrays.copyOf(output, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        // ���Ƚ��������鶼ת����set
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
            set2.add(n);
        }

        // ������С�ļ��ϣ�������е�ÿ��Ԫ���Ƿ�ͬ�������ڽϴ�ļ�����
        if (set1.size() < set2.size()) {
            return set_intersection(set1, set2);
        } else {
            return set_intersection(set2, set1);
        }
    }

}
