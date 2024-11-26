package com.example.petsittersapp

import PetSitter
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petsittersapp.databinding.ItemPetSitterBinding

class PetSittersAdapter(private val petSitters: List<PetSitter>) :
    RecyclerView.Adapter<PetSittersAdapter.PetSitterViewHolder>() {

    inner class PetSitterViewHolder(private val binding: ItemPetSitterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(petSitter: PetSitter) {
            binding.tvPetSitterName.text = petSitter.name
            binding.tvPetSitterBio.text = petSitter.bio
            binding.tvPetSitterLocation.text = petSitter.location
            binding.tvPetSitterRating.text = "⭐ ${petSitter.rating}"
            binding.tvPetSitterPrice.text = "R$ ${"%.2f".format(petSitter.price)}"

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, PetSitterDetailActivity::class.java)
                intent.putExtra("name", petSitter.name)
                intent.putExtra("bio", petSitter.bio)
                intent.putExtra("location", petSitter.location)
                intent.putExtra("rating", petSitter.rating)
                intent.putExtra("price", petSitter.price)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetSitterViewHolder {
        val binding = ItemPetSitterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PetSitterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PetSitterViewHolder, position: Int) {
        holder.bind(petSitters[position])
    }

    override fun getItemCount(): Int = petSitters.size
}
