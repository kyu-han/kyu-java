package kcrn.kyu.algorithm.codility;

public class TapeEquilibrium {

	
    public int solution(int[] A) {
    	
    	int max  = 0;
    	int temp = 0;
    	int val = 100000; 
    	
    	if(A.length > 0) {	
        	for(int no : A) max += no;
        	
        	for(int i=0; i<A.length-1; i++) {    		
        		temp = A[i]*2;      
        		val = Math.min(val, Math.abs(max-temp));
        		max = max-temp;
        	}
    	} else val = 0;    	
    	
		return Math.abs(val);

    }
	
	public static void main(String[] args) {

		int[] A = {-3,1,-2,4,3, 7, -2};
		
		TapeEquilibrium teb = new TapeEquilibrium();
		
		System.out.println(teb.solution(A));
		

	}

}
