package middle_level;

/**
 * 48. ��תͼ��
 * ����һ�� n?��?n �Ķ�ά�����ʾһ��ͼ��
 *
 * ��ͼ��˳ʱ����ת 90 �ȡ�
 *
 * ˵����
 *
 * �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
 *
 * ʾ�� 1:
 *
 * ���� matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * ԭ����ת�������ʹ���Ϊ:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * ʾ�� 2:
 *
 * ���� matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * ԭ����ת�������ʹ���Ϊ:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/23 3:43 ����
 */
public class Rotate {
    /**
     * ������ת
     * �������� - ���µĶԽ��߷�ת��270�� +270��+ һ�ξ��񣩣�����ˮƽ�������·�ת��-180�� +?180��+ һ�ξ��񣩣�����ʵ��˳ʱ�� 9090 �ȵ���תЧ��
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int nums = matrix.length;
        for (int i = 0; i < nums; ++i){
            for (int j = 0; j < nums - i; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - j][nums - 1 - i];
                matrix[nums - 1 - j][nums - 1 - i] = temp;
            }
        }
        for (int i = 0; i < (nums >> 1); ++i){
            for (int j = 0; j < nums; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - i][j];
                matrix[nums - 1 - i][j] = temp;
            }
        }
    }
}
