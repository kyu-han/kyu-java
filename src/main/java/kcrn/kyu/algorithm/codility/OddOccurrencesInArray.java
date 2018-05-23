package kcrn.kyu.algorithm.codility;

public class OddOccurrencesInArray {

	
    public int solution(int[] A) {
   
//    	Set<Integer> set = new HashSet<Integer>();
//    	
//    	for(int i : A){
//    		if(set.contains(i)){
//    			set.remove(i);
//    		}else {
//    			set.add(i);
//    		}
//    	}
//    	
//		return set.iterator().next();
    	
    	int temp = 0;
    	for(int i : A) {
    		temp = temp ^ i;    		
    	}
    	return temp;
      
    }
    
    
	public static void main(String[] args) {
		
		int[] A = {9, 3, 9, 3, 9, 7, 9};
		
		
		OddOccurrencesInArray ooia = new OddOccurrencesInArray();
		System.out.println(ooia.solution(A));

		
		
		
	}
    

}
