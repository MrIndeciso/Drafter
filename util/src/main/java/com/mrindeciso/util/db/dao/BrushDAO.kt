package com.mrindeciso.util.db.dao

import androidx.room.*
import com.mrindeciso.util.data.Brush
import kotlinx.coroutines.flow.Flow

@Dao
interface BrushDAO {

    @Query("SELECT  * FROM brushes")
    fun getAllBrushes(): Flow<List<Brush>>

    @Insert
    fun insertBrush(vararg brush: Brush)

    @Delete
    fun deleteBrush(brush: Brush)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateBrush(brush: Brush)

}