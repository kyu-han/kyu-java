package kcrn.kyu.algorithm.codility;

import java.util.Arrays;

public class PermMissingElem {

    public int solution(int[] A) {
    	
    	Arrays.sort(A);
    	
    	for(int i=0; i<A.length; i++){
    		if(A[i] != i+1) return i+1;
    		if(i == A.length-1) return i+2;
    	}
    	
		return 1;

    }
	
	public static void main(String[] args) {

		int[] A = {1,4,3,2,5,6,7,8};
		
		PermMissingElem pme = new PermMissingElem();
		System.out.println(pme.solution(A));

	}
    

}
