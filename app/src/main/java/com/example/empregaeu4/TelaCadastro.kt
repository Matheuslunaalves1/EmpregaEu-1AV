package com.example.empregaeu4


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.empregaeu4.databinding.TelaCadastroBinding

class TelaCadastro : AppCompatActivity() {

    private lateinit var binding: TelaCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener {
            val navegarTelaInicial = Intent(this,Tela2Activity::class.java)
            startActivity(navegarTelaInicial)
        }
    }
}

