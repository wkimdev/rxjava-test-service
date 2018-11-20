package kr.co.doublechain.rx.service;

import java.util.List;

import org.davidmoten.rx.jdbc.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Flowable;
import kr.co.doublechain.rx.service.sending.domain.TaskHistory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("SenderHistoryService")
public class SenderHistoryService {
	
	@Autowired
	private Database database;
	
	/**
	 * get TransferHistory List
	 * @return Mono<List<TransferHistory>>
	 * @desc 원래 리턴은 Mono<List<TransferHistory>> 이었으나, Flux<TransferHistory>로 처리 가능함.
	 */
	public Flux<TaskHistory> getTransferHistoryList() {
		Flowable<TaskHistory> flowable = database.select("SELECT task_id, title, start_date, due_date, priority, description FROM tasks")
									 	.autoMap(TaskHistory.class);
		System.out.println(flowable.toList());
		return Flux.from(flowable);
	}
	
	public Mono<Integer> insertTaskHistory(TaskHistory taskHistory) {
		//Flowable<Integer> flowable = database.update("INSERT INTO tasks(title, start_date, due_date, priority, description) values (?, now(), ?, ?, ?)")
		Flowable<Integer> flowable = database.update("INSERT INTO tasks(title, description) values (?, ?)")
											.parameters(taskHistory.title(),
													taskHistory.description())
											.counts()
											.doOnError(throwable -> {
				  						          throw new RuntimeException("unexcepted");
				  						      });
		return Mono.from(flowable);
	} 
	
	
}
