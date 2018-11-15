package kr.co.doublechain.rx;

import java.util.Arrays;

import io.reactivex.Flowable;

public class DoOnError {
	
	public void run5() {
        Flowable.fromIterable(Arrays.asList(1, 2, 0))
                .doOnComplete(() -> System.out.println("completed 5"))
                .map(item -> {
                    return 10 / item;
                })
                .doOnNext(System.out::println)
                .subscribe();
    }
	
	/**
	 * 10	
		5
		io.reactivex.exceptions.OnErrorNotImplementedException: / by zero
		발행중 에러가 나는 경우. 
	 * 
	 */
    public static void main(String[] args) {
        new DoOnError().run5();
    }
    
}
