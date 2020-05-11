package middle_level;

/**
 * 50. Pow(x, n)
 * ʵ��?pow(x, n)?�������� x �� n ���ݺ�����
 *
 * ʾ�� 1:
 *
 * ����: 2.00000, 10
 * ���: 1024.00000
 * ʾ��?2:
 *
 * ����: 2.10000, 3
 * ���: 9.26100
 * ʾ��?3:
 *
 * ����: 2.00000, -2
 * ���: 0.25000
 * ����: 2-2 = 1/22 = 1/4 = 0.25
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/11 12:35 ����
 */
public class MyPow {
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        // ���ö��ַ������͸��Ӷȵ�logN
        double y = quickMul(x, N / 2);
        // ż���������ģ�������Ҫ���һ��x
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        // ���nС��0�����ص���
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}
