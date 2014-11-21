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
 * @author venki
 *
 */
public abstract class Task implements Externalizable {
	private String category;
	private String name;
	private String description;
	private List<String> parameters;
	
	private Map<String,Task> predecessorTasks;
	private Map<String,Task> successorTasks;
	
	public abstract boolean execute(TaskEntry te) throws ExecutionException;
	protected Task() { } //use by subclasses for serialization
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
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
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> aParameters) {
		if(aParameters == null) {
			this.parameters = null;
		} else {
			this.parameters = new ArrayList<String>(aParameters);
		}
	}
	public Map<String, Task> getPredecessorTasks() {
		return predecessorTasks;
	}
	public void setPredecessorTasks(Map<String, Task> aPredecessorTasks) {
		if(aPredecessorTasks == null) {
			predecessorTasks = null;
		} else {
			this.predecessorTasks = new HashMap<String,Task>(aPredecessorTasks);
		}
	}
	public Map<String, Task> getSuccessorTasks() {
		return successorTasks;
	}
	public void setSuccessorTasks(Map<String, Task> aSuccessorTasks) {
		if(this.successorTasks == null) {
			this.successorTasks = null;
		} else {
			this.successorTasks = new HashMap<String, Task>(aSuccessorTasks);
		}
	}
	public abstract TaskEntry createTaskEntry(Map<String, Externalizable> aParams);
}
