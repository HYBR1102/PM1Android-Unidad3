package com.example.almacenamiento

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import com.example.almacenamiento.Main2Activity as Main2Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            IncrementarCount()
            startActivity(Intent(this, Main2Activity::class.java))
        }

//        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
//        with (sharedPref.edit()) {
//            putInt("count", 0)
//            commit()
//        }

        val sharedPref = getSharedPreferences("mis_preferencias", Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt("count", 0)
            commit()
        }
    }

    private fun IncrementarCount() {
//        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        val sharedPref = getSharedPreferences("mis_preferencias", Context.MODE_PRIVATE) ?: return
        var count = sharedPref.getInt("count", 0)

        Toast.makeText(this, "Count: ${count}", Toast.LENGTH_LONG).show()

        count += 1
        with (sharedPref.edit()) {
            putInt("count", count)
            commit()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
