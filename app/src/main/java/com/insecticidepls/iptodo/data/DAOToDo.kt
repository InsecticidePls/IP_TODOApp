package com.insecticidepls.iptodo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.insecticidepls.iptodo.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOToDo {

    @Query("SELECT * FROM TB_TODO ORDER BY taskId ASC")
    fun readAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM TB_TODO WHERE taskId = :taskId")
    fun readTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun writeTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM TB_TODO")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM TB_TODO WHERE taskTitle LIKE :queryParam OR taskDetails LIKE :queryParam")
    fun searchTask(queryParam: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM TB_TODO WHERE taskTitle ORDER BY taskId")
    fun sortLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM TB_TODO ORDER BY taskPriority ASC")
    fun sortCriticalTasks(): Flow<List<ToDoTask>>
}
