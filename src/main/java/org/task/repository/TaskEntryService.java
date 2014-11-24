/**
 * 
 */
package org.task.repository;

import java.util.Calendar;
import java.util.Collection;

import org.task.model.EXECUTION_STATUS;
import org.task.model.TaskEntry;
import org.task.model.TaskExecutionEntry;

/**
 * This service helps us manage task entries in a persistent store as part of our book keeping
 * 
 * @author venki
 *
 */
public interface TaskEntryService {
	/**
	 * Given a key get the task entry details.
	 *  
	 * @param key - the unique key assigned to the entry
	 * @param fetchExecutions - if true if there are any executions they are fetched as well
	 * @return - the task entry
	 * 
	 * @throws TaskRepositoryException
	 */
	public TaskEntry getTaskEntry(Long key, boolean fetchExecutions) throws TaskRepositoryException;
	/**
	 * Browse task entries submitted for execution from a given start time to end time, filter by given category and status
	 *  
	 * @param submitStart - the lower boundary for the time of submission
	 * @param submitEnd - the upper boundary for the time of submission
	 * @param category - the category by which the entries will be filtered
	 * @param aStatus - the execution station by which the entries will be filtered
	 * 
	 * @return - collection of entries or null if no entires exist
	 * @throws TaskRepositoryException
	 */
	public Collection<TaskEntry> getTaskEntries(Calendar submitStart, Calendar submitEnd, 
												String category, EXECUTION_STATUS aStatus) throws TaskRepositoryException;
	/**
	 * 
	 * @param taskEntryKey - the task entry key for which we are seeking the execution entries
	 * @return
	 * @throws TaskRepositoryException
	 */
	public Collection<TaskExecutionEntry> getTaskExecutionEntries(Long taskEntryKey) throws TaskRepositoryException;
	/**
	 * Save this task entry into a persistent store
	 * 
	 * @param aTaskEntry
	 * @throws TaskRepositoryException
	 */
	public void saveTaskEntry(TaskEntry aTaskEntry) throws TaskRepositoryException;
	/**
	 * Given a task entry, identified by its key, get the execution status
	 * 
	 * @param entryKey
	 * @return
	 * @throws TaskRepositoryException
	 */
	public EXECUTION_STATUS getExecutionStatus(Long entryKey) throws TaskRepositoryException;
	/**
	 * Given a task execution entry, save it to persistent store.
	 * 
	 * @param executionEntry
	 * @throws TaskRepositoryException
	 */
	public void saveTaskExecutionEntry(TaskExecutionEntry executionEntry) throws TaskRepositoryException;
}
