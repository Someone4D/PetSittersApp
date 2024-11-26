package com.example.petsittersapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PetSitterDetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_sitter_detail)

        val petSitterName = intent.getStringExtra("name")
        val petSitterBio = intent.getStringExtra("bio")
        val petSitterLocation = intent.getStringExtra("location")
        val petSitterRating = intent.getFloatExtra("rating", 0.0f)
        val petSitterPrice = intent.getFloatExtra("price", 0.0f)

        val tvPetSitterName: TextView = findViewById(R.id.tvDetailPetSitterName)
        val tvPetSitterBio: TextView = findViewById(R.id.tvDetailPetSitterBio)
        val tvPetSitterLocation: TextView = findViewById(R.id.tvDetailPetSitterLocation)
        val tvPetSitterRating: TextView = findViewById(R.id.tvDetailPetSitterRating)
        val tvPetSitterPrice: TextView = findViewById(R.id.tvDetailPetSitterPrice)
        val btnHire: Button = findViewById(R.id.btnContractService)
        val btnBack: Button = findViewById(R.id.btnBack)

        tvPetSitterName.text = petSitterName
        tvPetSitterBio.text = petSitterBio
        tvPetSitterLocation.text = petSitterLocation
        tvPetSitterRating.text = petSitterRating.toString()
        tvPetSitterPrice.text = "R$ ${"%.2f".format(petSitterPrice)}"

        val starImages = arrayOf(
            findViewById<ImageView>(R.id.star1),
            findViewById<ImageView>(R.id.star2),
            findViewById<ImageView>(R.id.star3),
            findViewById<ImageView>(R.id.star4),
            findViewById<ImageView>(R.id.star5)
        )

        for (i in starImages.indices) {
            if (i < petSitterRating) {
                starImages[i].setImageResource(R.drawable.ic_star_filled)
            } else {
                starImages[i].setImageResource(R.drawable.ic_star_empty)
            }
        }

        btnHire.setOnClickListener {
            val paymentIntent = Intent(this, PaymentActivity::class.java)
            paymentIntent.putExtra("name", petSitterName)
            paymentIntent.putExtra("price", petSitterPrice)
            startActivity(paymentIntent)
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}
