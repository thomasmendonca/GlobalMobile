package com.example.globalmobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(){

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inicializa a TextView
        textView = findViewById(R.id.textView)

        // Cria uma instância da API utilizando Retrofit
        val tilapiaApi = RetrofitInstance.retrofit.create(TilapiaApi::class.java)

        // Faz a chamada à API para obter a lista de Tilápias
        tilapiaApi.getTilapias().enqueue(object : Callback<List<Tilapia>> {
            override fun onResponse(call: Call<List<Tilapia>>, response: Response<List<Tilapia>>) {
                if (response.isSuccessful) {
                    // Obtém a lista de Tilápias da resposta
                    val tilapias = response.body()
                    // Exibe a lista na TextView
                    textView.text = tilapias?.joinToString("\n") { "ID: ${it.id}, Doente: ${it.isDoente}" } ?: "Nenhuma tilápia encontrada."
                } else {
                    // Exibe um código de erro caso a resposta não seja bem-sucedida
                    textView.text = "Erro: ${response.code()} - ${response.message()}"
                }
            }

            override fun onFailure(call: Call<List<Tilapia>>, t: Throwable) {
                // Exibe uma mensagem de falha em caso de erro na chamada
                textView.text = "Falha: ${t.message ?: "Erro desconhecido"}"
            }
        })

    }
}