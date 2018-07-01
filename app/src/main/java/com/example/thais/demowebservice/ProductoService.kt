package com.example.thais.demowebservice

import com.example.thais.demowebservice.entidades.Producto
import retrofit2.Call
import retrofit2.http.*

interface ProductoService {

    @GET("productos")
    fun obtenerProductos(): Call<ArrayList<Producto>>

    @GET("productos/{idProducto}")
    fun obtenerProductoSegunId(@Path("idProducto") idProducto: Int): Call<Producto>

    @POST("productos")
    fun registrar(@Body producto: Producto): Call<Void>

    @PUT("productos/{idProducto}")
    fun actualizar(@Path("idProducto") idProducto: Int,
                   @Body producto: Producto): Call<Void>

    @DELETE("productos/{idProducto}")
    fun eliminar(@Path("idProducto") idProducto: Int): Call<Void>

    companion object {

        fun create(): ProductoService {
            return RetrofitFactory
                    .obtenerInstanciaRetrofit()
                    .create(ProductoService::class.java)
        }
    }
}