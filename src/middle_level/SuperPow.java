package middle_level;

/**
 * 372. �����η�
 * ��������Ǽ���ab��1337 ȡģ��a ��һ����������b ��һ���ǳ�����������һ���������ʽ������
 *
 * ʾ�� 1��
 *
 * ���룺a = 2, b = [3]
 * �����8
 * ʾ�� 2��
 *
 * ���룺a = 2, b = [1,0]
 * �����1024
 * ʾ�� 3��
 *
 * ���룺a = 1, b = [4,3,3,8,5,2]
 * �����1
 * ʾ�� 4��
 *
 * ���룺a = 2147483647, b = [2,0,0]
 * �����1198
 *
 * ��ʾ��
 *
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b ����ǰ�� 0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/2 3:23 ����
 */
public class SuperPow {
    private int base = 1337;

    public int superPow(int a, int[] b) {
        // �ݹ� ȡģ ��Ч��
        return findPow(a, b, b.length - 1);
    }

    private int findPow(int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }
        int last = b[index];
        // ��С��ģ�ݹ����
        int part1 = myPow(a, last);
        int part2 = myPow(findPow(a, b, index - 1), 10);
        return (part1 * part2) % base;
    }

    private int myPow(int a, int k) {
        if (k == 0) {
            return 1;
        }
        a %= base;
        // ����
        if (k % 2 == 1) {
            return (a * myPow(a, k - 1)) % base;
        // ż��
        } else {
            int sub = myPow(a, k / 2);
            return (sub * sub) % base;
        }
    }
}
