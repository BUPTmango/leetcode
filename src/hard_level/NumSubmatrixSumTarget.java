package hard_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. Ԫ�غ�ΪĿ��ֵ���Ӿ�������
 * ͬ560
 * ��������matrix��Ŀ��ֵtarget������Ԫ���ܺ͵���Ŀ��ֵ�ķǿ��Ӿ����������
 * <p>
 * �Ӿ���x1, y1, x2, y2������ x1 <= x <= x2��y1 <= y <= y2�����е�Ԫmatrix[x][y]�ļ��ϡ�
 * <p>
 * ���(x1, y1, x2, y2) ��(x1', y1', x2', y2')�����Ӿ����в������겻ͬ���磺x1 != x1'������ô�������Ӿ���Ҳ��ͬ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * �����4
 * ���ͣ��ĸ�ֻ�� 0 �� 1x1 �Ӿ���
 * ʾ�� 2��
 * <p>
 * ���룺matrix = [[1,-1],[-1,1]], target = 0
 * �����5
 * ���ͣ����� 1x2 �Ӿ��󣬼������� 2x1 �Ӿ����ټ���һ�� 2x2 �Ӿ���
 * ʾ�� 3��
 * <p>
 * ���룺matrix = [[904]], target = 0
 * �����0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/29 09:51
 */
public class NumSubmatrixSumTarget {
    /**
     * ö���Ӿ�������±߽磬��������ñ߽���ÿ�е�Ԫ�غͣ���ԭ����ת����������һά����
     *
     * @param matrix
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // ö���ϱ߽�
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // ö���±߽�
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // ����ÿ�е�Ԫ�غ�
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    /**
     * lc 560
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, pre = 0;
        for (int x : nums) {
            pre += x;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
