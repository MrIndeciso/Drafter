package com.mrindeciso.drafter.ui.drawFragment

import android.graphics.Bitmap
import com.mrindeciso.util.data.Brush

data class BrushButton(

    val name: String,

    val image: Bitmap,

    val isEraser: Boolean,

    val brush: Brush,

)
