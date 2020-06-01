package com.practicando.apppelicula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        btOkLogin.setOnClickListener {
            val intent = Intent(this, NavigationDrawer::class.java)
            intent.putExtra("name",etNameLogin.text.toString())
            startActivity(intent)
        }
    }
}
