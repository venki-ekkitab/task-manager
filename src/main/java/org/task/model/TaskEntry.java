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
 * Task entry is a request to execute the task for a set of parameter values.
 * Task entries are normally queued and they are picked-up by the 'workers' for execution.
 * Each task entry will have at least one execution entry, when it is attempted.
 * There may be multiple execution when a task entry retried.
 *  
 * @author venki
 *
 */
public  class TaskEntry implements Externalizable {

	private Long key; //unique key for the entry
	private Calendar submitTime; //when was it submitted for execution
	private List<TaskExecutionEntry> executions;
	private Map<String , Externalizable> params; //only externalizable params supported
	private Task task;
	private Map<Long,Resource> inputResources;
	private Map<Long,Resource> outputResources;
	
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
	/**
	 * get over all execution status
	 * @return
	 */
	public EXECUTION_STATUS getExecutionStatus() {
		//TODO return from the status of - TaskExecutionEntry
		return null;
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
	public Calendar getSubmitTime() {
		return submitTime;
	}
	/**
	 * 
	 * @param subTime
	 */
	public void setSubmitTime(Calendar subTime) {
		this.submitTime = subTime;
	}
	/**
	 * 
	 * @return
	 */
	public List<TaskExecutionEntry> getExecutions() {
		return executions;
	}
	/**
	 * 
	 * @param executions
	 */
	public void setExecutions(List<TaskExecutionEntry> executions) {
		this.executions = executions;
	}
	/**
	 * 
	 * @return
	 */
	public Map<String, Externalizable> getParams() {
		return params;
	}
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public Externalizable getParam(String paramName) {
		if(params != null) {
			return params.get(paramName);
		} else {
			return null;
		}
	}
	/**
	 * 
	 * @param param
	 * @param value
	 * @return
	 */
	public TaskEntry setParam(String param, Externalizable value) {
		if(params == null) {
			this.params = new HashMap<String, Externalizable>();
		}
		this.params.put(param, value);
		return this; //for chaining
	}
	/**
	 * 
	 * @param aParams
	 */
	public void setParams(Map<String, Externalizable> aParams) {
		if(aParams != null) {
			this.params = new HashMap<String, Externalizable>(aParams);
		} else {
			this.params = null;
		}
	}
	/**
	 * 
	 * @param aResource
	 * @return
	 */
	public TaskEntry setInputResource(Resource aResource) {
		if(aResource == null) {
			throw new IllegalArgumentException("resouce can not be null");
		}
		if(inputResources == null) {
			this.inputResources = new HashMap<Long, Resource>();
		}
		this.inputResources.put(aResource.getKey(), aResource);
		return this; //for chaining
	}
	/**
	 * 
	 * @param aInputs
	 */
	public void setInputResources(Map<Long, Resource> aInputs) {
		if(aInputs != null) {
			inputResources = new HashMap<Long, Resource>(aInputs);
		} else {
			inputResources = null;
		}
	}
	/**
	 * 
	 * @param aResource
	 * @return
	 */
	public TaskEntry setOutputResource(Resource aResource) {
		if(aResource == null) {
			throw new IllegalArgumentException("resouce can not be null");
		}
		if(outputResources == null) {
			this.outputResources = new HashMap<Long, Resource>();
		}
		this.outputResources.put(aResource.getKey(), aResource);
		return this; //for chaining
	}
	/**
	 * 
	 * @param aOutputs
	 */
	public void setOutputResources(Map<Long, Resource> aOutputs) {
		if(aOutputs != null) {
			this.outputResources = new HashMap<Long, Resource>(aOutputs);
		} else {
			this.outputResources = null;
		}
	}
	/**
	 * 
	 * @return
	 */
	public Task getTask() {
		return task;
	}
	/**
	 * 
	 * @param task
	 */
	public void setTask(Task task) {
		this.task = task;
	}
	/**
	 * 
	 * @return
	 */
	public Map<String,TaskEntry> getPredecessaorTaskEntries() {
		//TODO: return based on task predecessors
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public Map<String,TaskEntry> getSuccessorTaskEntries() {
		//TODO: return based on task successors
		return null;
	}
}
