package simple_level.jianzhi_offer;


import java.util.HashSet;
import java.util.Set;

/**
 * ������03. shu�������ظ�������
 * �ҳ��������ظ������֡�
 * <p>
 * <p>
 * ��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺
 * [2, 3, 1, 0, 2, 5, 3]
 * �����2 �� 3
 * ?
 * <p>
 * ���ƣ�
 * <p>
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

    public int findRepeatNumber_in_place(int[] nums) {
        int temp;
        // ��ÿ�������������ֵ�������λ�� ���λ�����Ѿ��������� ��˵���ظ��� ֱ�ӷ���
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
