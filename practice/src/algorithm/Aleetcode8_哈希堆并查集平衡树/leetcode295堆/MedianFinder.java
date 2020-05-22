package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode295堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找出动态数组流中的中位数，如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 这个题完美解法就是利用堆构成 对顶堆的形式，上面是倒放的小顶堆，下面是顺放的大顶堆，且保持下面的元素至多比上面少一个。
 * 所以如果是奇数，则直接返回上面的小顶堆的堆顶值，如果是偶数，则返回两个堆顶元素的均值。
 *
 * 注意运算符优先级：
 *      * /
 *      + -
 *      ==
 *      & ^  if ( (a + b & 1) == 1 )
 *      && ||
 *
 */
public class MedianFinder {

    // 默认小根堆，保存较大的一半
    PriorityQueue<Integer> up;

    // 大根堆，保存较小的一半
    PriorityQueue<Integer> down;

    /** initialize your data structure here. */
    public MedianFinder() {
        up = new PriorityQueue<>();

        // 添加比较器，形成大顶堆的逆序
        down = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
    }

    /**
     * 这个写法非常牛逼，怎样达到上面比下面 最多 多一个呢 ？ 首先，一个元素进来，如果大于下面顶元素，加在上面；
     * 否则，加在下面，加在下面的时候，先加在下面，再抽一个元素加在上面，目的就是每次都往上面加一个。然后，在上面比下面多2个的时候，
     * 就开始切换了
     * @param num 元素
     */
    public void addNum(int num) {
        if (down.isEmpty() || num >= down.peek()) up.offer(num);
        else {
            down.offer(num);
            up.offer(down.poll());
        }

        if (up.size() > (down.size() + 1)) {
            down.offer(up.peek());
            up.poll();
        }
    }

    public double findMedian() {
        if ((up.size() + down.size() & 1) == 1) {
            return (double)up.peek();
        }
        else return (up.peek() + down.peek()) / 2D;
    }
}
