package com.test.app.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Insurer(
	val code: Int? = null,
	val name: String? = null
):Parcelable
