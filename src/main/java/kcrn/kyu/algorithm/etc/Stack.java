package kcrn.kyu.algorithm.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stack {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String command = st.nextToken(" ");
                if("push".equals(command)){
                    push(Integer.parseInt(st.nextToken(" ")));
                }else if("pop".equals(command)){
                    pop();
                }else if("size".equals(command)){
                    size();
                }else if("empty".equals(command)){
                    empty();
                }else if("top".equals(command)){
                    top();
                }
            }
        }
    }

    public static void push(int num){
        list.add(num);
    }

    public static void top(){
        if(list.size()==0) System.out.println("-1");
        else System.out.println(list.get(list.size()-1));
    }

    public static void size(){
        System.out.println(list.size());
    }

    public static void empty(){
        System.out.println(list.size()==0?1:0);
    }

    public static void pop(){
        if(list.size()==0) System.out.println("-1");
        else {
            System.out.println(list.get(list.size()-1));
            list.remove(list.size()-1);
        }
    }

}
