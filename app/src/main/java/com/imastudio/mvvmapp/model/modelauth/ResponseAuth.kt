package com.imastudio.mvpapp.model.modelauth

import com.google.gson.annotations.SerializedName

data class ResponseAuth(

	@field:SerializedName("result")
	val result: String? = null,

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("user")
	val user: User? = null
)