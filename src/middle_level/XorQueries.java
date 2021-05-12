package middle_level;

/**
 * 1310. ����������ѯ
 * ��һ������������arr���ָ���һ����Ӧ�Ĳ�ѯ����queries������queries[i] = [Li,Ri]��
 * ����ÿ����ѯi����������Li��Ri��XORֵ����arr[Li] xor arr[Li+1] xor ... xor arr[Ri]����Ϊ���β�ѯ�Ľ����
 * ������һ������������ѯqueries���н�������顣
 *
 * ʾ�� 1��
 *
 * ���룺arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * �����[2,7,14,8] 
 * ���ͣ�
 * ������Ԫ�صĶ����Ʊ�ʾ��ʽ�ǣ�
 * 1 = 0001 
 * 3 = 0011 
 * 4 = 0100 
 * 8 = 1000 
 * ��ѯ�� XOR ֵΪ��
 * [0,1] = 1 xor 3 = 2 
 * [1,2] = 3 xor 4 = 7 
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14 
 * [3,3] = 8
 * ʾ�� 2��
 *
 * ���룺arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * �����[8,0,4,4]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/12 08:45
 */
public class XorQueries {
    /**
     * ǰ׺��˼��
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }
}
