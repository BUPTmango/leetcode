package middle_level.jianzhi_offer;

/**
 * ��ָ Offer 64. ��1+2+��+n
 * �� 1+2+...+n ��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 *
 *
 * ʾ�� 1��
 *
 * ����: n = 3
 * ���:6
 * ʾ�� 2��
 *
 * ����: n = 9
 * ���:45
 * 
 * ���ƣ�
 *
 * 1 <= n<= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/24 2:05 ����
 */
public class SumNums {
    public int sumNums(int n) {
        // A && B  ���AΪfalse��B���жϲ���ִ��
        // ��������˵�n == 1 ֹͣ�ݹ���ж�
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
