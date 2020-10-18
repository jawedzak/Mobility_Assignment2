package sheridan.jawedzak.assignment2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameScore")
data class GameScore(
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "dice_1")
    val dice1: Int,

    @ColumnInfo(name = "dice_2")
    val dice2: Int,

    @ColumnInfo(name = "dice_3")
    val dice3: Int,

    @ColumnInfo(name = "total")
    val total: Int

)