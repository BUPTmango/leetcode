package simple_level;

/**
 * 461
 * ��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
 *
 * ������������ x �� y����������֮��ĺ������롣
 *
 * ע�⣺
 * 0 �� x, y < 231.
 *
 * ʾ��:
 *
 * ����: x = 1, y = 4
 *
 * ���: 2
 *
 * ����:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ��   ��
 *
 * ����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/8 10:57 ����
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        //ȡx,y����򣬵õ�һ��2���ƣ�����1�ĸ������Ǻ�������
        int z = x ^ y;
        //��z��z-1�������㣬���Ҳ����ͬ���������㼸�ξ��м���1
        while (z != 0) {
            hammingDistance++;
            //  & �Ӹ�λ��ʼ�Ƚϣ������������Ϊ1��Ϊ1������Ϊ0��
            z = z & (z - 1);
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        HammingDistance distance = new HammingDistance();
        System.out.println(distance.hammingDistance(1,4));
    }
}
