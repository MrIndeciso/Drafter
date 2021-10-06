package com.mrindeciso.util.repo

import androidx.annotation.WorkerThread
import com.mrindeciso.util.data.Brush
import com.mrindeciso.util.db.dao.BrushDAO
import javax.inject.Inject

class BrushRepo @Inject constructor(
    private val brushDao: BrushDAO
) {

    @WorkerThread
    suspend fun brushCount() = brushDao.count()

    @WorkerThread
    suspend fun insertBrush(vararg brush: Brush) = brushDao.insertBrush(*brush)

    val allBrushes = brushDao.getAllBrushes()

}