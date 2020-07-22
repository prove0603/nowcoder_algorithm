package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/21 10:53
 */

/*
    题目描述
        请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
        每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
        如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
        例如
        矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
        因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
        路径不能再次进入该格子。
        https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&&tqId=11218&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class JZ65 {
    //    注意回溯
    public static char arr[][];
    public static int helper[][];
    public boolean flag;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        arr = new char[rows][cols];
        helper = new int[rows][cols];
        flag = false;
        int matrixIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = matrix[matrixIndex];
                matrixIndex++;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                f(i, j, str, 0, rows, cols);
            }
        }
        return flag;
    }

    public void f(int x, int y, char[] str, int index, int rows, int cols) {
        if (x >= rows || x < 0) return;
        if (y >= cols || y < 0) return;
        if (helper[x][y] == 1) return;
        helper[x][y] = 1;
        if (arr[x][y] == str[index]) {
            if (index == str.length - 1) {
                flag = true;
                return;
            }
            f(x + 1, y, str, index + 1, rows, cols);
            f(x - 1, y, str, index + 1, rows, cols);
            f(x, y + 1, str, index + 1, rows, cols);
            f(x, y - 1, str, index + 1, rows, cols);
            helper[x][y] = 0;
        }
        helper[x][y] = 0;
    }

    public static void main(String[] args) {
        JZ65 jz65 = new JZ65();
        char list[] = new String("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS").toCharArray();
        System.out.println(jz65.hasPath(list, 5, 8, "SLHECCEIDEJFGGFIE".toCharArray()));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(arr[i][j] + "");
            }
            System.out.println();
        }
    }
}
