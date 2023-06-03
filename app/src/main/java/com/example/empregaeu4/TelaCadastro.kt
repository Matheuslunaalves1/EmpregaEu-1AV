package com.example.empregaeu4


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recifefitness.databinding.TelaCadastroBinding
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



 class TelaCadastro : AppCompatActivity() {
    private lateinit var binding : TelaCadastroBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edusuario = binding.edUsuario
        val edemail = binding.edEmail
        val edsenha = binding.edSenha
        val btCadatrar = binding.btLogin


        dbRef = FirebaseDatabase.getInstance().getReference("Usuario")

        btCadatrar.setOnClickListener {
            val empName = edusuario.text.toString()
            val empEmail = edemail.text.toString()
            val empsenha = edsenha.text.toString()

            if (empName.isEmpty()) {
                edusuario.error = "Por favor insira seu nome"
            }
            if (empEmail.isEmpty()) {
                edemail.error = "Por favor insira um email"
            }
            if (empsenha.isEmpty()) {
                edsenha.error = "Por favor insira uma senha"
            }

            val empId = dbRef.push().key!!

            val usuario = UserModelo(empName, empEmail, empsenha)

            dbRef.child(empId).setValue(usuario)
                .addOnCompleteListener {
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edusuario.text.clear()
                    edemail.text.clear()
                    edsenha.text.clear()

                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }


            binding.btLogin.setOnClickListener {
                val navegarTelaInicial = Intent(this, Tela2Activity::class.java)
                startActivity(navegarTelaInicial)

            }


        }

    }
    }





