package kcrn.kyu.algorithm.codility;

public class FrogJmp {


	
    public int solution(int X, int Y, int D) {
    	    	    	
		return (int) Math.ceil((double)(Y-X) / D);
     
    }
	
	
	public static void main(String[] args) {

		
		
		FrogJmp fj = new FrogJmp();
		System.out.println(fj.solution(3, 999111321, 7));
		

	}

}
