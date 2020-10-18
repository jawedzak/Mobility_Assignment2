package sheridan.jawedzak.assignment2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameScoreDao {

    @Insert
    suspend fun insert(gameScore: GameScore): Long

   // @Query("SELECT * FROM gameScore WHERE id=:key")
  // fun get(key: Long) : LiveData<GameScore>

    @Query("SELECT * FROM gameScore ORDER BY id")
    fun getAll() : LiveData<List<GameScore>>

    @Query("DELETE FROM gameScore")
    suspend fun deleteAll()

}