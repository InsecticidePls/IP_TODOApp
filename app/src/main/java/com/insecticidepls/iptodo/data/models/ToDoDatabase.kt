package com.insecticidepls.iptodo.data.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.insecticidepls.iptodo.data.DAOToDo

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun daoTD(): DAOToDo
}
