package hard_level;

/**
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/4/20 16:59
 */
class Skiplist {
    /**
     * ������
     */
    private static int DEFAULT_MAX_LEVEL = 32;
    /**
     * ����������ʣ�Ҳ����������Ĳ������� ��1������(��������һ��)�ĸ��ʣ�����������maxLevel����������ʼ��Ϊ1
     */
    private static double DEFAULT_P_FACTOR = 0.25;

    Node head = new Node(null, DEFAULT_MAX_LEVEL); //ͷ�ڵ�

    int currentLevel = 1; //��ʾ��ǰnodes��ʵ�ʲ���������1��ʼ


    public Skiplist() {
    }

    public boolean search(int target) {
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, target);
            if (searchNode.next[i] != null && searchNode.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param num
     */
    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num, level);
        // �������ǰnum ������ʵ�ʲ������Ӹò㿪ʼ�������
        for (int i = currentLevel - 1; i >= 0; i--) {
            //�ҵ����������num�����list
            updateNode = findClosest(updateNode, i, num);
            if (i < level) {
                if (updateNode.next[i] == null) {
                    updateNode.next[i] = newNode;
                } else {
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        if (level > currentLevel) { //�����������Ĳ����ȵ�ǰ�Ĳ���������ô����currentLevel��head ֱ��ָ��newNode
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            currentLevel = level;
        }

    }

    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                //�ҵ��ò��иýڵ�
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
                continue;
            }
        }
        return flag;
    }

    /**
     * �ҵ�level�� value ����node �Ľڵ�
     *
     * @param node
     * @param levelIndex
     * @param value
     * @return
     */
    private Node findClosest(Node node, int levelIndex, int value) {
        while ((node.next[levelIndex]) != null && value > node.next[levelIndex].value) {
            node = node.next[levelIndex];
        }
        return node;
    }


    /**
     * ���һ������
     */
    private static int randomLevel() {
        int level = 1;
        while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL) {
            level++;
        }
        return level;
    }


    class Node {
        Integer value;
        Node[] next;

        public Node(Integer value, int size) {
            this.value = value;
            this.next = new Node[size];
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}
