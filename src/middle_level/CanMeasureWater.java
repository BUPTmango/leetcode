package middle_level;

/**
 * 365. ˮ������
 * �����������ֱ�Ϊ x�� �� y�� ��ˮ���Լ����޶��ˮ�����ж��ܷ�ͨ��ʹ��������ˮ�����Ӷ����Եõ�ǡ�� z�� ��ˮ��
 *
 * ������ԣ������������ˮ���е�һ��������ʢ��ȡ�õ� z�� ˮ��
 *
 * ������
 *
 * װ������һ��ˮ��
 * �������һ��ˮ��
 * ��һ��ˮ��������һ��ˮ����ˮ��ֱ��װ�����ߵ���
 * ʾ�� 1: (From the famous "Die Hard" example)
 *
 * ����: x = 3, y = 5, z = 4
 * ���: True
 * ʾ�� 2:
 *
 * ����: x = 2, y = 6, z = 5
 * ���: False
 */
public class CanMeasureWater {
    /**
     * �ж�z�ܷ���x��y�����Լ������
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
           return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        if (x == 0) {
            return z == 0 || y == z;
        }
        if (y == 0) {
            return z == 0 || x == z;
        }
        return z % gcd(x, y) == 0;
    }
    private int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }
}
