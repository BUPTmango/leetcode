package simple_level.coder_gold;

/**
 * ������ 08.01. ��������
 * �������⡣�и�С��������¥�ݣ�¥����n��̨�ף�С��һ�ο�����1�ס�2�׻�3�ס�ʵ��һ�ַ���������С���ж�������¥�ݵķ�ʽ��������ܴܺ�����Ҫ�Խ��ģ1000000007��
 *
 * ʾ��1:
 *
 *  ���룺n = 3
 *  �����4
 *  ˵��: �������߷�
 * ʾ��2:
 *
 *  ���룺n = 5
 *  �����13
 * ��ʾ:
 *
 * n��Χ��[1, 1000000]֮��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/3 11:33 ����
 */
public class WaysToStep {
    /**
     * ȡ�๫ʽ�� (a + b + c)%p = ((a%p + b%p)%p + c%p)%p
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            result[i] = ((result[i-3]%mod + result[i-2]%mod)%mod + result[i-1]%mod)%mod;
        }
        return result[n];
    }
}
