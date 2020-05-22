package interview.tencent;

import java.util.*;

/**
 * 跪在了这个标准输入这
 * in.nextInt(), 不会读取后面的换行符,in.next()也是一样；
 * 需要用in.nextLine()，读取一整行并换行
 * 2 代表有几组数组      // 用 in.nextLine()
 * 4 代表这组数据有多少个操作  // 用 in.nextLine()
 * POP
 * POP
 * TOP
 * PUSH 1
 * 3
 * TOP
 * TOP
 * POP
 */
public class Interview1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<Integer>();

        int T = Integer.valueOf(in.nextLine());  //
        for (int i = 0; i < T; i ++) {
            int Q = Integer.valueOf(in.nextLine());
            for (int j = 0; j < Q; j ++) {
                String s = in.nextLine();
                // 因为可能有空字符串，要先去掉
                String[] strs = s.split(" ");
                if (strs.length == 1) {
                    if (strs[0].equals("TOP")) {
                        if (queue.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(queue.peek());
                        }
                    } else if (strs[0].equals("POP")) {
                        if (queue.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            queue.poll();
                        }
                    } else if (strs[0].equals("SIZE")) {
                        System.out.println(queue.size());
                    } else if (strs[0].equals("CLEAR")) {
                        queue.clear();
                    }
                } else {
                    queue.offer(Integer.valueOf(strs[1]));
                }

            }
        }
        in.close();
    }
}
