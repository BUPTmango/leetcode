package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 894. 所有可能的满二叉树
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 * 示例：
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 *
 * 提示：
 *
 * 1 <= N <= 20
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 10:04 上午
 */
public class AllPossibleFBT {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
                // 通过简单的计数参数，没有满二叉树具有正偶数个结点
            } else if (N % 2 == 1) {
                // 对于 N≥3，我们可以设定如下的递归策略：
                // FBT(N)= [对于所有的 xx，所有的树的左子结点来自FBT(x) 而右子结点来自FBT(N-1-x)]。
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x)) {
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            // 我们应该缓存函数 FBT 之前的结果，这样我们就不必在递归中重新计算它们
            memo.put(N, ans);
        }

        return memo.get(N);
    }
}
