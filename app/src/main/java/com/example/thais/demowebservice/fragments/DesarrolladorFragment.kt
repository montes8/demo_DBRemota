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


class DesarrolladorFragment : Fragment(){



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        miVista = inflater.inflate(R.layout.fragment_desarrollador, container, false)






        return miVista
    }

}
