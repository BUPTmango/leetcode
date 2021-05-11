package middle_level;

/**
 * 1734. �������������
 *
 * ����һ����������perm������ǰn�������������У���n�Ǹ� ������
 * �������ܳ���һ������Ϊ n - 1����������encoded������encoded[i] = perm[i] XOR perm[i + 1]���ȷ�˵�����perm = [1,3,2]����ôencoded = [2,1]��
 * ����encoded���飬���㷵��ԭʼ����perm����Ŀ��֤�𰸴�����Ψһ��
 *
 * ʾ�� 1��
 *
 * ���룺encoded = [3,1]
 * �����[1,2,3]
 * ���ͣ���� perm = [1,2,3] ����ô encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * ʾ�� 2��
 *
 * ���룺encoded = [6,5,4,6]
 * �����[2,4,1,5,3]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/11 09:05
 */
public class Decode {
    public int[] decode(int[] encoded) {
        // ���firstԪ�ؾͿ��Լ�����
        // �����perm[A,B,C,D,E]�����ֵABCDE
        int[] perm = new int[encoded.length + 1];
        int total = 0;
        for (int i = 1; i <= perm.length; i++) {
            total ^= i;
        }
        // ������λ�õ� ͳ��BCDE
        int odd = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            odd ^= encoded[i];
        }
        // �������һ��λ�õ�Ԫ��
        perm[0] = odd ^ total;
        for (int i = 0; i < perm.length - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
