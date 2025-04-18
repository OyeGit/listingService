package com.luxesoft.model.task

import com.luxesoft.model.property.Property

class FakeTaskRepository : TaskRepository  {

    private val platformRun =  "/Users/oyeoyegbami/ListingApp"
    //private val platformRun =  "C:\ListingApp"
    private val tasks = mutableListOf(
        Task("cleaning", "Clean the house", Priority.Low),
        Task("gardening", "Mow the lawn", Priority.Medium),
        Task("shopping", "Buy the groceries", Priority.High),
        Task("painting", "Paint the fence", Priority.Medium)
    )

    private val properties = mutableListOf (
        Property(
            1, "20 main street", 6.5244, 3.3792,
            1,2, 4,"One bedroom apartment for rent",
            "Can be used for residential or office use, very spacious and accormodating",
            1, 2, 1, 3, 2,
            2,2, 3, 26000000.00, 2,
            "202504161530", "202604161530",
            2, 3, "09828761234", "local@mail.com", 1,
            3,
            "$platformRun/Resource/images/8/ajani1",
            "$platformRun/Resource/images/8/ajani2",
            "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3",
                "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3",
            "$platformRun/Resource/images/8/ajani3"
        ),
        Property(
                2, "20 main street", 6.5244, 3.3792,
        1,2, 4,"One bedroom apartment for rent",
        "Can be used for residential or office use, very spacious and accormodating",
        1, 2, 1, 3, 2,
        2, 2,2, 26000000.00, 2,
            "202504171530", "202604171530",
        2, 3, "09828761234", "local@mail.com", 1,
            3,"$platformRun/Resource/images/9/osapauser",
            "$platformRun/Resource/images/9/osapa1",
        "$platformRun/Resource/images/9/osapa2",
            "$platformRun/Resource/images/9/osapa3",
            "$platformRun/Resource/images/9/osapa4",
            "$platformRun/Resource/images/9/osapa5",
            "$platformRun/Resource/images/9/osapa6",
            "$platformRun/Resource/images/9/osapa7",
            "$platformRun/Resource/images/9/osapa8",
            "$platformRun/Resource/images/9/osapa9",
            "$platformRun/Resource/images/9/osapa10",
            "$platformRun/Resource/images/9/osapa3",
            "$platformRun/Resource/images/9/osapa3"

        ),
        Property (3,"1 Alafia street",4.6789,6.344,1,2,
            3,"Warehouse for rent","Spacious space for rent",
            3,2,2,1,1,
            2, 2,2, 15000000.00,3,
            "202504181530", "202604181530",
            6,
            9, "7074806960","flourishbiz924@gmail.com", 1,
            3,"$platformRun/Resource/images/10/flourish1",
            "$platformRun/Resource/images/10/flourish2",
            "$platformRun/Resource/images/10/flourish3",
            "$platformRun/Resource/images/10/flourish4",
            "$platformRun/Resource/images/10/flourish5",
            "$platformRun/Resource/images/10/flourish6",
            "$platformRun/Resource/images/10/flourish7",
            "$platformRun/Resource/images/10/flourish8",
            "$platformRun/Resource/images/10/flourish9",
            "$platformRun/Resource/images/10/flourish10",
            "$platformRun/Resource/video/10/flourishvid1",
            "$platformRun/Resource/video/10/flourishvid2",
            "$platformRun/Resource/images/10/flourishuser"
        ),
        Property (4,"1 Alafia street",4.6789,6.344,1,2,
        3,"Warehouse for rent","Spacious space for rent",
        3,2,2,1,1,
        2,2,3,15000000.00,3,
            "202504141530", "202604141530",
            6,
        6, "7074806960","onirujazz109@gmail.com", 1,
             2,"$platformRun/Resource/images/10/oniruuser",
             "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/images/11/oniru1",
        "$platformRun/Resource/video/11/oniru1",
        "$platformRun/Resource/video/11/oniru1"
        )
    )

    override suspend fun allProperties(): List<Property> = properties

    override suspend fun allTasks(): List<Task> = tasks

    override suspend fun propertyByState(stateId: Int): List<Property> = properties.filter {
        it.stateid == stateId
    }

    override suspend fun propertyByIdProp(idProp: Int): List<Property> = properties.filter {
        it.propertyid == idProp
    }

    override suspend fun propertyByLga(lgaId: Int): List<Property> = properties.filter {
        it.lgaid == lgaId
    }

    override suspend fun tasksByPriority(priority: Priority) = tasks.filter {
        it.priority == priority
    }

    override suspend fun taskByName(name: String) = tasks.find {
        it.name.equals(name, ignoreCase = true)
    }

    override suspend fun addProperty(property: Property) {
        properties.add(property)
    }

    override suspend fun addTask(task: Task) {
        if (taskByName(task.name) != null) {
            throw IllegalStateException("Cannot duplicate task names!")
        }
        tasks.add(task)
    }

    override suspend fun removeTask(name: String): Boolean {
        return tasks.removeIf { it.name == name }
    }


}

