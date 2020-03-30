package simple_level.coder_gold;

/**
 * ������ 05.06. ����ת��
 * ����ת������дһ��������ȷ����Ҫ�ı伸��λ���ܽ�����Aת������B��
 *
 * ʾ��1:
 *
 *  ���룺A = 29 ������0b11101��, B = 15������0b01111��
 *  �����2
 * ʾ��2:
 *
 *  ���룺A = 1��B = 2
 *  �����2
 * ��ʾ:
 *
 * A��B��Χ��[-2147483648, 2147483647]֮��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/30 10:08 ����
 */
public class ConvertInteger {
    /**
     * ����A��B����ֵ��1�ĸ���, ͨ��n&(n - 1)����ȥ��һ�����Ķ����Ʊ�ʾ�����ұߵ�1.
     * @param A
     * @param B
     * @return
     */
    public int convertInteger(int A, int B) {
        int temp = A ^ B;
        int count = 0;
        while (temp != 0) {
            temp &= (temp - 1);
            count++;
        }
        return count;
    }
}
