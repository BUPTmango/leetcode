package simple_level.coder_gold;

/**
 * ������ 16.05. �׳�β��
 * ���һ���㷨����� n �׳��ж��ٸ�β���㡣
 *
 * ʾ�� 1:
 *
 * ����: 3
 * ���: 0
 * ����:?3! = 6, β����û���㡣
 * ʾ��?2:
 *
 * ����: 5
 * ���: 1
 * ����:?5! = 120, β������ 1 ����.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/2 11:47 ����
 */
public class TrailingZeroes {
    /**
     * ��ʵn!�е���ȫ����5��2�ı������׵ģ���������Ϊ2�ĸ�������5�ģ����ԣ�ֻ����������ж��ٸ�5�ı������ɡ�
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int m5 = 0;
        while(n > 0){
            m5 += n/5;
            n/=5;
        }
        return m5;
    }
}
