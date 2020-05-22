package algorithm.Aleetcode10_数组.数组交集.leetcode350_数组交集II;

/**
 * BSTIterator 里针对两个有序数组求交集的应用，
 * 这里是求三个 有序数组 的交集。
 *
 * 放到同一起跑线上，去比，看哪一个下标应该走。思路真好！
 */
public class FindCommonInThreeArrays {
    public static void findCommon(int[] arr1, int[] arr2, int[] arr3) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;
        int i=0, j=0, k=0;
        while (i<len1 && j<len2 && k<len3) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.println(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 5, 12, 20, 45, 85};
        int[] arr2 = {16, 19, 20, 85, 200};
        int[] arr3 = {3, 4, 15, 20, 39, 72, 85, 190};
        findCommon(arr1,arr2,arr3);

    }
}
