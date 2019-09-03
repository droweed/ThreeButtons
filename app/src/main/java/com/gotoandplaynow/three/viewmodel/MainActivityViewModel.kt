package com.gotoandplaynow.three.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gotoandplaynow.three.model.MainModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    // main model for the binded view, in this case the MainActivity
    private var mainModel: MutableLiveData<MainModel>? = null

    // it is advised not to have any reference of the context in the ViewModel
//    private val context = getApplication<Application>().applicationContext

    // simulated fetched data from any source
    fun populateMockData() {
        mainModel = MutableLiveData()
        mainModel?.value = MainModel()
    }

    // mock update value
    // call the setter for the view title
    fun updateViewTitle(title: String?) {
        mainModel?.value?.setViewTitle(title)
    }

    // get the view model
    fun getMainModel(): LiveData<MainModel>? {
        return mainModel
    }
}