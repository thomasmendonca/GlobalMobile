package com.example.globalmobile

import TilapiaAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inicializa a RecyclerView
        recyclerView = findViewById(R.id.rvTilapias)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cria uma instância da API utilizando Retrofit
        val tilapiaApi = RetrofitInstance.retrofit.create(TilapiaApi::class.java)

        // Faz a chamada à API para obter a lista de Tilápias
        tilapiaApi.getTilapias().enqueue(object : Callback<List<Tilapia>> {
            override fun onResponse(call: Call<List<Tilapia>>, response: Response<List<Tilapia>>) {
                if (response.isSuccessful) {
                    // Obtém a lista de Tilápias da resposta
                    val tilapias = response.body() ?: emptyList()
                    // Configura o adapter com a lista de Tilápias
                    val adapter = TilapiaAdapter(tilapias)
                    recyclerView.adapter = adapter
                } else {
                    // Exibe uma mensagem de erro apropriada
                    Toast.makeText(this@HomeActivity, "Erro: ${response.code()} - ${response.message()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Tilapia>>, t: Throwable) {
                // Exibe uma mensagem de falha em caso de erro na chamada
                Toast.makeText(this@HomeActivity, "Falha: ${t.message ?: "Erro desconhecido"}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
