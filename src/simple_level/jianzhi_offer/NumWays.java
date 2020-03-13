package simple_level.jianzhi_offer;

/**
 * ������10- II. ������̨������
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��̨�ס������������һ�� n?����̨���ܹ��ж�����������
 *
 * ����Ҫȡģ 1e9+7��1000000007����������ʼ���Ϊ��1000000008���뷵�� 1��
 *
 * ʾ�� 1��
 *
 * ���룺n = 2
 * �����2
 * ʾ�� 2��
 *
 * ���룺n = 7
 * �����21
 * ��ʾ��
 *
 * 0 <= n <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/13 5:20 ����
 */
public class NumWays {
    /**
     * ����ʱ������
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return numWays(n - 1) + numWays(n - 2);
        }
    }

    public int numWays_better(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    public static void main(String[] args) {
        NumWays n = new NumWays();
        System.out.println(n.numWays(44));
    }
}
