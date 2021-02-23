package com.test.app.ui.common

import android.content.Context
import android.widget.TextView
import com.test.app.data.common.formatDate
import com.test.app.data.db.entity.RegistrationEntity
import com.test.app.domain.model.Registration

fun formatDate(textView: TextView, registration: RegistrationEntity, stringId: Int, stringIdSecond: Int) {
    if (registration.expired == true) { //Here "registration.expired" is nullable boolean so used "==true".
        textView.text =
            textView.context.getString(stringId,
                formatDate(registration.expiryDate)
            )
    } else {
        textView.text =
            textView.context.getString(stringIdSecond,
                formatDate(registration.expiryDate)
            )
    }
}

fun pxFromDp(context: Context?, dp: Float): Float {
    return dp * context?.resources?.displayMetrics?.density!!
}

fun dpFromPx(context: Context?, px: Float): Float {
    return px / context?.resources?.displayMetrics?.density!!;
}