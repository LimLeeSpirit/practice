package algorithm.Aleetcode5_DFS和回溯.JZoffer24_宽搜;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 地上有一个 m 行和 n 列的方格，横纵坐标范围分别是 0∼m−1 和 0∼n−1。
 *
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。
 *
 * 但是不能进入行坐标和列坐标的 数位 之和大于 k 的格子。
 *
 * 请问该机器人能够达到多少个格子？
 *
 * 需要思考一下机器人如何运动，从 [0, 0] 开始，从可能的上下左右的位置一直走一直走，不断地统计格子数。
 *
 *
 * 题解：宽搜，不再需要找出所有情况了，所以不需要 递归，而且不需要倒回去，所以不需要 回溯
 *      仔细想想确实是宽搜就够了，因为需要在已经找到的那些符合要求的坐标的周围进行扩展。
 */
public class Solution {
    public int movingCount(int k, int x, int y)
    {
        if (x == 0 || y == 0) return 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] v = new boolean[x][y];
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.offer(new int[]{0, 0});

        int ret = 0;

        while (q.size() > 0) {
            int[] tmp = q.poll();
            if (v[tmp[0]][tmp[1]] || getDouble(tmp) > k) continue;
            v[tmp[0]][tmp[1]] = true;
            ret ++;

            for (int i = 0; i < 4; i ++) {
                int a = dx[i] + tmp[0];
                int b = dy[i] + tmp[1];
                if (0 <= a && a < x && 0 <= b && b < y) {
                    q.offer(new int[]{a, b});
                }
            }
        }

        return ret;
    }

    private int getSingle(int x) {
        int ret = 0;
        while (x > 0) {
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }

    private int getDouble(int[] pairs) {
        int ret = 0;
        for (int a : pairs) {
            ret += getSingle(a);
        }
        return ret;
    }
}
