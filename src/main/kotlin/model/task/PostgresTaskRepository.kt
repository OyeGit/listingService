package com.luxesoft.model.task

import com.luxesoft.db.PropertyDAO
import com.luxesoft.db.TaskDAO
import com.luxesoft.db.TaskTable
import com.luxesoft.db.daoToModel
import com.luxesoft.db.propDaoToModel
import com.luxesoft.db.suspendTransaction
import com.luxesoft.model.property.Property
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere

class PostgresTaskRepository : TaskRepository {
    override suspend fun allProperties(): List<Property> = suspendTransaction {
        PropertyDAO.all().map(::propDaoToModel)
    }

    override suspend fun allTasks(): List<Task> = suspendTransaction {
        TaskDAO.all().map(::daoToModel)
    }

    override suspend fun propertyByState(stateId: Int): List<Property> {
        TODO("Not yet implemented")
    }

    override suspend fun propertyByIdProp(idProp: Int): List<Property> {
        TODO("Not yet implemented")
    }

    override suspend fun tasksByPriority(priority: Priority): List<Task> = suspendTransaction {
        TaskDAO
            .find { (TaskTable.priority eq priority.toString()) }
            .map(::daoToModel)
    }

    override suspend fun propertyByLga(lgaId: Int): List<Property> {
        TODO("Not yet implemented")
    }

    override suspend fun taskByName(name: String): Task? = suspendTransaction {
        TaskDAO
            .find { (TaskTable.name eq name) }
            .limit(1)
            .map(::daoToModel)
            .firstOrNull()
    }

    override suspend fun addProperty(property: Property) {
        TODO("Not yet implemented")
    }

    override suspend fun addTask(task: Task): Unit = suspendTransaction {
        TaskDAO.new {
            name = task.name
            description = task.description
            priority = task.priority.toString()
        }
    }

    override suspend fun removeTask(name: String): Boolean = suspendTransaction {
        val rowsDeleted = TaskTable.deleteWhere {
            TaskTable.name eq name
        }
        rowsDeleted == 1
    }


}