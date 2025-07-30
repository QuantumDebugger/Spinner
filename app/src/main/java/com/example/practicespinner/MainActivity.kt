package com.example.practicespinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // boiler code for spinner
        val customList = listOf("First","Second","Third","Fourth")
        val  adapter = ArrayAdapter<String>(this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,customList)

        val spin = findViewById<Spinner>(R.id.spMonths)
        spin.adapter = adapter



        // till here using boiler plate code


        // using string.xml file for spinner items
        val spinner = findViewById<Spinner>(R.id.spMonths)
        val months = resources.getStringArray(R.array.months)

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, "You selected ${customList[position]}",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // no need to implement
            }

            // till here (string.xml file)

            }
        }
}