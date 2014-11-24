/**
 * 
 */
package org.task.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Calendar;

/**
 * Stands for the execution being performed. Comes into being when the
 * corresponding task entry is queued for execution.
 * This is a record of having tried and possibly completed or failed execution
 * Multiple task execution entries are possible for task entry,
 * when there are RE-RUNS, FAILED executions
 *   
 * @author venki
 *
 */
public class TaskExecutionEntry implements Externalizable {

	private Long key; //unique key for the entry	
	private TaskEntry taskEntry; //entry for which this is an execution
	private Calendar startTime;
	private Calendar endTime;
	private EXECUTION_STATUS executionStatus;
	
	public TaskExecutionEntry() {} //used only by serializer
	
	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 * @return
	 */
	public Long getKey() {
		return key;
	}
	/**
	 * 
	 * @param key
	 */
	public void setKey(Long key) {
		this.key = key;
	}
	/**
	 * 
	 * @return
	 */
	public TaskEntry getTaskEntry() {
		return taskEntry;
	}
	/**
	 * 
	 * @param taskEntry
	 */
	public void setTaskEntry(TaskEntry taskEntry) {
		this.taskEntry = taskEntry;
	}
	/**
	 * 
	 * @return
	 */
	public Calendar getStartTime() {
		return startTime;
	}
	/**
	 * 
	 * @param startTime
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	/**
	 * 
	 * @return
	 */
	public Calendar getEndTime() {
		return endTime;
	}
	/**
	 * 
	 * @param endTime
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	/**
	 * 
	 * @return
	 */
	public EXECUTION_STATUS getExecutionStatus() {
		return executionStatus;
	}
	/**
	 * 
	 * @param executionStatus
	 */
	public void setExecutionStatus(EXECUTION_STATUS executionStatus) {
		this.executionStatus = executionStatus;
	}
}
