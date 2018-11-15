package kr.co.doublechain.rx;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaBackpressure {
	
	public static void main(String[] args) {
		Observable.range(1, 999_999_999)
				.map(MyItem::new)
				.observeOn(Schedulers.io()) //? 다운 스트림 쓰레드 적용
				.subscribe(myItem -> {
					sleep(50);
					System.out.println("Received MyItem : " + myItem.id);
		});
		
		sleep(Integer.MAX_VALUE); //? 다운 스트림 쓰레드 적용
	}
	
	static void sleep(long millseconds) {
		try {
			Thread.sleep(millseconds);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	} 
	
	static final class MyItem {
		final int id;

		MyItem(int id) {
			this.id = id;
			System.out.println("Constructing MyItem " + id);
		}
	}


}
