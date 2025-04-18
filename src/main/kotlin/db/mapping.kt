package com.luxesoft.db

import com.luxesoft.model.property.Property
import com.luxesoft.model.task.Priority
import com.luxesoft.model.task.Task
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.time.LocalDate

object TaskTable : IntIdTable("task") {
    val name = varchar("name", 50)
    val description = varchar("description", 50)
    val priority = varchar("priority", 50)
}

class TaskDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TaskDAO>(TaskTable)
    var name by TaskTable.name
    var description by TaskTable.description
    var priority by TaskTable.priority
}

suspend fun <T> suspendTransaction(block: Transaction.() -> T): T =
    newSuspendedTransaction(Dispatchers.IO, statement = block)

fun daoToModel(dao: TaskDAO) = Task(
    dao.name,
    dao.description,
    Priority.valueOf(dao.priority)
)
//---------------------------------------------------------------

object PropertyTable : IntIdTable("property") {
    val propertyid = integer("propertyid")
    val address = varchar("address", 100)
    val latitude = double("latitude")
    val longitude = double("longitude")
    val lgaid = integer("lgaid")
    val cityid = integer( "cityid")
    val stateid = integer ( "stateid")
    val title = varchar("title",50 )
    val description = varchar("description", 100)
    val proptypeid = integer("proptypeid")
    val propuseid = integer("propuseid")
    val propsubtypeid = integer("propsubtypeid")
    val bedroom =  integer("bedroom")
    val toilets = integer("toilets")
    val livingroom = integer("livingroom")
    val bathroom = integer("bathroom")
    val parking = integer("parking")
    val price = double("price")
    val typeid = integer("typeid")
    val entereddate = varchar("entereddate", 20 )
    val expirydate = varchar("expirydate", 20 )
    val userid = integer("userid")
    val marketebyuserid = integer("marketebyuserid")
    val marketedbyphone = varchar("marketedbyphone", 100)
    val marketedbyemail = varchar("marketedbyemail", 100)
    val statusid = integer("statusid")
    val orderid = integer("orderid")
    val img1 = varchar("img1", 100)
    val img2 = varchar("img2", 100)
    val img3 = varchar("img3", 100)
    val img4 = varchar("img4", 100)
    val img5 = varchar("img5", 100)
    val img6 = varchar("img6", 100)
    val img7 = varchar("img7", 100)
    val img8 = varchar("img8", 100)
    val img9 = varchar("img9", 100)
    val img10 =  varchar("img10", 100)
    val video1 = varchar("video1", 100)
    val video2 = varchar("video2", 100)
    val marketedbyimage = varchar("marketedbyimage", 100)

}

class PropertyDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PropertyDAO>(PropertyTable)

    val propertyid by PropertyTable.propertyid
    val address by PropertyTable.address
    val latitude by PropertyTable.latitude
    val longitude by PropertyTable.longitude
    val lgaid  by PropertyTable.lgaid
    val cityid by PropertyTable.cityid
    val stateid by PropertyTable.stateid
    val title by PropertyTable.title
    val description by PropertyTable.description
    val proptypeid by PropertyTable.proptypeid
    val propuseid by PropertyTable.propuseid
    val propsubtypeid by PropertyTable.propsubtypeid
    val bedroom by PropertyTable.bedroom
    val toilets by PropertyTable.toilets
    val livingroom by PropertyTable.livingroom
    val bathroom by PropertyTable.bathroom
    val parking by PropertyTable.parking
    val price by PropertyTable.price
    val typeid by PropertyTable.typeid
    val entereddate by PropertyTable.entereddate
    val expirydate by PropertyTable.expirydate
    val userid by PropertyTable.userid
    val marketebyuserid by PropertyTable.marketebyuserid
    val marketedbyphone by PropertyTable.marketedbyphone
    val marketedbyemail by PropertyTable.marketedbyemail
    val statusid by PropertyTable.statusid
    val orderid by PropertyTable.orderid
    val img1 by PropertyTable.img1
    val img2 by PropertyTable.img2
    val img3 by PropertyTable.img3
    val img4 by PropertyTable.img4
    val img5 by PropertyTable.img5
    val img6 by PropertyTable.img6
    val img7 by PropertyTable.img7
    val img8 by PropertyTable.img8
    val img9 by PropertyTable.img9
    val img10 by PropertyTable.img10
    val video1 by PropertyTable.video1
    val video2 by PropertyTable.video2
    val marketedbyimage by PropertyTable.marketedbyimage
}

fun propDaoToModel(dao: PropertyDAO) = Property(
    dao.propertyid,
    dao.address,
    dao.latitude,
    dao.longitude,
    dao.lgaid,
    dao.cityid,
    dao.stateid,
    dao.title,
    dao.description,
    dao.proptypeid,
    dao.propuseid,
    dao.propsubtypeid,
    dao.bedroom,
    dao.toilets,
    dao.livingroom,
    dao.bathroom,
    dao.parking,
    dao.price,
    dao.typeid,
    dao.entereddate,
    dao.expirydate,
    dao.userid,
    dao.marketebyuserid,
    dao.marketedbyphone,
    dao.marketedbyemail,
    dao.statusid,
    dao.orderid,
    dao.img1,
    dao.img2,
    dao.img3,
    dao.img4,
    dao.img5,
    dao.img6,
    dao.img7,
    dao.img8,
    dao.img9,
    dao.img10,
    dao.video1,
    dao.video2,
    dao.marketedbyimage
)







