package middle_level;

/**
 * 1014. ��ѹ۹����
 * ��������������?A��A[i]?��ʾ�� i ���۹⾰������֣�������������?i ��?j?֮��ľ���Ϊ?j - i��
 *
 * һ�Ծ��㣨i < j����ɵĹ۹���ϵĵ÷�Ϊ��A[i] + A[j] + i?- j�������������֮�ͼ�ȥ��������֮��ľ��롣
 *
 * ����һ�Թ۹⾰����ȡ�õ���߷֡�
 *
 * ?
 *
 * ʾ����
 *
 * ���룺[8,1,5,2,6]
 * �����11
 * ���ͣ�i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/30 1:49 ����
 */
public class MaxScoreSightseeingPair {
    /**
     * ���ǻع�ͷ�����÷ֹ�ʽ�����ǿ��Խ����ֳ� A[i]+iA[i]+i �� A[j]-jA[j]?j �����֣�
     * ��������ͳ�ƾ��� jj �𰸵�ʱ������ A[j]-jA[j]?j �ǹ̶�����ģ�
     * ������ A[i]+i+A[j]-jA[i]+i+A[j]?j ��ֵ��ʵ�͵ȼ����� [0,j-1][0,j?1] �� A[i]+iA[i]+i �����ֵ mxmx��
     * ���� jj �Ĵ𰸼�Ϊ mx+A[j]-jmx+A[j]?j ��
     * �� mxmx ��ֵ����ֻҪ��ǰ����ö�� jj ��ʱ��ͬʱά������
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // �߱�����ά��
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }
}
