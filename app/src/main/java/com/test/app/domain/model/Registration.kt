package com.test.app.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Registration(
	val expired: Boolean? = null,
	@field:SerializedName("expiry_date")
	val expiryDate: String? = null
): Parcelable
