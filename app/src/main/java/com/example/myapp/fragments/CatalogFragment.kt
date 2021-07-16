package com.example.myapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapp.R
import com.example.myapp.databinding.FragmentCatalogBinding

class CatalogFragment : Fragment() {
    // Checked!!!
    lateinit var binding: FragmentCatalogBinding

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

        binding.drawMenuBtn.setOnClickListener(){
            Toast.makeText(context, "Menu!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn1.setOnClickListener {
            Toast.makeText(context, "Food!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn2.setOnClickListener {
            Toast.makeText(context, "Clothes!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn3.setOnClickListener {
            Toast.makeText(context, "Desktop!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn4.setOnClickListener {
            Toast.makeText(context, "Laptop!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn5.setOnClickListener {
            Toast.makeText(context, "Phone!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn6.setOnClickListener {
            Toast.makeText(context, "Other!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn7.setOnClickListener {
            Toast.makeText(context, "Car!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn8.setOnClickListener {
            Toast.makeText(context, "Trip!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn9.setOnClickListener {
            Toast.makeText(context, "Booking!", Toast.LENGTH_SHORT).show()
        }

        binding.catalogBtn10.setOnClickListener {
            Toast.makeText(context, "Repair!", Toast.LENGTH_SHORT).show()
        }
    }

}