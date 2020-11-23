package hw5;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        arrOneThread();
        System.out.println(System.currentTimeMillis() - a + "ms");

        a = System.currentTimeMillis();
        arrTwoThread();
        System.out.println(System.currentTimeMillis() - a + "ms");

    }

    static void arrOneThread() {
        for (int i = 1; i < SIZE; i++) {
            arr[i] = (float) (arr[i - 1] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    static void arrTwoThread() {
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < HALF; i++) {
                    a1[i] = (float) (a1[i - 1] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < HALF; i++) {
                    a2[i] = (float) (a2[i - 1] * Math.sin(0.2f + (5000000 + i) / 5) *
                            Math.cos(0.2f + (5000000 + i) / 5) * Math.cos(0.4f + (5000000 + i) / 2));
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

    }
}
