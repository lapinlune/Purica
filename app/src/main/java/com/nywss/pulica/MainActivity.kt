package com.nywss.pulica

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nywss.home.presentation.homepage.HomeFragment // Updated import
import com.nywss.pulica.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, HomeFragment())
                .commit()
        }

        binding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
            Toast.makeText(this, "Navigation icon clicked", Toast.LENGTH_SHORT).show()
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.favorite -> {
                    Toast.makeText(this, "Favorite clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}