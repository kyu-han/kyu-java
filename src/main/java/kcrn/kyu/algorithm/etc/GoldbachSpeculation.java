package kcrn.kyu.algorithm.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoldbachSpeculation {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int caseTest = sc.nextInt();
        int max = 20000;
        boolean[] delete = new boolean[max+1];
        List<Integer> list = new ArrayList<>();

        for(int j=2; j<=max; j++){
            if(!delete[j]) list.add(j);
            for(int k=j*j; k<=max; k+=j){
                delete[k] = true;
            }
        }

        int[] input = new int[caseTest];

        for(int i = 0; i < caseTest; i++){
            input[i] = sc.nextInt();
        }

        for(int i = 0; i < caseTest; i++){
            String anwser = "";
            int diffrence = 10007;
            int end = 0;
            for(int m =0; m < list.size(); m++){
                if(input[i]/2 <= list.get(m)){
                    end = m;
                    break;
                }
            }

            for(int j=0; j<=end;j++) {
                for(int k=end; k<=end*2; k++){
                    if(list.get(j)+list.get(k) == input[i]) {
                        if(diffrence > list.get(k)-list.get(j)) {
                            diffrence = list.get(k)-list.get(j);
                            anwser = list.get(j)+" "+list.get(k);
                        }
                    }
                }
            }
            System.out.println(anwser);
        }
    }

}
