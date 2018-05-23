package kcrn.kyu.algorithm.sort;

public class insert {

    static final int MAX = 100000;


    public static void main(String[] args) {

        int[] sample = new int[MAX];

        for(int i = 0; i<sample.length; i++ ) {
            sample[i] = (int) (Math.random() * MAX);
        }

//		for(int sam : sample) System.out.println(sam);

        long start = System.currentTimeMillis();


        for(int i = 1; i < sample.length; i++) {
            int position = i;
            for(int j = i-1; j >= 0; j--) {
                if(sample[j] > sample[position]) {
                    int temp = sample[position];
                    sample[position] = sample[j];
                    sample[j] = temp;
                    position--;
                } else {
                    break;
                }
            }

        }

        System.out.println("total time : "+(System.currentTimeMillis() - start) / 1000 +"(sec)");

//		System.out.println("===============================");

//		for (int result :  sample) System.out.println(result);

    }

}
