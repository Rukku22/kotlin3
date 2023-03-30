package service

import kotlinx.serialization.Serializable

@Serializable

data class Student(val id:Int,var name:String,var gender:String,var number:String,var city:String,
                      var state:String,var country:String,var pincode:String)
