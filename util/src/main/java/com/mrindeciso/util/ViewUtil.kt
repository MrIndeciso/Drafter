package com.mrindeciso.util

import android.view.View

inline fun <T: View> T.onClick(crossinline action: () -> Unit) {
    setOnClickListener { action.invoke() }
}