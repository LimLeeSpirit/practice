package algorithm.Aleetcode8_哈希堆并查集平衡树;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 在 20 个降序数组中，每个数组长度 50，找出最大的 50 个数
 * topK 的变种，这里是 20 个有序数组。
 *
 * 比如 nums = {{29, 17, 14, 2, 1, -21, -23, -53, -56, -90},
 *             {89, 67, 33, 23, 19, 19, 17, 16, 15, 6},
 *             {44, 43, 40, 33, 32, 30, 25, 20, 14, 5}};
 *
 *             k = 5；返回 89 67 44 43 40
 *
 *
 * 方法：从降序入手，先将数组的第一个值放入大顶堆，最大的在第一位
 *      再将大顶堆第一个删除，并保存在结果数组中，将该元素值所在的数组的下一位加入大顶堆。
 *      重复上一步，直到获得所有 k 个最大值。
 *
 *      time：O（k lgk）
 *      这里的处理思想非常牛逼！这才是面向对象编程，你在程序中需要一个重要的步骤：找到从大顶堆出来的那个元素所在的数组。
 *      这一步如果处理是非常麻烦的，既然要在后面找到这样的步骤，为什么不在加入堆的时候就把元素来源也加进去呢？所以声明一个类
 *      DataWithSource 保存值，来源和下标！就是一个结构体对吧！
 */
class DataWithSource implements Comparable<DataWithSource> {
    private int value;
    private int source;
    private int index;

    public DataWithSource(int value, int source, int index) {
        this.value = value;
        this.source = source;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(DataWithSource o) {
        if (this.value > o.value) {
            return -1;
        } else if (this.value < o.value) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class GetTopK_堆 {
    public static int[] getTopK(int[][] nums, int k) {
        if (nums == null | nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int row = nums.length;
        int[] tops = new int[k];

        // 默认是小顶堆，大顶堆需要手动加入比较器
        PriorityQueue<DataWithSource> heap = new PriorityQueue<>(new Comparator<DataWithSource>() {
            @Override
            public int compare(DataWithSource o1, DataWithSource o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < row; i ++) {
            DataWithSource dataWithSource = new DataWithSource(nums[i][0], i, 0);
            heap.offer(dataWithSource);
        }

        int cnt = 0;
        while (cnt < k) {
            DataWithSource tmp = heap.poll();
            int idx = tmp.getIndex();

            tops[cnt ++] = tmp.getValue();

            tmp.setIndex(idx + 1);
            tmp.setValue(nums[tmp.getSource()][idx + 1]);
            System.out.printf("来源：%s，下标：%s，新加的值：%s",tmp.getSource(), tmp.getIndex(), tmp.getValue());
            System.out.println();
            heap.offer(tmp);
        }
        return tops;
    }

    public static void main(String[] args) {
        int[][] nums = {{29, 17, 14, 2, 1, -21, -23, -53, -56, -90},
                        {89, 67, 33, 23, 19, 19, 17, 16, 15, 6},
                        {44, 43, 40, 33, 32, 30, 25, 20, 14, 5}};
        int[] res = getTopK(nums, 10);
        for (int a : res) {
            System.out.printf(a + " ");
        }
    }
}
