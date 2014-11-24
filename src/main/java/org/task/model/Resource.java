/**
 * 
 */
package org.task.model;

import java.io.Externalizable;
import java.util.Calendar;
import java.util.concurrent.TimeoutException;


/**
 * A resource is uniquley identifiable entity which is either created a result of a task entry execution.
 * It is shared by several task executions. Hence, it needs to be locked/unlocked network wide.
 * For example, in a single JVM it is guarded by reader/writer locks.
 * Resource manage is responsible for creating resources and ensuring there are not dead-locks and starvation
 *   
 * @author venki
 *
 */
public abstract class Resource implements Externalizable {

	private Long key;
	private String name;
	private String category;
	private String owner;
	private String creator;
	private int priority;		//to prevent dead locks - used by banker's algorithm
	private Calendar creationTime;
	//used only by serializer
	/**
	 * 
	 */
	public Resource() {
		this(null,null,null,null);
	}
	/**
	 * 
	 * @param aName
	 * @param aCategory
	 */
	public Resource(String aName, String aCategory) {
		this(aName,aCategory,null,null);
	}
	/**
	 * 
	 * @param aName
	 * @param aCategory
	 * @param aCreator
	 * @param aOwner
	 */
	public Resource(String aName, String aCategory, String aCreator, String aOwner) {
		//TODO: replace by Murmurhash long
		key = new Long((aName + ":" + aCategory).hashCode());
		name = aName;
		category = aCategory;
		creator = aCreator;
		owner = aOwner;
		//TODO
	}
	/**
	 * is this resource exists in the system
	 * @return - true if exists, false otherwise
	 */
	abstract public boolean exists();
	/**
	 * delete the resource permanently from the system 
	 * @return - true if deletion succeeded and false otherwise
	 */
	abstract public boolean delete();
	/**
	 * check if the rerouce is locked for reading. Checking does not mean subsequent {@link #readLock(long)} returns true.
	 * Users are expected to lock using the methods appropriately
	 * @return - true if lock is available, false other wise 
	 */
	abstract public boolean isReadLocked();
	/**
	 * check if the rerouce is locked for reading. Checking does not mean subsequent {@link #writeLock(long)} returns true.
	 * Users are expected to lock using the methods appropriately
	 * @return - true if lock is available, false other wise 
	 */
	abstract public boolean isWriteLocked();
	/**
	 * read lock the resource.
	 * @param timeOut - maximum wait for acquiring the resource
	 * @return - true if the able to lock, false otherwise
	 */
	abstract public boolean readLock(long timeOut) throws TimeoutException;
	/**
	 * write lock the resource 
	 * @param timeOut
	 * @return
	 * @throws TimeoutException
	 */
	abstract public boolean writeLock(long timeOut) throws TimeoutException;
	/**
	 * 
	 * @return - long and the unique key given to the resource 
	 */
	public Long getKey() {
		return key;
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
	 * @return
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 
	 * @return
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * 
	 * @return
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 
	 * @return
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * 
	 * @param priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * 
	 * @return
	 */
	public Calendar getCreationTime() {
		return creationTime;
	}
	/**
	 * 
	 * @param creationTime
	 */
	public void setCreationTime(Calendar creationTime) {
		this.creationTime = creationTime;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * 
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
}
