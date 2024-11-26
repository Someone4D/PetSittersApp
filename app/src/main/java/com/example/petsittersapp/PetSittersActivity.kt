package com.example.petsittersapp

import PetSitter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petsittersapp.databinding.ActivityPetSittersBinding

class PetSittersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPetSittersBinding
    private lateinit var petSittersAdapter: PetSittersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetSittersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val petSitters = listOf(
            PetSitter("João", "Amante de animais!", "São Paulo", 4.5f, 50.0f),
            PetSitter("Maria", "Cuidarei do seu pet como se fosse meu.", "Rio de Janeiro", 4.8f, 60.0f),
            PetSitter("Carlos", "Mais de 5 anos de experiência.", "Belo Horizonte", 4.2f, 100.0f)
        )

        petSittersAdapter = PetSittersAdapter(petSitters)
        binding.rvPetSitters.layoutManager = LinearLayoutManager(this)
        binding.rvPetSitters.adapter = petSittersAdapter

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
