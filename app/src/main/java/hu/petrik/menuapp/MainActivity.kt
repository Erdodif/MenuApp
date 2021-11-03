package hu.petrik.menuapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hu.petrik.menuapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.buttonNev.setOnClickListener{
            val intent = Intent(this,SecondaryActivity::class.java)
            startActivity(intent)
            finish()
        }
        bind.buttonInformacio.setOnClickListener{
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val seged = prefs.getString("nev","Nincs név megadva")
            Toast.makeText(this, seged, Toast.LENGTH_SHORT).show()
        }
    }
}