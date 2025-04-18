package com.luxesoft.model.task

import com.luxesoft.model.property.Property

interface TaskRepository {
    suspend fun allProperties(): List<Property>
    suspend fun allTasks(): List<Task>
    suspend fun propertyByState(stateId: Int):List<Property>
    suspend fun propertyByIdProp(idProp: Int): List<Property>
    suspend fun tasksByPriority(priority: Priority): List<Task>
    suspend fun propertyByLga(lgaId: Int): List<Property>
    suspend fun taskByName(name: String): Task?
    suspend fun addProperty(property: Property)
    suspend fun addTask(task: Task)
    suspend fun removeTask(name: String): Boolean
}