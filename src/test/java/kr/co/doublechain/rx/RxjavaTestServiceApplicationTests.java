package kr.co.doublechain.rx;

import static org.junit.Assert.assertTrue;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.davidmoten.rx.jdbc.Database;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import org.springframework.web.reactive.function.BodyInserters;

import io.reactivex.Observable;
import kr.co.doublechain.rx.service.sending.domain.TaskHistory;
import kr.co.doublechain.rx.service.sending.domain.TaskHistoryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RxjavaTestServiceApplicationTests {
	
	private static final String DRIVER = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource";
	private static final String URL = "jdbc:mysql://localhost:3306/testdb?autoReconnect=true";
	private static final String USER = "root";
	private static final String PW = "1234";
	
	Logger log = LoggerFactory.getLogger(RxjavaTestServiceApplicationTests.class);
	
	String result = "";
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	Database dataBase;
	
	// Simple subscription to a fix value
    //@Test
    public void returnAValue(){
        result = "";
        Observable<String> observer = Observable.just("Hello"); // provides datea
        observer.subscribe(s -> result=s); // Callable as subscriber
        assertTrue(result.equals("Hello"));
    }
	
    // db connection test
    // @Test
    public void testConnection() throws SQLException, ClassNotFoundException {
    		
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    // get list 
    //@Test
    public void getList() {
    	// 
    	ResponseSpec responseSpec = webTestClient.get()
    				 .uri("/test")
    				 .exchange() // 응답 받기
    				 //.expectStatus().isEqualTo(HttpStatus.NOT_FOUND); //?
					 .expectStatus().isOk();
    	System.out.println(responseSpec.returnResult(TaskHistory.class));
    	
    }
    
    @Test
    public void saveTest() throws ParseException {
    	
    	Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-03");
    	Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-04");
    	
    	TaskHistoryDTO taskHistoryDTO = new TaskHistoryDTO();
    	taskHistoryDTO.setTitle("this is titile");
    	taskHistoryDTO.setStart_date(date1);
    	taskHistoryDTO.setDue_date(date2);
    	taskHistoryDTO.setPriority(3);
    	taskHistoryDTO.setDescription("this is description");
    	
    	webTestClient.post()
					 .uri("/task/update")
					 .body(BodyInserters.fromObject(taskHistoryDTO))
					 .exchange()
					 .expectStatus().isOk();
    	
    }
    
    // what is this?
    //@Test
    public void httpMethodErrorTest() {
    	ResponseSpec responseSpec = webTestClient.post()
    											.uri("/task/update")
    											.exchange()
    											.expectStatus().isOk();
    	
    	ParameterizedTypeReference<List<TaskHistory>> typeReference = new ParameterizedTypeReference<List<TaskHistory>>() {};
		System.out.println(responseSpec.returnResult(typeReference));
    }
    
}
