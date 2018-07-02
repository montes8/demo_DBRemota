package com.example.thais.demowebservice.fragments



import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thais.demowebservice.R


class DesarrolladorFragment : Fragment(){

   var miVista : View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        miVista = inflater.inflate(R.layout.fragment_desarrollador, container, false)

        return miVista
    }

}
