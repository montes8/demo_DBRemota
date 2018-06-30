package com.example.thais.demowebservice.fragments



import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Response
import com.android.volley.VolleyError

import com.example.thais.demowebservice.R
import org.json.JSONObject
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.JsonObjectRequest
import android.app.ProgressDialog
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


class DesarrolladorFragment : Fragment(), Response.Listener<JSONObject>,Response.ErrorListener {

    @Suppress("DEPRECATION")
    var progreso: ProgressDialog? = null
    var jsonObjectRequest: JsonObjectRequest? = null
    var request: RequestQueue? = null
    var miVista : View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        miVista = inflater.inflate(R.layout.fragment_desarrollador, container, false)

        val editDocumento = miVista?.findViewById<View>(R.id.editText_documento)
        val editNombre = miVista?.findViewById<View>(R.id.editText_nombre)
        val editProfecion = miVista?.findViewById<View>(R.id.idProfesion)
        val btnRegistrar = miVista?.findViewById<View>(R.id.btn_registrarusuario)


       request = Volley.newRequestQueue(getContext())


        btnRegistrar?.setOnClickListener {

            cargarWebService()
        }

        return miVista
    }
    override fun onResponse(response: JSONObject?) {

    }

    override fun onErrorResponse(error: VolleyError?) {

    }

    fun cargarWebService(){
        
    }
}
