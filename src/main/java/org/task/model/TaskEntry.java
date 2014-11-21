/**
 * 
 */
package org.task.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author venki
 *
 */
public  class TaskEntry implements Externalizable {

	private Long key; //unique key for the entry
	private Calendar submitTime; //when was it submitted for execution
	private List<TaskExecutionEntry> executions;
	private Map<String , Externalizable> params; //only externalizable params supported
	private Task task;
	
	public TaskEntry() {} //used only by serializer
	
	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}
	public EXECUTION_STATUS getExecutionStatus() {
		//TODO return from the status of - TaskExecutionEntry
		return null;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public Calendar getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Calendar subTime) {
		this.submitTime = subTime;
	}
	public List<TaskExecutionEntry> getExecutions() {
		return executions;
	}
	public void setExecutions(List<TaskExecutionEntry> executions) {
		this.executions = executions;
	}

	public Map<String, Externalizable> getParams() {
		return params;
	}
	public TaskEntry setParam(String param, Externalizable value) {
		if(params == null) {
			this.params = new HashMap<String, Externalizable>();
		} else {
			this.params.put(param, value);
		}
		return this; //for chaining
	}
	public void setParams(Map<String, Externalizable> aParams) {
		if(aParams != null) {
			this.params = new HashMap<String, Externalizable>(aParams);
		} else {
			this.params = null;
		}
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	public Map<String,TaskEntry> getPredecessaorTaskEntries() {
		//TODO: return based on task predecessors
		return null;
	}
	public Map<String,TaskEntry> getSuccessorTaskEntries() {
		//TODO: return based on task successors
		return null;
	}
}
