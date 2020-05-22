package interview.tencent;

import java.util.LinkedList;
import java.util.Scanner;

public class Interview3 {
    public static void main(String[] args) {
        myQueue q = new myQueue();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N + 1; i ++) {
            String[] strs = in.nextLine().split(" ");
            if (strs.length > 1) {
                q.push(Integer.valueOf(strs[1]));
            } else {
                if (strs[0].equals("peek")) {
                    System.out.println(q.peek());
                } else if (strs[0].equals("poll")) {
                    q.pop();
                }
            }
        }
    }
}
class myQueue {
    LinkedList<Integer> stk1;
    LinkedList<Integer> stk2;
    public myQueue() {
        stk1 = new LinkedList<Integer>();
        stk2 = new LinkedList<Integer>();
    }
    public void push(int x) {
        stk1.push(x);
    }

    public int pop() {
        if (!stk2.isEmpty()) return stk2.pop();
        while (!stk1.isEmpty()) stk2.push(stk1.pop());
        return stk2.pop();
    }

    public int peek() {
        if (!stk2.isEmpty()) return stk2.peek();
        while (!stk1.isEmpty()) stk2.push(stk1.pop());
        return stk2.peek();
    }
}

