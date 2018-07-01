package com.example.thais.demowebservice.entidades

data class Producto (val id: Int? = null,
                val nombre: String,
                val precio: Double,
                val lote: Int,
                val stock: Int,
                val descripcion: String)