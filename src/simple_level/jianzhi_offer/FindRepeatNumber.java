package simple_level.jianzhi_offer;


import java.util.HashSet;
import java.util.Set;

/**
 * ������03. �������ظ�������
 * �ҳ��������ظ������֡�
 *
 *
 * ��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
 *
 * ʾ�� 1��
 *
 * ���룺
 * [2, 3, 1, 0, 2, 5, 3]
 * �����2 �� 3
 * ?
 *
 * ���ƣ�
 *
 * 2 <= n <= 100000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/3 9:25 ����
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
