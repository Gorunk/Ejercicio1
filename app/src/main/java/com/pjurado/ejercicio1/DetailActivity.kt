package com.pjurado.ejercicio1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pjurado.ejercicio1.databinding.ActivityDetailBinding
import com.pjurado.ejercicio1.databinding.ActivityMainBinding
import java.lang.Exception as Exception1

class DetailActivity : AppCompatActivity() {

    companion object{
        const val PERSONA_EXTRA = "persona"
    }

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater).apply {
            setContentView(root)
            val persona = intent?.getParcelableExtra<Persona>(PERSONA_EXTRA) ?: throw IllegalStateException()
            imagen.glide(persona.urlFoto)

            tvNombre.text = persona?.nombre
            button1.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${persona.email}"))
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
            button2.setOnClickListener{

            }
        }


    }
}