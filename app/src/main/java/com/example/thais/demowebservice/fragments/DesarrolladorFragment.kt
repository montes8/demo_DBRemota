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
import com.android.volley.toolbox.JsonObjectRequest
import android.app.ProgressDialog
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_registrar_usuario.*


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

        Toast.makeText(getContext(),"se ha registrado correctamente",Toast.LENGTH_LONG).show()
       progreso?.hide()
        editText_documento.setText("")
        editText_nombre.setText("")
        editText_profesion.setText("")
    }

    override fun onErrorResponse(error: VolleyError?) {

        progreso?.hide()
        Toast.makeText(getContext(),"se ha registrado correctamente"+error.toString(),Toast.LENGTH_LONG).show()
        Log.d("error",error.toString())
    }

    fun cargarWebService(){

        progreso = ProgressDialog(getContext())
        progreso?.setMessage("cargando ...")
        progreso?.show()

        var url = "http://192.168.137.1/ejemploBDRemota/JSONRegistro.php?documento="+editText_documento.getText().toString()+"&nombre="+editText_nombre.getText().toString()+"&profesion="+editText_profesion.getText().toString()

        url=url.replace(" ","%20")

        jsonObjectRequest = JsonObjectRequest(Request.Method.GET,url,null,this,this)
        request?.add(jsonObjectRequest)
    }
}
