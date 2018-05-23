package kcrn.kyu.algorithm.codility;

public class CyclicRotation {
	
	
    public int[] solution(int[] A, int K) {
    	 
    	if(A.length == 0) return A;
    	
    	int[] B = new int[A.length];
    	
    	int realLen = K % A.length;
    	
    	int cnt = 0;
    	
    	for(int i = A.length-realLen; i< A.length; i++) {
    		B[cnt++] = A[i];
    	}
    	
    	for(int i = 0; i< A.length-realLen; i++) {
    		B[cnt++] = A[i];
    	}	
    	
		return B;
    }
	
	
	

	public static void main(String[] args) {
		
		
		int[] A = {-10,0,9,7,1000};
		
		
		CyclicRotation bg = new CyclicRotation();
		for(int ans : bg.solution(A, 99)) {
			System.out.println(ans);
		}

	}

	
	

}
