package com.example.submissionjetpackpro.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submissionjetpackpro.R
import com.example.submissionjetpackpro.databinding.ActivityMainBinding
import com.example.submissionjetpackpro.fragment.movies.MoviesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moviesFragment = MoviesFragment()

        makeCurrentFragment(moviesFragment)
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.movie_menu -> makeCurrentFragment(moviesFragment)
                R.id.favorite_menu -> {
                    val uri = Uri.parse("example://favorites")
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                }
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_content, fragment)
            commit()
        }
    }
}