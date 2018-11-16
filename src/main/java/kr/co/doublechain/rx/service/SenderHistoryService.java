package kr.co.doublechain.rx.service;

import java.util.List;

import org.davidmoten.rx.jdbc.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.reactivex.Flowable;
import kr.co.doublechain.rx.config.DatabaseConfig;
import kr.co.doublechain.rx.service.sending.domain.TransferHistory;

import org.springframework.web.reactive.function.server.ServerRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("SenderHistoryService")
public class SenderHistoryService {
	
	@Autowired
	private Database database;
	
	/**
	 * get TransferHistory List
	 * @return Mono<List<TransferHistory>>
	 */
	public Mono<List<TransferHistory>> getTransferHistoryList() {
		Flowable<TransferHistory> flowable = database.select("SELECT txid, user_uuid, coin_type, transfer_amt, received_address, send_dttm FROM TRANSFER_HISTORY")
												  .autoMap(TransferHistory.class);
	
		return Flux.from(flowable).collectList();
	}
	
}
