package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 �������
 * 90. �Ӽ� II
 * ����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 *
 * ˵�����⼯���ܰ����ظ����Ӽ���
 *
 * ʾ��:
 *
 * ����: [1,2,2]
 * ���:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/13 9:21 ����
 */
public class SubsetsWithDup {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // ���� �����ظ�Ԫ�ؼ�֦
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            // �ظ�Ԫ�� ��֦
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
