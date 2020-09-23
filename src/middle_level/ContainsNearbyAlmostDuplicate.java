package middle_level;

import java.util.TreeSet;

/**
 * ����ת�㷨������Ƶ���⡷�����������ײ�ʵ�ֵ�˳����
 * 220. �����ظ�Ԫ�� III
 * ���������� nums �У��Ƿ���������±� i �� j��ʹ��nums [i] ��nums [j]�Ĳ�ľ���ֵС�ڵ��� t �������� i �� j �Ĳ�ľ���ֵҲС�ڵ��� ? ��
 *
 * ��������򷵻� true�������ڷ��� false��
 *
 * ʾ��1:
 *
 * ����: nums = [1,2,3,1], k = 3, t = 0
 * ���: true
 * ʾ�� 2:
 *
 * ����: nums = [1,0,1,1], k = 1, t = 2
 * ���: true
 * ʾ�� 3:
 *
 * ����: nums = [1,5,9,1,5,9], k = 2, t = 3
 * ���: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/23 7:09 ����
 */
public class ContainsNearbyAlmostDuplicate {
    /**
     * ���������ά����Ԫ��������ģ�ֻ��Ҫ�ö�����������������Ƿ�������ľͿ����ˡ�
     * ������ƽ������������������ڶ���ʱ����ͨ�� ���� �� ɾ�� ���Ի���������Ԫ������
     *
     * ������������㷨��α���룺
     *
     * ��ʼ��һ�ſյĶ��������� set
     * ����ÿ��Ԫ��x��������������
     *      �� set �ϲ��Ҵ��ڵ���x����С���������s-x��t�򷵻� true
     *      �� set �ϲ���С�ڵ���x�������������x-g��t�򷵻� true
     *      �� set �в���x
     *      ������Ĵ�С������k, ���Ƴ�������������Ǹ�����
     * ���� false
     *
     * ����ǿ��ת��Ϊlong����Ϊ��int����� ���п��ܷ�����Խ������
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // ceiling�������ش��ڵ��ڸ���Ԫ�ص���СԪ��
            Long s = set.ceiling((long) nums[i]);
            if (s != null && s <= (long)(nums[i] + t)) {
                return true;
            }

            // floor��������С�ڵ��ڸ���Ԫ�ص����Ԫ��
            Long g = set.floor((long) nums[i]);
            if (g != null && (long)nums[i] <= (g + t)) {
                return true;
            }

            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
