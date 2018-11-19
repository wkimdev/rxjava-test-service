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
	private Integer task_id;
	
	/**
	 * title
	 */
	private String title;
	
	/**
	 * start_date
	 */
	private Date start_date;
	
	/**
	 * due_date
	 */
	private Date due_date;
	
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
