package com.example.mvvmformattendancefgd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmformattendancefgd.model.AttedanceModel

class AttadanceViewModel: ViewModel() {
    private val _attedanceData = MutableLiveData<AttedanceModel>()
    val attedanceData : LiveData<AttedanceModel> get() = _attedanceData

//    Funsi Menyimpan Data Peserta
    fun setAttadance(model: AttedanceModel){
        _attedanceData.value = model
    }
}