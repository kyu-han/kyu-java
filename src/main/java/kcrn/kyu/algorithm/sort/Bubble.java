package kcrn.kyu.algorithm.sort;

public class Bubble {

    static final int MAX = 100000;

    public static void main(String[] args) {

        int[] sample = new int[MAX];

        for(int i = 0; i < MAX; i++ ) {
            sample[i] = (int) (Math.random() * MAX);
        }

//		for(int sam : sample) System.out.println(sam);

        long start = System.currentTimeMillis();

        for(int i = 0; i < sample.length; i++) {
//			int position = i;
            for(int j = 1; j < sample.length-i; j++) {
                if(sample[j-1] > sample[j]) {
                    int temp = sample[j-1];
                    sample[j-1] = sample[j];
                    sample[j] = temp;
                }
//				position++;
            }
        }

        System.out.println("total time : "+(System.currentTimeMillis() - start) / 1000 +"(sec)");

//		System.out.println("===============================");

//		for (int result :  sample) System.out.println(result);


    }

}
