package com.example.thais.demowebservice


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import android.view.MenuItem
import com.example.thais.demowebservice.fragments.*
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    lateinit var drawerLayout : DrawerLayout
    lateinit var navigationView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawer_layout)//traemos la vista de nuestro draerLayout
        navigationView = findViewById(R.id.navigationView)

        setSupportActionBar(mToolbar_home)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_navigation)//definimco que imagen queremos llamr la imagen
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)//habilitamos el icono
        cambiarFragmento(BienvenidaFragment(),navigationView?.menu.getItem(0))
        navegacionDrawer()
    }


    //registramos evento navigationDrawer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                drawerLayout!!.openDrawer(GravityCompat.START)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun cambiarFragmento(fragment: Fragment?, item:MenuItem){
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_frame,fragment)
                .commit()
        item.isChecked = true
        supportActionBar!!.title = item.title
    }

    fun navegacionDrawer(){
        navigationView.setNavigationItemSelectedListener { item ->
            var gestorDeFragmentos = false
            var fragment : Fragment? = null
            when (item.itemId) {
                R.id.nav_inicio -> {
                    fragment = BienvenidaFragment()
                    gestorDeFragmentos = true
                }
                R.id.nav_registro -> {
                    fragment = RegistarProductoFragment()
                    gestorDeFragmentos = true
                }
                R.id.nav_desarrollador -> {
                   fragment = DesarrolladorFragment()
                    gestorDeFragmentos = true
                }
                R.id.nav_producto_id ->{
                    fragment = ConsultarProductoIdFragment()
                    gestorDeFragmentos = true
                }

            }
            if (gestorDeFragmentos){
                cambiarFragmento(fragment,item)
                drawerLayout?.closeDrawers()
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        return true
    }


}
