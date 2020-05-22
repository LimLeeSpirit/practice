package algorithm.A_排序;

import java.util.PriorityQueue;

/**
 * 堆排序
 * 利用了一种数据结构：堆，是一种完全二叉树（除了最后一层叶子节点之外，其他节点都有左右子节点，且最后一层叶子节点是在左半边）
 * 最小堆，根结点的值比左右子节点都小。内部使用数组存储元素，每个节点都有自己的下标，从 1 到 size，利用下标获取元素值
 * Java 默认是利用 PriorityQueue 实现的小顶堆
 *
 * 排序的思路是：1、先将所以数构建成一个堆，建堆的时间复杂度是O（nlgn），n是元素个数；
 *            2、每次从堆中取堆顶元素，然后堆自己维护成最大堆或者最小堆，
 *                维护的时间成本是O（lgn），因为删除堆顶元素，会将数组最后一个元素放入堆顶，然后向下比较更新，最多走树的高度次；
 *                可能的话会一直递归下去，因为是完全二叉树，所以最多有lgn层，也就最多产生lgn的时间
 *
 *            2.2、插入一个元素是先插入到数组最后一个元素，然后从下往上调整堆结构。
 *
 *            3、取n次，就得到了排序的数组。
 *
 *            所以时间成本O（nlgn）、空间成本O（n）
 *
 *
 */


public class G_HeapSort {
    // 下面以小顶堆为例写一下堆的两个常用操作
    // 更改了堆顶值，从上往下调整堆结构
    public void shiftDown(int[] h, int size, int u) {
        int t = u, left = u * 2, right = u * 2 + 1;
        if (left <= size && h[left] < h[t]) t = left;
        if (right <= size && h[right] < h[t]) t = right;
        if (t != u) {
            // swap(h[t], h[u]); 交换两个元素
            shiftDown(h, size, t);
        }
    }

    // 更改了堆最后一个元素值，从下往上调整堆结构
    public void shiftUp(int[] h, int u) {
        while ((u >> 1) > 0 && h[u >> 1] > h[u]) {
            // swap(h[u >> 1], h[u]); 交换两个元素
            u >>= 1;
        }
    }

    // 在最后一个下标插入一个新的值
    public void offer(int[] h, int size, int x) {
        h[ ++ size] = x;
        shiftUp(h, size);
    }

    // 删除堆顶元素
    public int poll(int[] h, int size) {
        int tmp = h[1];
        h[1] = h[size --];
        shiftDown(h, size,  1);

        return tmp;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> h = new PriorityQueue<>();
    }
}
