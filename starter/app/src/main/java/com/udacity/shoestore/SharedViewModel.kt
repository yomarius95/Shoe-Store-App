package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList : LiveData<ArrayList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = arrayListOf(
            Shoe(0,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(1,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(2,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(3,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(4,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(5,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(6,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(7,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(8,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(9,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(10,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(11,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(12,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(13,"Adidas Neo", 8.5, "Adidas", "Description"),
            Shoe(14,"Adidas Neo", 8.5, "Adidas", "Description")
        )
    }
}