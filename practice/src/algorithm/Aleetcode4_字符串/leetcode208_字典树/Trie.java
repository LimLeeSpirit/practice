package algorithm.Aleetcode4_字符串.leetcode208_字典树;


import java.util.Arrays;

/**
 * 实现一个字典树, 你可以假设所有的输入都是由小写字母 a-z 构成的.保证所有输入均为非空字符串。
 *
 *
 * 首先需要明白字典树是什么：
 * 字典树是一种可以用来快速查找和插入的数据结构，在元素的基本组成部分固定且不多的时候，它使用节点的值顺序形成需要的字符串或者语句
 * 它的查找和插入效率非常高
 *
 * 主要操作包括插入、查找、判断一个字符串前缀是否存在于字典树
 *
 * 每个节点如何定义：
 * 每个节点都是一个 Node，包含属性 isEnd，代表是否是某个单词结尾，
 * 还有大小为 26 的子孩子节点，如果孩子节点不空，则代表该位有这个值
 *
 * 使用C++的结构体来定义字典树的节点，也就是在Java中需要自己开辟一个类，或者内部类，来实现节点
 *
 *
 */
public class Trie {

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node n = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int k = c - 'a';
            if (n.sons[k] == null) {
                n.sons[k] = new Node();
            }
            n = n.sons[k];
        }
        n.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = root;
        for (char c : word.toCharArray()) {
            int k = c - 'a';
            if (n.sons[k] == null) {
                return false;
            }
            n = n.sons[k];
        }
        return n.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node n = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            int k = c - 'a';
            if (n.sons[k] == null) {
                return false;
            }
            n = n.sons[k];
        }
        return true;
    }
}

class Node {
    boolean isEnd;
    Node[] sons;
    public Node() {
        isEnd = false;
        sons = new Node[26];
        Arrays.fill(sons, null);
    }
}
