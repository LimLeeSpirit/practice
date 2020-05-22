package algorithm.Aleetcode10_数组.位运算.leetcode136_has1;

/**
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 *  找出那个只出现了一次的元素。
 */
public class singleNumber {
    public static int findNotDouble(int[] a) {
        // 位运算： &、|、～、^，与、或、非、异或
        // 这里就用到了异或运算：相同的时候为0，不同的时候为1，
        int n = a.length;
        int res = a[0];
        int i;
        // 通过一直异或下去，那些double的就变为0，最后就剩下那个单着的了。
        for (i = 1; i < n; i++) {
            res ^= a[i];
            System.out.println(res);
        }
        return res;
    }

    public int findNotDouble2(int[] nums) {
        // 这种方法只有在 1 ≤ a[i] ≤ n ( n = 数组大小 )的时候才能用。
        int n = nums.length, res=0;
        for (int i = 0; i < n; i++) {
            int a = (nums[i] - 1) % n;
            nums[a] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 2 *  n) {
                res = i+1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,4,3,5,4,1};
        System.out.println(findNotDouble(a));
    }
}
