package algorithm.Aleetcode5_DFS和回溯.leetcode37;

public class Test {
    public static void main(String[] args) {
        // c<'10' 会报错？？
//        for(char c='3'; c<='9'; c++) {
//            System.out.println(c);
//            System.out.println(c=='6');
//        }
        
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
//        for(int m=(3/3)*3; m<(3/3)*3+3; m++) {
//            for(int n = (5/3)*3; n<(5/3)*3 +3; n++) {
//                System.out.println(m);
//                System.out.print(n);
//                System.out.println("-----");
//            }
//        }

        char c = '4';
        System.out.println(c);
    }
}
