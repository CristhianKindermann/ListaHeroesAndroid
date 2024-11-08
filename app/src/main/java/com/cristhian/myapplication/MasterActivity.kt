package com.cristhian.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MasterActivity : AppCompatActivity() {
    private val heroes = listOf(
        Hero("Homem de Ferro", "Marvel", R.drawable.ironman, "Detalhes sobre o Homem de Ferro..."),
        Hero("Capitão América", "Marvel", R.drawable.drstrange, "Detalhes sobre o Capitão América..."),
        
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)
        val recyclerView: RecyclerView = findViewById(R.id.heroesRV) // Alteração aqui
        recyclerView.adapter = HeroAdapter(heroes, this)
        recyclerView.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }


}