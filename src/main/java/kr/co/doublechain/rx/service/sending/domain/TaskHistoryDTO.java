package kr.co.doublechain.rx.service.sending.domain;

import java.util.Date;

import lombok.Data;

/**
 * TransferHistoryDTO
 * created by basquiat
 *
 */
@Data
public class TaskHistoryDTO implements TaskHistory {
	
	/**
	 * task_id
	 */
	private Integer taskId;
	
	/**
	 * title
	 */
	private String title;
	
	/**
	 * start_date
	 */
	private Date startDate;
	
	/**
	 * due_date
	 */
	private Date dueDate;
	
	/**
	 * priority
	 */
	private Integer priority;
	
	
	/**
	 * description
	 */
	private String description;


	@Override
	public Integer taskId() {
		return this.taskId();
	}

	@Override
	public String title() {
		return this.title();
	}

	@Override
	public Date startDate() {
		return this.startDate();
	}

	@Override
	public Date dueDate() {
		return this.dueDate();
	}

	@Override
	public Integer priority() {
		return this.priority();
	}

	@Override
	public String description() {
		return this.description();
	}

		
}
