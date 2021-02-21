package com.test.app.ui.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.app.R
import com.test.app.data.common.formatDate
import com.test.app.data.common.maskNumber
import com.test.app.domain.model.Registration
import com.test.app.domain.model.Vehicle

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

@BindingAdapter(value = ["items", "itemLayout", "clickListener"], requireAll = true)
fun <T> configureRecyclerView(
    recyclerView: RecyclerView,
    items: List<Any>?,
    layoutId: Int,
    clickListener: ItemClickListener
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = GenericRecyclerViewAdapter(items, layoutId, clickListener)
    } else {
        (recyclerView.adapter as GenericRecyclerViewAdapter).setItems(items)
    }
}

@BindingAdapter("expiryDate")
fun formatDateList(textView: TextView, registration: Registration) =
    formatDate(textView, registration, R.string.reg_expired, R.string.reg_expiring)

@BindingAdapter("expiryDateDetails")
fun formatDateDetails(textView: TextView, registration: Registration) =
    formatDate(textView, registration, R.string.reg_expired_details, R.string.reg_expiring_details)

fun formatDate(textView: TextView, registration: Registration, stringId: Int, stringIdSecond: Int) {
    if (registration.expired == true) { //Here "registration.expired" is nullable boolean so used "==true".
        textView.text =
            textView.context.getString(stringId, formatDate(registration.expiryDate))
    } else {
        textView.text =
            textView.context.getString(stringIdSecond, formatDate(registration.expiryDate))
    }
}

@BindingAdapter("vin")
fun vin(textView: TextView, vehicle: Vehicle) {
    textView.text =
        textView.context.getString(R.string.vin, maskNumber(vehicle.vin))
}