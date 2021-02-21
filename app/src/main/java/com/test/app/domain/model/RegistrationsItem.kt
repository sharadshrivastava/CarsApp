package com.test.app.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RegistrationsItem(
	val insurer: Insurer?,
	val registration: Registration?,
	@field:SerializedName("plate_number")
	val plateNumber: String?,
	val vehicle: Vehicle?
) : Parcelable
