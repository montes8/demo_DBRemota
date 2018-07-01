package com.example.thais.demowebservice.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thais.demowebservice.R


class ConsultarProductoIdFragment : Fragment(){

    var miVista : View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        miVista = inflater.inflate(R.layout.fragment_registrar_usuario, container, false)

        val editDocumento = miVista?.findViewById<View>(R.id.editText_documento)
        val editNombre = miVista?.findViewById<View>(R.id.editText_nombre)
        val editProfecion = miVista?.findViewById<View>(R.id.idProfesion)
        val btnRegistrar = miVista?.findViewById<View>(R.id.btn_registrarusuario)



        return miVista
    }

}
