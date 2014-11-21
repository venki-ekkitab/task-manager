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

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public TaskEntry getTaskEntry() {
		return taskEntry;
	}

	public void setTaskEntry(TaskEntry taskEntry) {
		this.taskEntry = taskEntry;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public EXECUTION_STATUS getExecutionStatus() {
		return executionStatus;
	}

	public void setExecutionStatus(EXECUTION_STATUS executionStatus) {
		this.executionStatus = executionStatus;
	}
}
