package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 ��������
 * 47. ȫ���� II
 * ����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�
 *
 * ʾ��:
 *
 * ����: [1,1,2]
 * ���:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/12 7:50 ����
 */
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    /**
     * ��Ϊ���ݵĹ�����nums���ݽṹ�б仯 ������visited����¼���ʹ���Ԫ��
     */
    int[] visited;
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // ������¼�Ƿ���ʹ�
        visited = new int[nums.length];
        // �������� �����֦
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        // ȫ��ȡ���� ��ֹ����
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // ֻҪû���ʹ��ͱ��� �ݹ��߼�
        for (int i = 0; i < nums.length; i++) {
            // ע�⣡������ ���𣡣� ���ѡ���Ԫ���Ǹո��ϴα������Ļ��ݻ����� ����
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == 0) {
                continue;
            }
            // �Ѿ����ʹ� ����ѡ��
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            backtrack(nums);
            // ����
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
