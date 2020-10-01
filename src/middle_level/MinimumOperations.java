package middle_level;

/**
 * LCP 19. ��Ҷ�ղؼ�
 *
 * С�۳�ȥ���Σ�;���ռ���һЩ��Ҷ�ͻ�Ҷ����������ЩҶ�ӳ���������һ����Ҷ�ղؼ� leaves�� �ַ��� leaves ������Сд�ַ� r �� y�� �����ַ� r ��ʾһƬ��Ҷ���ַ� y ��ʾһƬ��Ҷ��
 * ������������Ŀ��ǣ�С����Ҫ���ղؼ�����Ҷ�����е����ɡ��졢�ơ��졹�����֡�ÿ������Ҷ�������Բ���ȣ���������ڵ��� 1��ÿ�ε���������С�ۿ��Խ�һƬ��Ҷ�滻�ɻ�Ҷ���߽�һƬ��Ҷ�滻�ɺ�Ҷ������С��������Ҫ���ٴε����������ܽ���Ҷ�ղؼ�������ϡ�
 *
 * ʾ�� 1��
 *
 * ���룺leaves = "rrryyyrryyyrr"
 *
 * �����2
 *
 * ���ͣ��������Σ����м����Ƭ��Ҷ�滻�ɻ�Ҷ���õ� "rrryyyyyyyyrr"
 *
 * ʾ�� 2��
 *
 * ���룺leaves = "ryr"
 *
 * �����0
 *
 * ���ͣ��ѷ���Ҫ�󣬲���Ҫ�������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/1 7:53 ����
 */
public class MinimumOperations {
    /**
     * ��̬�滮
     * ���ǿ����� 3 ��״̬�ֱ��ʾ���е�ÿһ���֣���״̬ 0 ��״̬ 2 �ֱ��ʾǰ��ͺ���ĺ�ɫ���֣�״̬ 1 ��ʾ��ɫ���֡�
     * ������ f[i][j] ��ʾ���ڵ� 0 Ƭ���� i ƬҶ�ӣ���Ϊ leaves[0..i]�����е������������ҵ� i ƬҶ�Ӵ���״̬ j ʱ����С����������
     *
     * @param leaves
     * @return
     */
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] f = new int[n][3];
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            f[i][0] = f[i - 1][0] + isYellow;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
            if (i >= 2) {
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
            }
        }
        return f[n - 1][2];
    }
}
