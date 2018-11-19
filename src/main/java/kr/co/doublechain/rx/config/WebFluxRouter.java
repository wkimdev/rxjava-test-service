package kr.co.doublechain.rx.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import kr.co.doublechain.rx.service.sending.handler.SenderHistoryHandler;

/**
 * 
 * created by wkimdev
 *
 */
@EnableWebFlux
@Configuration
public class WebFluxRouter extends DelegatingWebFluxConfiguration {
	
	@Autowired
	SenderHistoryHandler senderHistoryHandler;
	
	// Method references help to point to methods by their names
	@Bean
	public RouterFunction<ServerResponse> senderHistoryRouter() {
		// could not call....
		return route(GET("/task/list").and(accept(APPLICATION_JSON)), senderHistoryHandler::findAll)
			  .andRoute(POST("/task/update").and(accept(APPLICATION_JSON)), senderHistoryHandler::save);
	}
	
}
