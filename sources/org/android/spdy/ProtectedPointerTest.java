package org.android.spdy;

import org.android.spdy.ProtectedPointer;

public class ProtectedPointerTest {

    public static class Data {

        /* renamed from: i  reason: collision with root package name */
        private int f8625i = 0;

        public void destroy() {
            System.out.println("destroy");
            this.f8625i = 1;
        }

        public void work() {
            System.out.println("work");
            if (this.f8625i == 1) {
                System.exit(-1);
            }
        }
    }

    public static void main(String[] strArr) {
        ProtectedPointer protectedPointer = new ProtectedPointer(new Data());
        protectedPointer.setHow2close(new ProtectedPointer.ProtectedPointerOnClose() {
            public void close(Object obj) {
                ((Data) obj).destroy();
            }
        });
        test_close_with_work(protectedPointer);
    }

    public static void test_close_anywhere1(ProtectedPointer protectedPointer) {
        if (protectedPointer.enter()) {
            protectedPointer.release();
            ((Data) protectedPointer.getData()).work();
            protectedPointer.exit();
        }
    }

    public static void test_close_with_work(final ProtectedPointer protectedPointer) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i10 = 0; i10 < 1000; i10++) {
                    if (protectedPointer.enter()) {
                        ((Data) protectedPointer.getData()).work();
                        protectedPointer.exit();
                    } else {
                        System.out.println("the data has been destroy");
                    }
                }
            }
        });
        new Thread(new Runnable() {
            public void run() {
                protectedPointer.release();
            }
        }).run();
        thread.run();
    }

    public static void test_sequece(ProtectedPointer protectedPointer) {
        protectedPointer.release();
    }
}
