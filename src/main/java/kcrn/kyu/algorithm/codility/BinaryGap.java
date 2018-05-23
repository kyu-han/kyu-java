package kcrn.kyu.algorithm.codility;

import java.math.BigInteger;

public class BinaryGap {

	public int solution(int N) {
		
		BigInteger bi = new BigInteger(String.valueOf(N));
		String str = bi.toString(2);
		
		int result = 0;
		int temp = 0; 
		
		for(int i=0; i<str.length(); i++) {
			
			if (str.charAt(i) == '0') {
				temp++;
			} else {
				if(result < temp) {
					result = temp;					
				}
				temp = 0;
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		
		BinaryGap bg = new BinaryGap();
		System.out.println(bg.solution(561892));

	}

}
