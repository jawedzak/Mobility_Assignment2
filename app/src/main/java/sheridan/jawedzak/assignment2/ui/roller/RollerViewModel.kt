package sheridan.jawedzak.assignment2.ui.roller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import sheridan.jawedzak.assignment2.database.GameScore
import sheridan.jawedzak.assignment2.database.GameScoreDao
import sheridan.jawedzak.assignment2.database.GameScoreDatabase
import kotlinx.coroutines.launch
import android.app.Application
import androidx.lifecycle.AndroidViewModel

class RollerViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel


    private val _gameScoreId = MutableLiveData<Long>().apply{
        value = 0L
    }

    val gameScoreId: LiveData<Long> = _gameScoreId

    private val gameScoreDao: GameScoreDao =
        GameScoreDatabase.getInstance(application).gameScoreDao

    fun send(gameScore: GameScore){
        viewModelScope.launch {
            _gameScoreId.value = gameScoreDao.insert(gameScore)
        }
    }

    fun reset(){
        _gameScoreId.value = 0L
    }
}