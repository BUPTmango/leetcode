package middle_level;

/**
 * 861. ��ת�����ĵ÷�
 * ��һ����ά����A ����ÿ��Ԫ�ص�ֵΪ0��1��
 * <p>
 * �ƶ���ָѡ����һ�л��У���ת�����л����е�ÿһ��ֵ�������� 0 ������Ϊ 1�������� 1 ������Ϊ 0��
 * <p>
 * ����������������ƶ��󣬽��þ����ÿһ�ж����ն������������ͣ�����ĵ÷־�����Щ���ֵ��ܺ͡�
 * <p>
 * ���ؾ����ܸߵķ�����
 * <p>
 * <p>
 * <p>
 * ʾ����
 * <p>
 * ���룺[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * �����39
 * ���ͣ�
 * ת��Ϊ [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j]��0 ��1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/7 9:03 ����
 */
public class MatrixScore {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        // ��һ�� ��ÿ�е�һ�����1
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                changeOneZero(A[i]);
            }
        }
        // �ڶ��� ����ڶ��п�ʼ��ÿһ���е�1�ĸ��� ������
        for (int j = 1; j < n; j++) {
            changeColumnNumbers(A, j);
        }
        // ������ ����ֵ
        int num = 0;
        for (int j = 0; j < n; j++) {
            int temp = (int) Math.pow(2, n - j - 1);
            for (int i = 0; i < m; i++) {
                num += A[i][j] * temp;
            }
        }
        return num;
    }

    private void changeColumnNumbers(int[][] A, int column) {
        // ����0�ĸ���
        int zeroCount = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (A[i][column] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount > length / 2) {
            for (int i = 0; i < length; i++) {
                A[i][column] = A[i][column] == 0 ? 1 : 0;
            }
        }
    }

    private void changeOneZero(int[] line) {
        int length = line.length;
        for (int i = 0; i < length; i++) {
            line[i] = line[i] == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        MatrixScore matrixScore = new MatrixScore();
        matrixScore.matrixScore(new int[][]{{1, 1, 1, 0}, {0, 0, 0, 0}});
    }
}
