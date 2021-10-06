package com.mrindeciso.util.db.dao

import androidx.room.*
import com.mrindeciso.util.data.Brush
import kotlinx.coroutines.flow.Flow

@Dao
interface BrushDAO {

    @Query("SELECT  * FROM brushes")
    fun getAllBrushes(): Flow<List<Brush>>

    @Insert
    suspend fun insertBrush(vararg brush: Brush)

    @Delete
    suspend fun deleteBrush(brush: Brush)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBrush(brush: Brush)

    @Query("SELECT COUNT(id) FROM brushes")
    suspend fun count(): Int

}