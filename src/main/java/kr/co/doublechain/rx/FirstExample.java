package kr.co.doublechain.rx;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class FirstExample {
	
	public void emit(){
		/*
    	 * test 4 
    	 * subscribe에 실행할 메소드를 넣어주면 된다. 
    	 * 엄밀히 말하면 consumer, 파라미터가 한개인 void method
    	 */
        Observable.just("hello", "rxjava2!!")
            .subscribe(System.out::println);
    }
    public static void main(String[] args) throws Exception {
    	
    	/*
    	 * test 1 
    	 */
//        FirstExample firstExample = new FirstExample();
        //firstExample.emit();
        
        /*
    	 * test 2
    	 * 
    	 * Function 
    	 * Function<기존타입, 리턴타입> 
    	 */
//        Function<String, Integer> function = str -> Integer.parseInt(str);
//        Integer integer = function.apply("10");
//        System.out.println(integer);
        
        
        /*
    	 * test 3
    	 * 
    	 * Consume
    	 * // 매개변수 -> 함수 로직 (+@ 리턴)
    	 */
//        Observable<Integer> source = Observable.create((ObservableEmitter<Integer> emitter) -> {
//            emitter.onNext(100);
//            emitter.onNext(200);
//            emitter.onNext(300);
//            emitter.onComplete();
//         
//        });
//         
//        // 람다 + 메소드 레퍼런스
//        source.subscribe(System.out::println);
//         
//        // 그냥 코드(longer)
//        // consumer는 값을 받는 익명 void 함수
//        source.subscribe(new Consumer<Integer>() {
//        	
//            @Override
//            public void accept(Integer integer) throws Exception {
//                System.out.println("result : " + integer);
//            }
//        });
        
        /*
    	 * test 5
    	 */
//        Observable<String> source2 = Observable.just("singleFromObservavle");
//        Single.fromObservable(source2).subscribe(System.out::println);
        
        /*
    	 * test 6
    	 */
        Observable<String> source2 = Observable.just("singleFromObservable", "hello");
        Single.fromObservable(source2).subscribe(System.out::println);
    	
    }
	
}
