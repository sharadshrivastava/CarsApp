package com.test.app.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class RegistrationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "plate_number") val plateNumber: String?,
    @ColumnInfo(name = "registration_expired") val expired: Boolean?,
    @ColumnInfo(name = "expiry_date") val expiryDate: String?,
    @ColumnInfo(name = "insurer_name") val insurerName: String?,
    val model: String?,
    val make: String?,
    val vin: String?,
    val type:String?
):Parcelable