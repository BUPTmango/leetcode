package simple_level;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/28 10:05 上午
 */

/**
 * 查找一组（无序的）数中的众数，无非就是遍历数组，统计每个数字的出现频率。
 * 二叉搜索树的左右子结点和父结点之间有大小关系的限制，且二叉树的中序遍历是升序的。由此，问题可以转变成在一组升序排列的数中查找众数。
 *
 * 既然数字是升序的，就可以遍历一次完成统计。因为在升序排列中前一个数字总是小于等于后一个数字。
 * 借助三个变量，一个记录当前数字，一个记录当前数字的频率，一个记录上一个添加到List的数字的频率。
 *
 * 每访问一个数字，就将这个数字的出现次数加一，如果当前出现次数等于上一个添加到List的数字的出现次数，则在结果List中添加这个数字；
 * 如果当前出现次数大于上一个添加到List的数字的出现次数，则清空结果List再添加这个数字，并把上一个添加到List数字的出现次数更新为当前出现次数。
 *
 * [note]
 * 若是首次访问，需要将上一个添加到List的数字的频率设为1；
 * 每遇到一个新数字，则将当前数字的出现次数清零。
 *
 */
public class FindMode {
    private List<Integer> modes;
    private int cur;
    private int curTimes;
    private int lastTimes;

    public int[] findMode(TreeNode root) {
        modes = new LinkedList<>();
        inOrder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        // 首次访问，将上一个次数设置为1，因为后面要进行比较
        if (lastTimes == 0) {
            lastTimes = 1;
        }
        // 遇到新数字将当前次数设置为0，方便后面的++
        if (root.val != cur) {
            curTimes = 0;
        }
        cur = root.val;
        curTimes++;
        // 当前次数和上一个次数相同，添加元素
        if (curTimes == lastTimes) {
            modes.add(cur);
        }
        // 当前次数更多，清空list，添加当前元素
        if (curTimes > lastTimes) {
            lastTimes = curTimes;
            modes.clear();
            modes.add(cur);
        }
        inOrder(root.right);
    }
}
