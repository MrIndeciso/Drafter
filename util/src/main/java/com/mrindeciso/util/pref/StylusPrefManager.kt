package com.mrindeciso.util.pref

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StylusPrefManager @Inject constructor(
    @ApplicationContext ctx: Context
) {

    private val preferences = ctx.getSharedPreferences("stylusPreferences", Context.MODE_PRIVATE)

    var useQuadInsteadOfLine: Boolean
        get() = preferences.getBoolean(Keys.QUAD_OR_LINE.name, true)
        set(value) = preferences.edit().putBoolean(Keys.QUAD_OR_LINE.name, value).apply()

    var applyCornetPathEffect: Boolean
        get() = preferences.getBoolean(Keys.CORNER_PATH.name, true)
        set(value) = preferences.edit().putBoolean(Keys.CORNER_PATH.name, value).apply()

    var autosaveDelay: Int
        get() = preferences.getInt(Keys.AUTOSAVE_DELAY.name, 5)
        set(value) = preferences.edit().putInt(Keys.AUTOSAVE_DELAY.name, value).apply()

    private enum class Keys {
        QUAD_OR_LINE,
        CORNER_PATH,

        AUTOSAVE_DELAY,
    }

}