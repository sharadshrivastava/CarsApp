package com.test.app.ui.cars

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.test.app.R
import com.test.app.data.common.maskNumber
import com.test.app.data.db.entity.RegistrationEntity
import com.test.app.domain.model.Registration
import com.test.app.domain.model.Vehicle
import com.test.app.ui.common.formatDate

@BindingAdapter("vehicleType")
fun loadImage(imageView: ImageView, type: String) {
    val vehicle = when (type) {
        "Sedan" -> R.drawable.ic_sedan
        "Hatch" -> R.drawable.ic_hatchback
        "SUV" -> R.drawable.ic_suv
        else -> R.drawable.ic_suv
    }
    imageView.setImageResource(vehicle)
}

@BindingAdapter("expiryDate")
fun formatDateList(textView: TextView, registration: RegistrationEntity) =
    formatDate(textView, registration, R.string.reg_expired, R.string.reg_expiring)

@BindingAdapter("expiryDateDetails")
fun formatDateDetails(textView: TextView, registration: RegistrationEntity) =
    formatDate(textView, registration, R.string.reg_expired_details, R.string.reg_expiring_details)

@BindingAdapter("vin")
fun vin(textView: TextView, vin: String?) {
    textView.text =
        textView.context.getString(R.string.vin, maskNumber(vin))
}