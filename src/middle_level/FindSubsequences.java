package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 491. ����������
 * ����һ����������, ����������ҵ����и�����ĵ��������У����������еĳ���������2��
 *
 * ʾ��:
 *
 * ����: [4, 6, 7, 7]
 * ���: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/26 9:33 ����
 */
public class FindSubsequences {
    hahahahahahahaha
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        // ָ������굱ǰ����֮�� ���һ����¼
        if (cur == nums.length) {
            // ���������еĳ���������2
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        // ���ѡ��ǰԪ�أ���ô�ѵ�ǰԪ�ؼ��뵽 temp �У�Ȼ��ݹ���һ��λ�ã��ڵݹ������Ӧ���� temp �����һ��Ԫ��ɾ�����л���
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        // ��ѡ��ǰԪ�� ֱ��������һ��
        // ֻ�е���ǰ��Ԫ�ز�������һ��ѡ���Ԫ�ص�ʱ�򣬲ſ��ǲ�ѡ��ǰԪ�أ�ֱ�ӵݹ�����Ԫ��   ��ֹ�ظ�
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}
