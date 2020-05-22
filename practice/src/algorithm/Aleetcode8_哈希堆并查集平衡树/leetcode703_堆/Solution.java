package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode703_堆;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  流数据中第 k 大的值：对数组中每添加一个值，就返回此时第 K 大的元素
 *
 *  len(数组) + 1 >= k，说明第一次添加值的时候可能 len + 1 = k,所以需要判断下长度是否是k
 *
 *  学习优先队列(小顶堆数据结构)
 *  添加一个元素：add、offer
 *  删除节点：remove、poll
 *  获取堆顶元素：peek
 */
class Solution {
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private int capacity;

    public Solution(int k, int[] nums) {
        // 构建一个小顶堆，大小为k，Java里用优先队列 PriorityQueue 来做
        this.capacity = k;

        if (nums.length < capacity) {
            for (int i=0; i<nums.length; i++) {
                minHeap.add(nums[i]);
            }

        } else {
            int count = capacity;
            for (int j=0; j<count; j++) {
                minHeap.add(nums[j]);
            }

            for (int z=count; z<nums.length; z++) {
                if (nums[z] > minHeap.peek()) {
                    minHeap.remove(minHeap.peek());
                    minHeap.add(nums[z]);
                }
            }
        }
    }

    public int add(int val) {
        if (capacity > minHeap.size()) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
//            minHeap.remove(minHeap.peek());
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
