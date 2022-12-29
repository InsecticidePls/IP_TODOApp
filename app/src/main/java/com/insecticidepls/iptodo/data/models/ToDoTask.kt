package com.insecticidepls.iptodo.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.insecticidepls.iptodo.util.Constants.DATA_TABLE

@Entity(tableName = DATA_TABLE)
data class ToDoTask (
    @PrimaryKey(autoGenerate = true)
    val taskId: Int = 0,
    val taskTitle: String,
    val taskDetails: String,
    val taskPriority: Priority
)
