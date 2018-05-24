package kcrn.kyu.algorithm.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        String str[] = new String[testCase];

        for(int i=0; i<testCase; i++){
            str[i] = br.readLine();
        }

        top:for(int i=0; i<testCase; i++){

            Stack<String> stack = new Stack<>();

            for(int j=0; j<str[i].length(); j++){
                switch(str[i].charAt(j)) {
                    case '(' :
                        stack.push("()");
                        break;
                    case ')' :
                        if(!stack.empty()) stack.pop();
                        else {
                            System.out.println("NO");
                            continue top;
                        }
                        break;
                }
            }

            System.out.println(stack.size()==0?"YES":"NO");

        }

        br.close();

    }

}
