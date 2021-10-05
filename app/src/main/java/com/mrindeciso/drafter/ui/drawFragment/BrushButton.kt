package com.mrindeciso.drafter.ui.drawFragment

import androidx.annotation.DrawableRes
import com.mrindeciso.util.data.Brush

data class BrushButton(

    val name: String,

    @DrawableRes val image: Int,

    val brush: Brush,

)
