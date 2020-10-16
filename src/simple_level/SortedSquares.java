package simple_level;


/**
 * 977. ���������ƽ��
 * ����һ�����ǵݼ�˳��������������� A������ÿ�����ֵ�ƽ����ɵ������飬Ҫ��Ҳ���ǵݼ�˳������
 *
 * 
 *
 * ʾ�� 1��
 *
 * ���룺[-4,-1,0,3,10]
 * �����[0,1,9,16,100]
 * ʾ�� 2��
 *
 * ���룺[-7,-3,2,3,11]
 * �����[4,9,9,49,121]
 * 
 *
 * ��ʾ��
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A�Ѱ��ǵݼ�˳������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/16 8:13 ����
 */
public class SortedSquares {
    /**
     * ˫ָ��
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
