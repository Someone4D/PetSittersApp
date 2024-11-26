package com.example.petsittersapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petsittersapp.databinding.ActivityLoginSuccessBinding

class LoginSuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginSuccessBinding
    private lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userManager = UserManager(this)

        val userName = userManager.getUserName() ?: "Usuário"
        val userBalance = userManager.getUserBalance()

        binding.tvWelcomeMessage.text = "Bem-vindo(a), $userName!"
        binding.tvUserBalance.text = "Saldo disponível: R$ ${"%.2f".format(userBalance)}"

        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnViewPetSitters.setOnClickListener {
            val intent = Intent(this, PetSittersActivity::class.java)
            startActivity(intent)
        }
    }
}
