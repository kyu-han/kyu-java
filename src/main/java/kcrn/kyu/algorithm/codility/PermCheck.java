package kcrn.kyu.algorithm.codility;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

	
	
    public int solution(int[] A) {
    	
    	long sum = 0;
    	Set<Integer> set = new HashSet<Integer>();
    	
    	for(int i=0; i<A.length; i++) {    	
    		 sum += A[i];
    		 set.add(A[i]);
    	}
    	
    	long ans = ((long)(1 +  A.length) * A.length / 2);
    	
    	if(A.length == set.size()) {
    		return ans==sum?1:0;	
    	} else {
    		return 0;
    	}
    	
		        
        
    }
	
	
	public static void main(String[] args) {

		int[] A = {1,4,1};
		
		PermCheck pc = new PermCheck();
		System.out.println(pc.solution(A));
		

	}

}


