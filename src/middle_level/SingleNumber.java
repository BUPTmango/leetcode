package middle_level;

/**
 * 137. ֻ����һ�ε����� II
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ����������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 *
 * ˵����
 *
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 *
 * ʾ�� 1:
 *
 * ����: [2,2,3,2]
 * ���: 3
 * ʾ��2:
 *
 * ����: [0,1,0,1,0,1,99]
 * ���: 99
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/3/26 8:14 ����
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                // �����ǰλ��1��++
                if ((num >> i & 1) == 1) {
                    count++;
                }
            }
            // ���������3 �����λ�þ���0 ����Ϊ1
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}
