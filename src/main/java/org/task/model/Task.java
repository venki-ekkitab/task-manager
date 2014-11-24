/**
 * 
 */
package org.task.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * A task stands for template for unit of execution. As task can produce task instances (Task Entry)
 * - it has input parameters
 * - it has predecessor tasks
 * - it has a category - primarily used for searching and/or task executor allocating it to different hosts/thread-pools to execute
 * 
 * @author venki
 *
 */
public abstract class Task implements Externalizable {
	private Long key;
	private String category;
	private String name;
	private String description;
	private List<String> parameters;
	
	private Map<String,Task> predecessorTasks;
	private Map<String,Task> successorTasks;
	
	/**
	 * execute a given task entry. te.getTask() == this
	 * @param te - the information required to execute the task entry
	 * @return - true if the task task entry execution succeeds, false otherwise
	 * @throws ExecutionException
	 */
	public abstract boolean execute(TaskEntry te) throws ExecutionException;
	/**
	 * used by serialization
	 */
	protected Task() { } //use by subclasses for serialization
	/**
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}	
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
	 * 
	 * @return
	 */
	public List<String> getParameters() {
		return parameters;
	}
	/**
	 * 
	 * @param aParameters
	 */
	public void setParameters(List<String> aParameters) {
		if(aParameters == null) {
			this.parameters = null;
		} else {
			this.parameters = new ArrayList<String>(aParameters);
		}
	}
	/**
	 * 
	 * @return
	 */
	public Map<String, Task> getPredecessorTasks() {
		return predecessorTasks;
	}
	/**
	 * 
	 * @param aPredecessorTasks
	 */
	public void setPredecessorTasks(Map<String, Task> aPredecessorTasks) {
		if(aPredecessorTasks == null) {
			predecessorTasks = null;
		} else {
			this.predecessorTasks = new HashMap<String,Task>(aPredecessorTasks);
		}
	}
	/**
	 * 
	 * @return
	 */
	public Map<String, Task> getSuccessorTasks() {
		return successorTasks;
	}
	/**
	 * 
	 * @param aSuccessorTasks
	 */
	public void setSuccessorTasks(Map<String, Task> aSuccessorTasks) {
		if(this.successorTasks == null) {
			this.successorTasks = null;
		} else {
			this.successorTasks = new HashMap<String, Task>(aSuccessorTasks);
		}
	}
	/**
	 * Given a set of params the task knows how to create the entry which can be submitted to
	 * executor instance. 
	 * 
	 * @param aParams
	 * @return
	 */
	public abstract TaskEntry createTaskEntry(Map<String, Externalizable> aParams);
	/**
	 * 
	 * @return
	 */
	public Long getKey() {
		return key;
	}
	/**
	 * 
	 * @param aKey
	 */
	public void setKey(Long aKey) {
		this.key = aKey;
	}
}
