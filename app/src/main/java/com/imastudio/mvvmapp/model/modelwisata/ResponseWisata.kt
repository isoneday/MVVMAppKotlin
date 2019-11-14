package com.imastudio.mvvmapp.model.modelwisata

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ResponseWisata(

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.createTypedArrayList(DataItem),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(statusCode)
		parcel.writeTypedList(data)
		parcel.writeString(message)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ResponseWisata> {
		override fun createFromParcel(parcel: Parcel): ResponseWisata {
			return ResponseWisata(parcel)
		}

		override fun newArray(size: Int): Array<ResponseWisata?> {
			return arrayOfNulls(size)
		}
	}
}