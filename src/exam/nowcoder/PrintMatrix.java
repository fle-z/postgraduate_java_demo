package exam.nowcoder;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(matrix.length==0) return result;
        int n = matrix.length; // 表示数组的行数
        int m = matrix[0].length; // 表示对应行的长度
        if(m==0) return result;
        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) result.add(matrix[i][k]);
            for (int j = i+1; j < n - i; j++) result.add(matrix[j][m-i-1]);
            for (int k = m-i-2; (k >= i) && (n-i-1 != i); k--) result.add(matrix[n-i-1][k]);
            for (int j = n-i-2; (j > i) && (m-i-1 != i); j--) result.add(matrix[j][i]);
        }

        return result;
    }
    static {
        System.out.println((int)Math.ceil(Math.min(1, 1) / 2));
    }

    public static void main(String[] args) {

    }
}
