package simple_level;

/**
 * 867. ת�þ���
 * ����һ������A������A��ת�þ���
 *
 * �����ת����ָ����������Խ��߷�ת���������������������������
 *
 * ʾ�� 1��
 *
 * ���룺[[1,2,3],[4,5,6],[7,8,9]]
 * �����[[1,4,7],[2,5,8],[3,6,9]]
 * ʾ�� 2��
 *
 * ���룺[[1,2,3],[4,5,6]]
 * �����[[1,4],[2,5],[3,6]]
 * 
 * ��ʾ��
 *
 * 1 <= A.length<= 1000
 * 1 <= A[0].length<= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/24 2:38 ����
 */
public class Transpose {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = A[i][j];
            }
        }

        return res;
    }
}
