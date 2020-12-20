package simple_level.jianzhi_offer;


/**
 * ������66. �����˻�����
 * ����һ������ A[0,1,��,n-1]���빹��һ������ B[0,1,��,n-1]������ B �е�Ԫ�� B[i]=A[0]��A[1]������A[i-1]��A[i+1]������A[n-1]������ʹ�ó�����
 *
 * ?
 *
 * ʾ��:
 *
 * ����: [1,2,3,4,5]
 * ���: [120,60,40,30,24]
 * ?
 *
 * ��ʾ��
 *
 * ����Ԫ�س˻�֮�Ͳ������ 32 λ����
 * a.length <= 100000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/8 9:50 ����
 */
public class ConstructArr {
    /**
     * �Լ�д�ķ��� ����ʱ������ ��ͨ��
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int product = 1;
            for (int j = 0; j < a.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    product *= a[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    /**
     * �������ұ����۳ˣ�������������� ret �У���ʱ ret[i] ��ʾ��A[i] �������Ԫ�صĳ˻�
     * Ȼ�������������۳ˣ���ȡA[i] �ұ�����Ԫ�صĳ˻�
     * ���߱���֮��õ��� ret���������ս��
     *
     * @param a
     * @return
     */
    public int[] constructArr_better(int[] a) {
        int length = a.length;
        int[] result = new int[length];
        int left = 1;
        for (int i = 0; i < length; i++) {
            result[i] = left;
            left *= a[i];
        }
        int right = 1;
        for (int j = length - 1; j >= 0; j--) {
            result[j] *= right;
            right *= a[j];
        }
        return result;
    }

    public static void main(String[] args) {
        ConstructArr c = new ConstructArr();
        int[] result = c.constructArr(new int[]{1,2,3,4,5});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
