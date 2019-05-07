package exam.nowcoder;

import java.util.Arrays;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if (len == 0)
            return  0;
        int head = 0, tail = len - 1;
        int res = Integer.MAX_VALUE;
        while (head < tail){
            if (array[head] != array[tail]){
                int mid = (head + tail) / 2;
                if(array[mid] > array[tail]){
                    head = mid + 1;
                } else {
                    tail = mid;
                }
                res = array[tail];
            } else {
                for (int i = head; i < tail; i++){
                    if(array[i] < res)
                        res = array[i];
                }

                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        MinNumberInRotateArray m = new MinNumberInRotateArray();
        System.out.println(m.minNumberInRotateArray(array));
    }
}
