package com.mrindeciso.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

inline fun <T: View> T.onClick(crossinline action: () -> Unit) {
    setOnClickListener { action.invoke() }
}

inline fun <reified T> ViewGroup.inflateBinding(
    func: (LayoutInflater, ViewGroup?, Boolean) -> T
): T {
    return func(
        LayoutInflater.from(context),
        this,
        false
    )
}