package com.example.thais.demowebservice.interfaces

import com.example.thais.demowebservice.fragments.*

interface IFragments: BienvenidaFragment.OnFragmentInteractionListener, DesarrolladorFragment.OnFragmentInteractionListener,
        RegistrarUsuarioFragment.OnFragmentInteractionListener,ConsultaUsuarioFragment.OnFragmentInteractionListener,
        ConsultaListaUsuariosFragment.OnFragmentInteractionListener,ConsultarListausuarioImagenFragment.OnFragmentInteractionListener,
        ConsultaUsuarioUrlFragment.OnFragmentInteractionListener,ConsultaListaUsuarioImageUrlFragment.OnFragmentInteractionListener{
}