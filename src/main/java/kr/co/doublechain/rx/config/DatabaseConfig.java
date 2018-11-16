package kr.co.doublechain.rx.config;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.pool.DatabaseType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 
 * created by wkimdev
 *
 */
@Component
@Configuration
public class DatabaseConfig {
	
	private Database database; //rxjava-jdbc
	
	public DatabaseConfig(@Value("$(datasource.url)") final String url,
							@Value("$(datasource.username)") final String user,
							@Value("$(datasource.password)") final String password,
							@Value("$(datasource.hikari.maximumPoolSize)") final String maxPoolSize) throws SQLException {
		// db를 non blocking 으로 설정.
		database = Database.nonBlocking()
							.url(url)
							.user(user) //error could not read
			    		    .password(password)
						 	.maxIdleTime(30, TimeUnit.MINUTES)
						 	.healthCheck(DatabaseType.MYSQL) //?
						 	.idleTImeBeforeHealthCheck(5, TimeUnit.SECONDS)
						 	.connectionRetryInterval(30, TimeUnit.SECONDS)
						 	.maxPoolSize(maxPoolSize)
						 	.build();
	}
	
	
	/*
	 * create bean database
	 * @return Database
	 */
	public @Bean Database database() {
		return this.database;
	}
	
	

}
