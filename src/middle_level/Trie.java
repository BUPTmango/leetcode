package middle_level;

/**
 * 208. ʵ�� Trie (ǰ׺��)
 * ʵ��һ�� Trie (ǰ׺��)������?insert,?search, ��?startsWith?������������
 *
 * ʾ��:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // ���� true
 * trie.search("app");     // ���� false
 * trie.startsWith("app"); // ���� true
 * trie.insert("app");
 * trie.search("app");     // ���� true
 * ˵��:
 *
 * ����Լ������е����붼����Сд��ĸ?a-z?���ɵġ�
 * ��֤���������Ϊ�ǿ��ַ�����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/4 10:08 ����
 */
public class Trie {
    private boolean is_string = false;
    private Trie next[] = new Trie[26];

    public Trie(){}

    public void insert(String word){//���뵥��
        Trie root=this;
        char w[]=word.toCharArray();
        for(int i=0;i<w.length;++i){
            if(root.next[w[i]-'a']==null)root.next[w[i]-'a']=new Trie();
            root=root.next[w[i]-'a'];
        }
        root.is_string=true;
    }

    public boolean search(String word){//���ҵ���
        Trie root=this;
        char w[]=word.toCharArray();
        for(int i=0;i<w.length;++i){
            if(root.next[w[i]-'a']==null)return false;
            root=root.next[w[i]-'a'];
        }
        return root.is_string;
    }

    public boolean startsWith(String prefix){//����ǰ׺
        Trie root=this;
        char p[]=prefix.toCharArray();
        for(int i=0;i<p.length;++i){
            if(root.next[p[i]-'a']==null)return false;
            root=root.next[p[i]-'a'];
        }
        return true;
    }
}
