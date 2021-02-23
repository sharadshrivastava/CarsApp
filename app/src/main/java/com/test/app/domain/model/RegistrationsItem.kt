package com.test.app.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.test.app.data.db.entity.RegistrationEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RegistrationsItem(
	val insurer: Insurer?,
	val registration: Registration?,
	@field:SerializedName("plate_number")
	val plateNumber: String?,
	val vehicle: Vehicle?
) : Parcelable
{
	fun toRegistrationEntity() : RegistrationEntity {
		return RegistrationEntity(
			plateNumber = plateNumber,
			expired = registration?.expired,
			expiryDate = registration?.expiryDate,
			insurerName = insurer?.name,
			model = vehicle?.model,
			make = vehicle?.make,
			vin = vehicle?.vin,
			type = vehicle?.type
		)
	}
}
