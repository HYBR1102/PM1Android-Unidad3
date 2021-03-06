package com.example.almacenamiento

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbHelper = context?.let { BDAlumnos(it) }
        val db = dbHelper?.readableDatabase
        val cursor = db?.rawQuery("SELECT * FROM Alumnos ORDER BY nombre", null)

        //val cursor = db?.query()

        var control: String = ""
        var nombre: String = ""
        if(cursor != null) {
            while(cursor.moveToNext()) {
                control = cursor.getString(cursor.getColumnIndex("control"))
                nombre = cursor.getString(cursor.getColumnIndex("nombre"))

                Log.e("SecondFragment", "Control ${control}, Nombre: ${nombre}")
            }
        }
    }
}
