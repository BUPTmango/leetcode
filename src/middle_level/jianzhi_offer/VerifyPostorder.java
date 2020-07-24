package middle_level.jianzhi_offer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回?true，否则返回?false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/24 5:06 下午
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) {
            // 说明树的节点小于等于1 直接返回true
            return true;
        }
        int p = i;
        // 划分左右子树： 遍历后序遍历的 [i, j] 区间元素，寻找 第一个大于根节点 的节点，索引记为 m 。
        // 此时，可划分出左子树区间 [i,m-1] 、右子树区间 [m, j - 1] 、根节点索引 j 。
        while(postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        // 右子树所有必须大于根
        while(postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
