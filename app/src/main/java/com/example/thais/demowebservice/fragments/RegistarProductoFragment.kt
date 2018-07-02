package com.example.thais.demowebservice.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.thais.demowebservice.ProductoService

import com.example.thais.demowebservice.R
import com.example.thais.demowebservice.entidades.Producto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegistarProductoFragment : Fragment() {
    var miVista : View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      miVista = inflater.inflate(R.layout.fragment_registrar_producto_id, container, false)


        return miVista
    }


}
