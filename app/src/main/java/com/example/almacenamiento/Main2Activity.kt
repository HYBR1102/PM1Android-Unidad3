package com.example.almacenamiento

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val sharedPref = getSharedPreferences("mis_preferencias", Context.MODE_PRIVATE) ?: return
        var count = sharedPref.getInt("count", 0)

        Toast.makeText(this, "Count: ${count}", Toast.LENGTH_LONG).show()
    }

}
