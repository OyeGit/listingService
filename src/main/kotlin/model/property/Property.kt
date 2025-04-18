package com.luxesoft.model.property

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import java.time.LocalDate


@Serializable
data class Property(

    val propertyid: Int = 0,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val lgaid:Int,
    val cityid:Int,
    val stateid: Int,
    val title: String,    //   Title
    val description: String,
    val proptypeid: Int,    // * Rental, Sale, Lease
    val propuseid: Int,     // * Residential, Commercial, Agriculture, Industry
    val propsubtypeid: Int, // * Apartment, Flat, House, Shop, Commercial, Farm
    val bedroom: Int,
    val toilets: Int,
    val livingroom: Int,
    val bathroom: Int,
    val parking: Int,
    val price: Double,
    val typeid: Int,
    val entereddate: String,
    val expirydate: String,
    val userid: Int,
    val marketebyuserid: Int,
    val marketedbyphone: String,
    val marketedbyemail: String,
    val statusid: Int,
    val orderid: Int,
    val img1: String,
    val img2: String,
    val img3: String,
    val img4: String,
    val img5: String,
    val img6: String,
    val img7: String,
    val img8: String,
    val img9: String,
    val img10: String,
    val video1: String,
    val video2: String,
    val marketedbyimage: String
)

