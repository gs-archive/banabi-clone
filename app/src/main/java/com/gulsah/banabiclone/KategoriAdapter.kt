package com.gulsah.banabiclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KategoriAdapter(var mContext: Context, var kategoriListe: List<Kategoriler>) :
    RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(view: View) : RecyclerView.ViewHolder(view) {
        var textViewKategori: TextView
        var imageView: ImageView

        init {
            textViewKategori = view.findViewById(R.id.textViewKategori)
            imageView = view.findViewById(R.id.imageViewKategori)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater =
            LayoutInflater.from(mContext).inflate(R.layout.card_kategori, parent, false)
        return CardTasarimTutucu(layoutInflater)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        var nesne = kategoriListe[position]
        holder.textViewKategori.text = nesne.kategoriAdi
        holder.imageView.setImageResource(
            mContext.resources.getIdentifier(
                nesne.resim,
                "drawable",
                mContext.packageName
            )
        )
    }

    override fun getItemCount(): Int {
        return kategoriListe.size
    }
}