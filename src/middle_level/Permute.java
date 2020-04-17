package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. ȫ����
 * ����һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ���С�
 *
 * ʾ��:
 *
 * ����: [1,2,3]
 * ���:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/17 12:28 ����
 */
public class Permute {
    /**
     * ִ��һ��������ȱ����������ĸ���㵽Ҷ�ӽ���γɵ�·������һ��ȫ����
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        // ��¼�Ƿ���ʹ�
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        // Ԫ��ȫ�������� ���һ������
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            // �ҵ����к���� ����״̬
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
