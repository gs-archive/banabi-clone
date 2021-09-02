package com.gulsah.banabiclone

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FirsatAdapter(var mContext: Context, var firsaListesi: List<FirsatNesne>) :
    RecyclerView.Adapter<FirsatAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(view: View) : RecyclerView.ViewHolder(view) {
        var cardView: CardView
        var textViewUrunAd: TextView
        var textViewUrunFiyat: TextView
        var textViewUrunFiyatİndirim: TextView
        var imageView: ImageView
        var imageViewSepet: ImageView

        init {
            cardView = view.findViewById(R.id.cardView)
            textViewUrunAd = view.findViewById(R.id.textViewUrunAd)
            textViewUrunFiyat = view.findViewById(R.id.textViewUrunFiyat)
            textViewUrunFiyatİndirim = view.findViewById(R.id.textViewUrunIndirimliFiyat)
            imageView = view.findViewById(R.id.imageViewUrun)
            imageViewSepet = view.findViewById(R.id.imageViewSepeteEkle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater =
            LayoutInflater.from(mContext).inflate(R.layout.card_view_firsat, parent, false)
        return CardTasarimTutucu(layoutInflater)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        var nesne = firsaListesi[position]
        holder.textViewUrunAd.text = nesne.urun_ad
        holder.textViewUrunFiyat.text = nesne.urun_fiyat.toString()
        holder.textViewUrunFiyatİndirim.text = nesne.urun_ind_fiyat.toString()
        holder.textViewUrunFiyat.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
        holder.imageView.setImageResource(
            mContext.resources.getIdentifier(
                nesne.resim,
                "drawable",
                mContext.packageName
            )
        )
        holder.imageViewSepet.setOnClickListener {
            Toast.makeText(mContext, " ${nesne.urun_ad} sepete eklendi", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return firsaListesi.size
    }


}