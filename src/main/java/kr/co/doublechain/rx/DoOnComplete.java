package kr.co.doublechain.rx;

import io.reactivex.Flowable;

public class DoOnComplete {
	
	public void run() {
        String[] ar = {"a", "b"};
        // 없다 .subscribe();
        Flowable.fromArray(ar)
                .doOnComplete(() -> System.out.println("completed 1"));
    }
 
    public void run2() {
        String[] ar = {"a", "b"};
        Flowable.fromArray(ar)
                .doOnComplete(() -> System.out.println("completed 2"))
                .subscribe();
    }
 
    public void run3() {
        String[] ar = {};
        Flowable.fromArray(ar)
                .doOnComplete(() -> System.out.println("completed 3"))
                .subscribe();
    }
 
    public void run4() {
        Flowable.just("1")
                .doOnComplete(() -> System.out.println("completed 4"))
                .subscribe();
    }
 
    public static void main(String[] args) {
        new DoOnComplete().run();
        new DoOnComplete().run2();
        new DoOnComplete().run3();
        new DoOnComplete().run4();
    }
}
