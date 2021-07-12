package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.fragments.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val catalogFragment = CatalogFragment()
    val profileFragment = ProfileFragment()
    val status: String = "admin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makeCurrentFragment(catalogFragment)
        binding.bottomNavigationMenu.selectedItemId = R.id.miCatalog
        binding.bottomNavigationMenu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miCatalog -> makeCurrentFragment(catalogFragment)
                R.id.miProfile -> makeCurrentFragment(profileFragment)
                R.id.miSettings -> {}
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}