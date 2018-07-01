package com.example.thais.demowebservice.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.thais.demowebservice.ProductoService

import com.example.thais.demowebservice.R
import com.example.thais.demowebservice.entidades.Producto
import kotlinx.android.synthetic.main.activity_demo.*
import kotlinx.android.synthetic.main.fragment_bienvenida.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BienvenidaFragment : Fragment() {
    var miVista : View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        miVista = inflater.inflate(R.layout.fragment_bienvenida, container, false)

        val galaxyService = ProductoService.create()

        val respuestaCallback = galaxyService.obtenerProductos()

        respuestaCallback.enqueue(object: Callback<ArrayList<Producto>> {
            override fun onResponse(call: Call<ArrayList<Producto>>?, response: Response<ArrayList<Producto>>?) {
                val listaProductos = response?.body()
                Log.d("lista",""+listaProductos)
                Toast.makeText(context,"lista productos cargada",Toast.LENGTH_LONG).show()
                bienvenida.text = listaProductos.toString()
            }
            override fun onFailure(call: Call<ArrayList<Producto>>?, t: Throwable?) {
                Toast.makeText(context,"errorrr", Toast.LENGTH_LONG).show()

            }
        })


        return miVista
    }




}
