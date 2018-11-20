package kr.co.doublechain.rx.service.sending.handler;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import kr.co.doublechain.rx.service.SenderHistoryService;
import kr.co.doublechain.rx.service.sending.domain.TaskHistory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * webflux use handler instead controller
 * created by wkimdev
 *
 */
@Component
public class SenderHistoryHandler {
	
	@Autowired
	private SenderHistoryService senderHistoryService;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		Flux<TaskHistory> flux = senderHistoryService.getTransferHistoryList();
		//ParameterizedTypeReference<List<TaskHistory>> typeReference = new ParameterizedTypeReference<List<TaskHistory>>() {};
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, TaskHistory.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		// 여기서도 blocking 처리 가능. 하지만 앞에서 nonblocking 처리를 했기 때문에 비동기, 동기 맞지 않아서 에러남.
		// old
		Mono<Integer> result = request.bodyToMono(TaskHistory.class).flatMap(mapper -> senderHistoryService.insertTaskHistory(mapper));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, Integer.class);
		
		// body는 비동기 클래스로(mono) 지정된(publish) 애를 리턴받는다.
		// 응답의 본체를 지정된 비동기 {@code Publisher}로 설정하고 리턴함.
		// ok
		//return ServerResponse.ok().body(request.bodyToMono(String.class), String.class);
	}

}
