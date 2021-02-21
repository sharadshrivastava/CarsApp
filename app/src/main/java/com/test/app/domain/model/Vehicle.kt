package com.test.app.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Vehicle(
	@field:SerializedName("tare_weight")
	val tareWeight: Int? = null,
	val colour: String? = null,
	val model: String? = null,
	val vin: String? = null,
	val type: String? = null,
	val make: String? = null,
	@field:SerializedName("gross_mass")
	val grossMass: @RawValue Any? = null
): Parcelable
