package middle_level.jianzhi_offer;

/**
 * ��ָ Offer 16. ��ֵ�������η�
 * ʵ�ֺ���double Power(double base, int exponent)����base��exponent�η�������ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
 *
 *
 * ʾ�� 1:
 *
 * ����: 2.00000, 10
 * ���: 1024.00000
 * ʾ��2:
 *
 * ����: 2.10000, 3
 * ���: 9.26100
 * ʾ��3:
 *
 * ����: 2.00000, -2
 * ���: 0.25000
 * ����: 2-2 = 1/22 = 1/4 = 0.25
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/3 9:42 ����
 */
public class MyPow {
    public double myPow(double x, int n) {
        // xΪ0��ֱ�ӷ���0
        if(x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        // �� n < 0 ʱ��������ת���� n��0 �ķ�Χ�ڣ���ִ�� x = 1/x��n = - n��
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        // ѭ�����㣺�� n = 0ʱ������
        while(b > 0) {
            // �� n&1=1 ʱ������ǰ x ���� res ���� res *= x ����
            if((b & 1) == 1) res *= x;
            // ִ�� x = x^2
            x *= x;
            // ִ�� n ����һλ���� n >>= 1��
            b >>= 1;
        }
        return res;
    }
}
