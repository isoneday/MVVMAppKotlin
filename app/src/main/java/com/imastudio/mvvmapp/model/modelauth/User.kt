package com.imastudio.mvpapp.model.modelauth

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("level")
	val level: String? = null,

	@field:SerializedName("jenkel")
	val jenkel: String? = null,

	@field:SerializedName("no_telp")
	val noTelp: String? = null,

	@field:SerializedName("id_user")
	val idUser: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)