package kcrn.kyu.algorithm.etc;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < testCase; i++) set.add(sc.next());
        lengthSort(set.toArray(new String[0]));
    }

    public static void lengthSort(String[] strs){
        for(int k=1 ; k<=50; k++){
            for(String str : strs){
                if(str.length() == k) System.out.println(str);
            }
        }
    }
}
