package com.example.uefa_poc.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uefa_poc.models.SquadInfoModel
import com.example.uefa_poc.repositories.data.PlayerInfo

class SquadViewModel(private val model: SquadInfoModel) : ViewModel() {

    private lateinit var selectedTeam: String
    private val _squadInfo : MutableLiveData<HashMap<String, List<PlayerInfo>>> by lazy {
        MutableLiveData<HashMap<String,List<PlayerInfo>>>()
    }

    val squadInfo: LiveData<HashMap<String,List<PlayerInfo>>> = _squadInfo

    fun getSquadInfo() {
       val info = model.getSquadInfo(selectedTeam)
        _squadInfo.value = info
    }

    fun setSelectedTeam(teamName: String) {
        selectedTeam = teamName
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(private val model: SquadInfoModel) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SquadViewModel(model) as T
        }
    }
}