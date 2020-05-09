package middle_level;

import data_structure.Graph.Node;

import java.util.*;

/**
 * 133. ��¡ͼ
 * ��������?��ͨ?ͼ��һ���ڵ�����ã����㷵�ظ�ͼ��?�������¡����
 *
 * ͼ�е�ÿ���ڵ㶼��������ֵ val��int�� �����ھӵ��б�list[Node]����
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * ?
 *
 * ����������ʽ��
 *
 * �������ÿ���ڵ��ֵ��������������ͬ�����磬��һ���ڵ�ֵΪ 1��val = 1�����ڶ����ڵ�ֵΪ 2��val = 2�����Դ����ơ���ͼ�ڲ���������ʹ���ڽ��б��ʾ��
 *
 * �ڽ��б� �����ڱ�ʾ����ͼ�������б�ļ��ϡ�ÿ���б�������ͼ�нڵ���ھӼ���
 *
 * �����ڵ㽫ʼ����ͼ�еĵ�һ���ڵ㣨ֵΪ 1��������뽫?�����ڵ�Ŀ���?��Ϊ�Կ�¡ͼ�����÷��ء�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/8 12:22 ����
 */
public class CloneGraph {
    /**
     * ��̫����
     * DFS
     * @param node
     * @return
     */
    public Node cloneGraph_DFS(Node node) {
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node,Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors)clone.neighbors.add(dfs(n,lookup));
        return clone;
    }


    /**
     *  ��̫����
     * BFS
     * @param node
     * @return
     */
    public Node cloneGraph_BFS(Node node) {
        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        return clone;
    }
}
