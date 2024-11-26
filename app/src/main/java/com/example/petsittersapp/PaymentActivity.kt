package com.example.petsittersapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    private lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        userManager = UserManager(this)

        val petSitterName = intent.getStringExtra("name") ?: "Pet Sitter"
        val petSitterPrice = intent.getFloatExtra("price", 0.0f)

        val tvPaymentDetails: TextView = findViewById(R.id.tvPaymentDetails)
        val tvCareDetails: TextView = findViewById(R.id.tvCareDetails)

        tvPaymentDetails.text = "Contratar $petSitterName por R$ ${"%.2f".format(petSitterPrice)}"
        tvCareDetails.text = "Cuidados oferecidos: Passeio, alimentação, banho"

        findViewById<Button>(R.id.btnContract).setOnClickListener {
            val currentBalance = userManager.getUserBalance()

            if (currentBalance >= petSitterPrice) {
                val updatedBalance = currentBalance - petSitterPrice
                userManager.saveUserBalance(updatedBalance)

                Toast.makeText(this, "Contratação realizada com sucesso!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, ContractSuccessActivity::class.java)
                intent.putExtra("remainingBalance", updatedBalance) // Passa o saldo atualizado
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Saldo insuficiente!", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
