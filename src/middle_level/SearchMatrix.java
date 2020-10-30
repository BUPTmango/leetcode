package middle_level;

/**
 * 74. ������ά����
 *
 ��дһ����Ч���㷨���ж� m x n �����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�

 ÿ���е����������Ұ��������С�
 ÿ�еĵ�һ����������ǰһ�е����һ��������

 ʾ�� 1��

 ���룺matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 �����true
 ʾ�� 2��

 ���룺matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 �����false
 ʾ�� 3��

 ���룺matrix = [], target = 0
 �����false

 ��ʾ��

 m == matrix.length
 n == matrix[i].length
 0 <= m, n <= 100
 -104 <= matrix[i][j], target <= 104
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/29 9:22 ����
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // �����Ͻǿ�ʼ�� target��������� targetС��������
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            int curr = matrix[i][j];
            if (curr == target) {
                return true;
            } else if (curr < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
