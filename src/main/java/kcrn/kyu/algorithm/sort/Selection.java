package kcrn.kyu.algorithm.sort;

public class Selection {

    static final int MAX = 100000;

    public static void main(String[] args) {

        int[] sample = new int[MAX];

        for (int i = 0; i < sample.length; i++) {
            sample[i] = (int) (Math.random() * MAX);
//			System.out.println(sample[i]);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < sample.length - 1; i++) {
            int position = i;
            for (int j = i + 1; j < sample.length; j++) {
                if (sample[position] > sample[j]) {
                    position = j;
                }
            }

//			sample[i] ^= sample[position];
//			sample[position] ^= sample[i];
//			sample[i] ^= sample[position];

            int temp = sample[i];
            sample[i] = sample[position];
            sample[position] = temp;

        }

        System.out.println("total time : " + (System.currentTimeMillis() - start) / 1000 + "(sec)");

//		System.out.println("===============================");

//		for (int result :  sample) System.out.println(result);


    }
}
