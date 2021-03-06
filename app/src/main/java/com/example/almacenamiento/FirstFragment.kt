package com.example.almacenamiento

import android.content.ContentValues
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGuardar.setOnClickListener {
            GuardarAlumno()
        }
    }

    private fun GuardarAlumno() {
        val dbHelper = context?.let { BDAlumnos(it) }
        val db = dbHelper?.writableDatabase
        //execSQL-----------------------------------------------------------------------------------
        //db?.execSQL("INSERT INTO Alumnos VALUES('${etControl.text}', '${etNombre.text}')")

        //insert------------------------------------------------------------------------------------
        val values = ContentValues().apply {
            put("control", etControl.text.toString())
            put("nombre", etNombre.text.toString())
        }
        val newRowId = db?.insert("Alumnos", null, values)

        etControl.text.clear()
        etNombre.text.clear()

        view?. let { Snackbar.make(it, "¡Alumno guardado!", Snackbar.LENGTH_LONG).show() }

        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}
