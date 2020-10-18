package sheridan.jawedzak.assignment2.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import sheridan.jawedzak.assignment2.database.GameScore
import sheridan.jawedzak.assignment2.database.GameScoreDao
import sheridan.jawedzak.assignment2.database.GameScoreDatabase
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    private val gameScoreDao: GameScoreDao =
        GameScoreDatabase.getInstance(application).gameScoreDao

    val history: LiveData<List<GameScore>> = gameScoreDao.getAll()

    fun clear(){
        viewModelScope.launch {
            gameScoreDao.deleteAll()
        }
    }

}