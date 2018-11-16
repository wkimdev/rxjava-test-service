package kr.co.doublechain.rx.service.sending.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import kr.co.doublechain.rx.service.SenderHistoryService;
import kr.co.doublechain.rx.service.sending.domain.TransferHistory;
import reactor.core.publisher.Mono;

/**
 * 
 * created by wkimdev
 *
 */
@Component
public class SenderHistoryHandler {
	
	@Autowired
	SenderHistoryService senderHistoryService;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		Mono<List<TransferHistory>> list = senderHistoryService.getTransferHistoryList();
		ParameterizedTypeReference<List<TransferHistory>> typeReference = new ParameterizedTypeReference<List<TransferHistory>>() {};
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(list, typeReference);
	}

}
