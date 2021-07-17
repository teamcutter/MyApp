package com.example.myapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.adapter.RecyclerAdapter
import com.example.myapp.databinding.FragmentCatalogBinding

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

        gridLayoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        binding.recycler.layoutManager = gridLayoutManager
        adapter = RecyclerAdapter()
        binding.recycler.adapter = adapter
    }

}