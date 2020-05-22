package algorithm.Aleetcode10_数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 求两个升序区间数组的公共区间组成的数组
 * 比如：区间数组 1，[[4,8], [9,13], [15,21], [22,26], [30, 88]]
 *      区间数组 2，[[3,7], [11,13], [14,33]]
 *
 *      公共部分组成的区间数组为 [[4,7], [11, 13], [15,21], [22, 26], [30, 33]]
 *
 *
 * 这个题只需要弄清楚两个区间之间的重叠关系就好做了，两个区间的重叠关系可以又6种，2种交叉，两种包含，2种不交叉。
 */
public class GetIntersection {
    public static ArrayList<int[]> getIntersections(List<int[]> l1, List<int[]> l2) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        int i=0, j=0;
        while (i<l1.size() && j < l2.size()) {
            int[] tmp1 = l1.get(i);
            int[] tmp2 = l2.get(j);
            if (tmp1[0] < tmp2[0]) {
                if (tmp1[1] > tmp2[0] && tmp1[1] < tmp2[1]) {
                    result.add(new int[]{tmp2[0], tmp1[1]});
                    i++;
                } else if (tmp2[1] <= tmp1[1]) {
                    result.add(new int[]{tmp2[0], tmp2[1]});
                    j++;
                } else if (tmp1[1] <= tmp2[0]) {
                    i++;
                }
            } else {
                if (tmp1[0] < tmp2[1] && tmp2[1] < tmp1[1]) {
                    result.add(new int[]{tmp1[0], tmp2[1]});
                    j++;
                } else if (tmp1[1] <= tmp2[1]) {
                    result.add(new int[]{tmp1[0], tmp1[1]});
                    i++;
                } else if (tmp1[0] >= tmp2[1]) {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        list1.add(new int[]{4, 8});
        list1.add(new int[]{9, 13});
        list1.add(new int[]{15, 21});
        list1.add(new int[]{22, 26});
        list1.add(new int[]{30, 88});


        list2.add(new int[]{3, 7});
        list2.add(new int[]{11, 13});
        list2.add(new int[]{14, 33});

        ArrayList<int[]> res = getIntersections(list1, list2);
        for (int[] a : res) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

    }
}
