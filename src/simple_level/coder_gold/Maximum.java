package simple_level.coder_gold;

/**
 * ������ 16.07. �����ֵ
 * ��дһ���������ҳ���������a��b��������һ��������ʹ��if-else�������Ƚ��������
 * <p>
 * ʾ����
 * <p>
 * ���룺 a = 1, b = 2
 * ����� 2
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/18 11:05 ����
 */
public class Maximum {
    /**
     * �ж�a-bΪ�������Ǹ���,int���͸�����λΪ1������Ϊ0
     * ��������31λ �õ������� 0��1 Ȼ����a��b��˵ý��
     * ����������⣬intתΪlong��������
     *
     * ������⣡��������������
     *
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
        long c = a;
        long d = b;
        int res = (int) ((c - d) >>> 63);// >>>��>>���� >>>�޷�������
        return b * res + a * (res ^ 1);
    }
}
