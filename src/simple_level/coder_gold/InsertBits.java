package simple_level.coder_gold;

/**
 * ������ 05.01. ����
 * ���롣��������32λ������N��M���Լ���ʾ����λ�õ�i��j����дһ�ַ�������M����N��ʹ��M��N�ĵ�jλ��ʼ������iλ�������ٶ���jλ��iλ��������M��Ҳ����M = 10 011����ôj��i֮�����ٿ�����5��λ�����磬�����ܳ���j = 3��i = 2���������Ϊ��3λ�͵�2λ֮��Ų���M��
 *
 * ʾ��1:
 *
 *  ���룺N = 10000000000, M = 10011, i = 2, j = 6
 *  �����N = 10001001100
 * ʾ��2:
 *
 *  ���룺 N = 0, M = 11111, i = 0, j = 4
 *  �����N = 11111
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/1 11:57 ����
 */
public class InsertBits {
    /**
     * ������
     * @param N
     * @param M
     * @param i
     * @param j
     * @return
     */
    public int insertBits(int N, int M, int i, int j) {
        for (int distance = i; distance < j + 1; distance++) {
            // ��11111111111111111111111111111110��βѭ���ƶ� distance λ���� N �����㽫�� distance λ����
            N = N & Integer.rotateLeft(~1, distance);
        }
        return N | (M << i);
    }
}
