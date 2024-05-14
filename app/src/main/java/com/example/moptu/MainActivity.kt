package com.example.moptu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.moptu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener{
            val fragment = Fragment(R.layout.fragment_city_selection);
            replaceFragment(fragment)
        }

    }
    public fun handleOnGoMain (view : View) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        var find = findViewById<ConstraintLayout>(R.id.fragmentContainer)
        find.visibility = View.VISIBLE

        find = findViewById(R.id.dialog)
        find.visibility = View.GONE

        fragmentTransaction.commit()
    }
    public fun handleSelectCity (view: View) {
        replaceFragment(Fragment(this.resources.getIdentifier((view as Button).contentDescription as String, "layout", this.packageName)))
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        var find = findViewById<ConstraintLayout>(R.id.fragmentContainer)
        find.visibility = View.GONE

        find = findViewById(R.id.dialog)
        find.visibility = View.VISIBLE

        fragmentTransaction.replace(R.id.dialog, fragment)
        fragmentTransaction.commit()
    }

    fun handleOnGoMainMenu(item: MenuItem) {
        val fragment = Fragment(R.layout.fragment_city_selection);
        replaceFragment(fragment)
    }


}