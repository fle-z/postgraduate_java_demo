package exam;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ali01 {
    static int year = 2014;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> listYear = new ArrayList<>();

    public static int getYearFib(int n){
        if(n < 0){
            return -1;
        }else if(n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            int res = getYearFib(n - 1) + getYearFib(n - 2);
            int index = listYear.indexOf(res);
            if(index < 0){
                listYear.add(res);
            }
            return res;
        }
    }
    static int getFib(int n) {
        year++;
        if (n < 0) {
            return -1;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 3;
        } else if (n == 3) {
            return 4;
        } else {
            int res = getFib(n - 2) + getFib(n - 3);
            int index = list.indexOf(res);
            if(index < 0){
                list.add(res);
            }
            return res;
        }
    }

    static String calculate(int m, int k) {
        list.add(2);list.add(3);list.add(4);
        System.out.println(getFib(m));
        System.out.println(list);
        listYear.add(2);listYear.add(1);listYear.add(1);
        getYearFib(5);
        System.out.println(listYear);
        return "";
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");

        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        System.out.println(calculate(m, k));

    }
}
