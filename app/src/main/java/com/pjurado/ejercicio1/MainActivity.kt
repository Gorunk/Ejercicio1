package com.pjurado.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pjurado.ejercicio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val lista = (1..100).map {Persona(
        "Nombre $it",
        "$it$it$it$it$it$it",
        "email$it@gmail.com",
        "https://loremflickr.com/240/320/man?lock=$it")}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recycler.adapter = AdapterPersona(lista) { persona ->
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.PERSONA_EXTRA, persona)
                startActivity(intent)
            }
        }


    }
}