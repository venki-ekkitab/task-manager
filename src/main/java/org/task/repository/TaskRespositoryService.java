/**
 * 
 */
package org.task.repository;

import java.util.Collection;

import org.task.model.Task;

/**
 * Service managing task information in a repository. More often than not, it will be a 
 * persistent repository
 * 
 * @author venki
 *
 */
public interface TaskRespositoryService {

	/**
	 * Get a task by name and category
	 * 
	 * @param name
	 * @param category
	 * @return
	 * @throws TaskRepositoryException
	 */
	public Task getTask(String name, String category) throws TaskRepositoryException;
	/**
	 * Get a task from the persistent store
	 * @param key
	 * @return
	 * @throws TaskRepositoryException
	 */
	public Task getTask(Long key) throws TaskRepositoryException;
	/**
	 * Save task definition into a persistent store
	 * @param aTask
	 * @throws TaskRepositoryException
	 */
	public void saveTask(Task aTask) throws TaskRepositoryException;
	/**
	 * Delete the task from persistent store
	 * @param aTask
	 * @throws TaskRepositoryException
	 */
	public void deleteTask(Long key) throws TaskRepositoryException;
	/**
	 * Add a predecessor task to the given parent
	 * @param aTask - the child task
	 * @param aParent - parent task
	 * @throws TaskRepositoryException
	 */
	public void addPredecessorTask(Task aTask, Task aParent) throws TaskRepositoryException;
	/**
	 * Remove predecessor task from the given parent
	 * 
	 * @param aTask
	 * @param aParent
	 * @throws TaskRepositoryException
	 */
	public void removePredecessorTask(Task aTask, Task aParent) throws TaskRepositoryException;
	/**
	 * Add a successor task to the given task
	 * @param aTask - parent task
	 * @param aSuccesor - given successor task
	 * @throws TaskRepositoryException
	 */
	public void addSuccessorTask(Task aTask, Task aSuccesor) throws TaskRepositoryException;
	/**
	 * Remove a successor task from the parent
	 * @param aTask
	 * @param aSuccesor
	 * @throws TaskRepositoryException
	 */
	public void removeSuccessorTask(Task aTask, Task aSuccesor) throws TaskRepositoryException;
	/**
	 * Get the predecessor tasks for a given task
	 * @param aTask
	 * @return
	 * @throws TaskRepositoryException
	 */
	public Collection<Task> getPredessorTasks(Task aTask) throws TaskRepositoryException;
	/**
	 * Get successor task for a give task
	 * 
	 * @param aTask
	 * @return
	 * @throws TaskRepositoryException
	 */
	public Collection<Task> getSuccessorTasks(Task aTask) throws TaskRepositoryException;
}
