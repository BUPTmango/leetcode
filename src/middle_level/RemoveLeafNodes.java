package middle_level;

import data_structure.TreeNode;

/**
 * 1325. ɾ������ֵ��Ҷ�ӽڵ�
 * ����һ����rootΪ���Ķ�������һ������target������ɾ������ֵΪtarget ��Ҷ�ӽڵ� ��
 *
 * ע�⣬һ��ɾ��ֵΪtarget��Ҷ�ӽڵ㣬���ĸ��ڵ�Ϳ��ܱ��Ҷ�ӽڵ㣻�����Ҷ�ӽڵ��ֵǡ��Ҳ��target ����ô����ڵ�ҲӦ�ñ�ɾ����
 *
 * Ҳ����˵������Ҫ�ظ��˹���ֱ�����ܼ���ɾ����
 *
 * 
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺root = [1,2,3,2,null,2,4], target = 2
 * �����[1,null,3,null,4]
 * ���ͣ�
 * ������ߵ�ͼ�У���ɫ�ڵ�ΪҶ�ӽڵ㣬�����ǵ�ֵ�� target ��ͬ��ͬΪ 2 �������ǻᱻɾ�����õ��м��ͼ��
 * ��һ���µĽڵ�����Ҷ�ӽڵ�������ֵ�� target ��ͬ�����Խ��ٴν���ɾ�����Ӷ��õ����ұߵ�ͼ��
 * ʾ�� 2��
 *
 *
 *
 * ���룺root = [1,3,3,3,2], target = 3
 * �����[1,3,null,null,2]
 * ʾ�� 3��
 *
 * ���룺root = [1,2,null,2,null,2], target = 2
 * �����[1]
 * ���ͣ�ÿһ����ɾ��һ����ɫ��Ҷ�ӽڵ㣨ֵΪ 2����
 * ʾ�� 4��
 *
 * ���룺root = [1,1,1], target = 1
 * �����[]
 * ʾ�� 5��
 *
 * ���룺root = [1,2,3], target = 1
 * �����[1,2,3]
 * 
 *
 * ��ʾ��
 *
 * 1 <= target<= 1000
 * ÿһ��������� 3000 ���ڵ㡣
 * ÿһ���ڵ�ֵ�ķ�Χ��[1, 1000]��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/24 2:02 ����
 */
public class RemoveLeafNodes {
    /**
     * ��������� ��Ҷ�ӽڵ�һֱ���ϵ����ڵ����ɾ��
     * Ҳ�����ȱ����� �ڻ��ݵ�ʱ�����ɾ������
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // �������±���
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        // ��root�����Һ��Ӷ������ڵ�ʱ��ִ�е�����
        // ���ݲ��� ɾ���ڵ�
        if (isDeleteNode(root, target)) {
            return null;
        }
        return root;
    }

    private boolean isDeleteNode(TreeNode node, int target) {
        if (node != null && node.left == null && node.right == null && node.val == target) {
            return true;
        }
        return false;
    }
}
