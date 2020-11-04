package simple_level;

/**
 * λ���㼼��    a ^ a = 0   a ^ 0 = a
 * 136. ֻ����һ�ε�����
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 *
 * ˵����
 *
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 *
 * ʾ�� 1:
 *
 * ����: [2,2,1]
 * ���: 1
 * ʾ��2:
 *
 * ����: [4,1,2,1,2]
 * ���: 4
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/4 8:45 ����
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
