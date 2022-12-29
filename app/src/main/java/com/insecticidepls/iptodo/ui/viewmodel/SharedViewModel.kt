package com.insecticidepls.iptodo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.insecticidepls.iptodo.data.models.ToDoTask
import com.insecticidepls.iptodo.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel
@Inject constructor(
    private val repository: ToDoRepository
    ): ViewModel() {

    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks: StateFlow<List<ToDoTask>> = _allTasks

    fun readAllTasks() {
        viewModelScope.launch {
            repository.readAllTasks.collect {
                _allTasks.value = it
            }
        }
    }
}
