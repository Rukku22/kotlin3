package com.example

import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id:Int,var name:String,var place:String)

