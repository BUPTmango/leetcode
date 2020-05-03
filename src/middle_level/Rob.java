package middle_level;

import data_structure.TreeNode;

/**
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释:?小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 * ?    3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释:?小偷一晚能够盗取的最高金额?= 4 + 5 = 9.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/3 5:38 下午
 */
public class Rob {
    /**
     * 后根遍历 分别考虑当前节点打劫和不打劫
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = postRoot(root);
        return Math.max(res[0], res[1]);
    }
    private int[] postRoot(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        // 分别获取左右的结果
        int[] l = postRoot(cur.left);
        int[] r = postRoot(cur.right);
        int[] res = new int[2];
        // 0代表不打劫的情况 1代表打劫的情况
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = l[0] + r[0] + cur.val;
        return res;
    }
}
