package com.imastudio.mvpapp.model.modelwisata

 import android.os.Parcel
 import android.os.Parcelable
 import com.google.gson.annotations.SerializedName

 data class DataItem(

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("nama_tempat")
	val namaTempat: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
) : Parcelable {
	 constructor(parcel: Parcel) : this(
		 parcel.readString(),
		 parcel.readString(),
		 parcel.readString(),
		 parcel.readString(),
		 parcel.readString()
	 ) {
	 }

	 override fun writeToParcel(parcel: Parcel, flags: Int) {
		 parcel.writeString(lokasi)
		 parcel.writeString(id)
		 parcel.writeString(deskripsi)
		 parcel.writeString(namaTempat)
		 parcel.writeString(gambar)
	 }

	 override fun describeContents(): Int {
		 return 0
	 }

	 companion object CREATOR : Parcelable.Creator<DataItem> {
		 override fun createFromParcel(parcel: Parcel): DataItem {
			 return DataItem(parcel)
		 }

		 override fun newArray(size: Int): Array<DataItem?> {
			 return arrayOfNulls(size)
		 }
	 }
 }