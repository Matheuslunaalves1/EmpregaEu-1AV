package com.example.recifefit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.empregaeu4.Tela2Activity
import com.example.recifefitness.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btLogin.setOnClickListener {
            val navegarTelaInicial = Intent(this, Tela2Activity::class.java)
            startActivity(navegarTelaInicial)

        }
        val database = Firebase.database
        val myRef = database.getReference("message")
        myRef.setValue("hello, world!")
    }
}
