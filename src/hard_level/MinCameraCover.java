package hard_level;

import data_structure.TreeNode;

/**
 * 968. 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/22 8:46 上午
 */
public class MinCameraCover {
    /**
     * 有三个状态:
     * 0=>这个结点待覆盖
     * 1=>这个结点已经覆盖
     * 2=>这个结点上安装了相机
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        // 遍历到最后 root还没有被覆盖 添加摄像机
        if (lrd(root) == 0) {
            res++;
        }
        return res;
    }

    int res = 0;

    /**
     * lrd 后序遍历
     * @param node
     * @return
     */
    int lrd(TreeNode node) {

        if (node == null) {
            return 1;
        }
        int left = lrd(node.left);
        int right = lrd(node.right);
        // 左节点或者右节点没有覆盖 在当前节点安装摄像机
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        // 左右节点都已经覆盖 当前节点无需摄像机
        if (left == 1 && right == 1) {
            return 0;
        }
        // 一个为1一个为2 当前节点肯定被覆盖 返回1
        if (left + right >= 3) {
            return 1;
        }

        return -1;
    }
}
