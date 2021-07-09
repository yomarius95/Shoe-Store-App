package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList : LiveData<ArrayList<Shoe>>
        get() = _shoeList

    val shoe = MutableLiveData(Shoe())

    init {
        _shoeList.value = ArrayList()
    }

    fun validateData(): Boolean {
        if(shoe.value?.name != "" && shoe.value?.size != 0.0 && shoe.value?.company != "" && shoe.value?.description != "") {
            saveShoe()
            return true
        }
        return false
    }

    private fun saveShoe() {
        shoe.value?.shoeId = _shoeList.value!!.size
        _shoeList.value?.add(shoe.value!!)
        shoe.value = Shoe()
    }

    fun onCancel() {
        shoe.value = Shoe()
    }
}