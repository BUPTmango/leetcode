package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author mango
 * @create 2019-03-18 3:48 PM
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> tempList = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                tempList.add(t.val);
                if(t.left!=null)
                    temp.add(t.left);
                if(t.right!=null)
                    temp.add(t.right);
            }
            list.add(0,tempList);//自底向上输出
            if(temp.isEmpty())
                break;
            queue = temp;
        }
        return list;
    }
}