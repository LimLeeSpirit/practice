package interview.others;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 利用字符串计算 + - * / 的改编版本
 *
 * 计算 boolean 算式
 *
 * 输入例子3:
 * true or false and false
 * 输出例子3:
 * true
 */
public class Interview13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strs = s.split(" ");
        LinkedList<String> stk = new LinkedList<>();

        for (int i = 0; i < strs.length; i ++) {
            String cur = strs[i];
            if (cur.equals("true") || cur.equals("false")) {
                if (i + 1 < strs.length && (strs[i + 1].equals("true") || strs[i + 1].equals("false"))) {
                    System.out.println("error");
                    return;
                }
                stk.push(cur);
            } else if (cur.equals("or")) {
                if (stk.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if (stk.peek().equals("and") || stk.peek().equals("or")) {
                    System.out.println("error");
                    return;
                }
                stk.push(cur);
            } else if (cur.equals("and")) {
                if (stk.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                String peek = stk.pop();
                if (i + 1 < strs.length) {
                    String next = strs[i + 1];
                    if (next.equals("or") || next.equals("and")) {
                        System.out.println("error");
                        return;
                    }
                    if (peek.equals("false")) {
                        stk.push("false");
                        i ++;
                    } else if (peek.equals("true")) {
                        if (next.equals("false")) {
                            stk.push("false");
                            i ++;
                        } else if(next.equals("true")) {
                            stk.push("true");
                            i ++;
                        }
                    } else {
                        System.out.println("error");
                        return;
                    }
                }

            }
        }

        // true true false 的情况
        for (int i = 1; i < stk.size(); ) {
            if (!stk.get(i).equals("or")) {
                System.out.println("error");
                return;
            }
            i += 2;
        }

        // 其余情况，有一个 true 就可以了
        for (String st : stk) {
            if (st.equals("true")) {
                System.out.println("true");
                return;
            }
        }

        // 没有一个true
        System.out.println("false");
    }
}
