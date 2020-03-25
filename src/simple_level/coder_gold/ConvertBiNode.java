package simple_level.coder_gold;

import data_structure.TreeNode;

/**
 * ������ 17.12. BiNode
 * ���������ݽṹTreeNode��������ʾ������������left�ÿգ�rightΪ��һ������ڵ㣩��ʵ��һ���������Ѷ���������ת��Ϊ��������Ҫ��ֵ��˳�򱣳ֲ��䣬ת������Ӧ��ԭַ�ģ�Ҳ������ԭʼ�Ķ�����������ֱ���޸ġ�
 *
 * ����ת����ĵ��������ͷ�ڵ㡣
 *
 * ע�⣺�������ԭ�������Ķ�
 *
 * ʾ����
 *
 * ���룺 [4,2,5,1,3,null,6,0]
 * ����� [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * ��ʾ��
 *
 * �ڵ��������ᳬ�� 100000��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/25 9:34 ����
 */
public class ConvertBiNode {
    /**
     * �ݹ�
     * BST�������������ģ�����ֻҪ������������������ɣ�
     * ����һ��ǰ���ڵ�prev����¼��һ��������Ľڵ㣬��ǰ�ڵ㱻��������ʱ��
     * ��prev.rightָ��ǰ�ڵ�node��Ȼ��node.left�ÿգ�prevָ����Ƶ�node,���node�������������ɡ�
     *
     * node.left = null;// ��ǰ�ڵ���ָ���ÿ�
     * prev.right = node;// ǰ��ָ����ָ��ָ��ǰ�ڵ㣬��Ϊ�����nextָ�룬��������Ԫ��
     * prev = node;// ָ�����
     *
     * @param root
     * @return
     */
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);// �������ͷָ���ڱ�
        // ��ʼ�������
        inorder(root,head);
        return head.right;
    }

    private TreeNode inorder(TreeNode root,TreeNode prev){
        if (root != null){
            prev = inorder(root.left,prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = inorder(root.right,prev);
        }
        return prev;
    }
}
