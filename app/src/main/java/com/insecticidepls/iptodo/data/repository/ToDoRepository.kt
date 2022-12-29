package com.insecticidepls.iptodo.data.repository

import com.insecticidepls.iptodo.data.DAOToDo
import com.insecticidepls.iptodo.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository
@Inject constructor(
    private val todoDAO: DAOToDo) {
    val readAllTasks: Flow<List<ToDoTask>> = todoDAO.readAllTasks()
    val sortLowPriority: Flow<List<ToDoTask>> = todoDAO.sortLowPriority()
    val sortCriticalTasks: Flow<List<ToDoTask>> = todoDAO.sortCriticalTasks()

    fun readSelectedTask(taskId: Int): Flow<ToDoTask> {
        return todoDAO.readTask(taskId = taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        todoDAO.writeTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        todoDAO.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        todoDAO.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTask() {
        todoDAO.deleteAllTasks()
    }

    fun searchDB(queryParam: String): Flow<List<ToDoTask>> {
        return todoDAO.searchTask(queryParam = queryParam)
    }
}
