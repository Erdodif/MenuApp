package hu.petrik.menuapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hu.petrik.menuapp.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.buttonMentes.setOnClickListener {
            val text = bind.editTextNev.text.toString()
            if(text==""){
                Toast.makeText(this, "Adj meg egy nevet!", Toast.LENGTH_SHORT).show()
            }
            else{
                val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
                val editor = prefs.edit()
                editor.putString("nev",text)
                editor.apply()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}