package com.example.myapp.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.adapter.RecyclerAdapter
import com.example.myapp.databinding.FragmentCatalogBinding
import com.example.myapp.dataclasses.CardItem

class CatalogFragment : Fragment() {
    lateinit var binding: FragmentCatalogBinding
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val displayList = arrayListOf<CardItem>()
        val arrayList = arrayListOf<CardItem>()
        arrayList.add(CardItem("Food", R.drawable.ic_diet))
        arrayList.add(CardItem("Clothes", R.drawable.ic_clothes))
        arrayList.add(CardItem("Car", R.drawable.ic_car))
        arrayList.add(CardItem("Laptop", R.drawable.ic_laptop))
        arrayList.add(CardItem("Phone", R.drawable.ic_phone))
        arrayList.add(CardItem("Other", R.drawable.ic_other))
        arrayList.add(CardItem("Desktop", R.drawable.ic_desktop))
        arrayList.add(CardItem("Trip", R.drawable.ic_trip))
        arrayList.add(CardItem("Booking", R.drawable.ic_hotel))
        arrayList.add(CardItem("Tools", R.drawable.ic_repair_tools))
        arrayList.add(CardItem("Rent", R.drawable.ic_rent))
        arrayList.add(CardItem("Delivery", R.drawable.ic_delivery_truck))

        displayList.addAll(arrayList)

        // выводим массив объектов в виде таблицы (GridLayoutManager)
        gridLayoutManager = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
        binding.recycler.layoutManager = gridLayoutManager
        adapter = RecyclerAdapter(displayList)
        binding.recycler.adapter = adapter

        binding.searchEditTextBtn.setOnClickListener {
            it.isSelected = !it.isSelected
            when(it.isSelected){
                true -> {
                    // берет EditText в фокус
                    binding.searchEditText.requestFocus()
                    binding.searchEditText.showKeyboard()
                }
                false -> {
                    // забирает фокус у EditText
                    binding.searchEditText.clearFocus()
                    binding.searchEditText.hideKeyboard()
                }
            }
        }

        binding.searchEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
            }

            // слушатель изменений для edit text
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(s.toString().isNotEmpty()){
                    displayList.clear()
                    arrayList.forEach {
                        if(it.title.toLowerCase().contains(s.toString().toLowerCase()))
                            displayList.add(it)
                    }
                    // корректно сохраняет и выводит новые данные
                    binding.recycler.adapter!!.notifyDataSetChanged()
                }
                else {
                    displayList.clear()
                    displayList.addAll(arrayList)
                    // корректно сохраняет и выводит новые данные
                    binding.recycler.adapter!!.notifyDataSetChanged()
                }
            }

        })
    }

    // вызов клавиатуры
    fun View.showKeyboard() {
        this.requestFocus()
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
    // прячем клавиатуру
    fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }
}

