package com.practicando.apppelicula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.practicando.apppelicula.fragments.FriendsFragment
import com.practicando.apppelicula.fragments.MessageFragment
import com.practicando.apppelicula.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawer : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar : Toolbar
    lateinit var DrawerLayout : DrawerLayout
    lateinit var navView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        DrawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, 0, 0
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    private fun setupFragments(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_profile -> setupFragments(ProfileFragment())
            R.id.nav_messages -> setupFragments(MessageFragment())
            R.id.nav_friends -> setupFragments(FriendsFragment())
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
