package kr.co.doublechain.rx.service.sending.domain;

import java.util.Date;

import org.davidmoten.rx.jdbc.annotations.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * TransferHistoryVO
 * created by basquiat
 *
 */
@JsonDeserialize(as = TaskHistoryDTO.class)
@JsonPropertyOrder({"taskId", "title", "startDate", "dueDate", "priority", "description"})
public interface TaskHistory {

	/**
	 * task_id
	 */
	@JsonProperty("taskId")
	@Column("task_id")
	Integer taskId();

	/**
	 * title
	 */
	@JsonProperty("title")
	@Column("title")
	String title();
	
	/**
	 * start_date
	 */
	@JsonProperty("startDate")
	@Column("start_date")
	Date startDate();
	
	/**
	 * due_date
	 */
	@JsonProperty("dueDate")
	@Column("due_date")
	Date dueDate();
	
	/**
	 * priority
	 */
	@JsonProperty("priority")
	@Column("priority")
	Integer priority();
	
	/**
	 * description
	 */
	@JsonProperty("description")
	@Column("description")
	String description();
	
}
