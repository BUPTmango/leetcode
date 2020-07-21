package middle_level.jianzhi_offer;

import java.util.Arrays;

/**
 * ��ָ Offer 45. �������ų���С����
 * ����һ���Ǹ��������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 *
 * ʾ�� 1:
 *
 * ����: [10,2]
 * ���: "102"
 * ʾ��?2:
 *
 * ����: [3,30,34,5,9]
 * ���: "3033459"
 *
 * ��ʾ:
 *
 * 0 < nums.length <= 100
 * ˵��:
 *
 * ���������ܷǳ�����������Ҫ����һ���ַ�������������
 * ƴ�����������ֿ��ܻ���ǰ�� 0�����������Ҫȥ��ǰ�� 0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/21 9:49 ����
 */
public class MinNumber {
    /**
     * ������ƴ�������� ����С���֡� ����������һ���������⡣
     * �����жϹ��� �� nums ���������ֵ��ַ�����ʽ x �� y ����
     *
     * ��ƴ���ַ��� x + y > y + x ���� m > n ��
     * ��֮���� x + y < y + x ���� n < m ��
     *
     * �������Ϲ��������κ����򷽷��� nums ִ�����򼴿ɡ�
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        // ��int������String����
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // �����Զ������������������
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        // ͨ��StringBuilder��������
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
}
