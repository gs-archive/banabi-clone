package com.gulsah.banabiclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_home_page.view.*

class HomePageFragment : Fragment() {
    private lateinit var tasarim: View
    private lateinit var firsatListesi: ArrayList<FirsatNesne>
    private lateinit var kategoriListesi: ArrayList<Kategoriler>
    private lateinit var adapter: FirsatAdapter
    private lateinit var adapterKategori: KategoriAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim = inflater.inflate(R.layout.fragment_home_page, container, false)

        tasarim.rvFirsat.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        tasarim.rvKategoriler.layoutManager =
            StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)

        firsatListesi = ArrayList()
        kategoriListesi = ArrayList()

        val k0 = Kategoriler("Favorilerim", "star")
        val k1 = Kategoriler("Su", "su")
        val k2 = Kategoriler("Atıştırmalık", "atistirmalik")
        val k3 = Kategoriler("Dondurma", "dondurma")
        val k4 = Kategoriler("İçecek", "icecek")
        val k5 = Kategoriler("Süt ve Kahvaltılık", "sut")
        val k6 = Kategoriler("Meyve & Sebze", "meyve")
        val k7 = Kategoriler("Fırından", "firindan")
        val k8 = Kategoriler("Taze Yemek", "taze")
        val k9 = Kategoriler("Temel Gıda", "temel")
        val k10 = Kategoriler("Fit & Form", "fit")
        val k11 = Kategoriler("Kişisel Bakım", "kisisel")
        val k12 = Kategoriler("Ev Bakım", "ev")
        val k13 = Kategoriler("Evcil Hayvan", "hayvan")
        val k14 = Kategoriler("Bebek", "bebek")
        val k15 = Kategoriler("Teknoloji", "teknoloji")

        val f1 = FirsatNesne("Eti Ballı Cevizli Pasta", 14.95, 11.95, "pasta")
        val f2 = FirsatNesne("Haribo Altın Ayıcık", 5.45, 4.25, "haribo")
        val f3 = FirsatNesne("İçim Orman Meyveli Kefir", 5.95, 4.55, "icim")

        firsatListesi.add(f1)
        firsatListesi.add(f2)
        firsatListesi.add(f3)

        kategoriListesi.add(k0)
        kategoriListesi.add(k1)
        kategoriListesi.add(k2)
        kategoriListesi.add(k3)
        kategoriListesi.add(k4)
        kategoriListesi.add(k5)
        kategoriListesi.add(k6)
        kategoriListesi.add(k7)
        kategoriListesi.add(k8)
        kategoriListesi.add(k9)
        kategoriListesi.add(k10)
        kategoriListesi.add(k11)
        kategoriListesi.add(k12)
        kategoriListesi.add(k13)
        kategoriListesi.add(k14)
        kategoriListesi.add(k15)


        adapterKategori = KategoriAdapter(requireContext(), kategoriListesi)
        adapter = FirsatAdapter(requireContext(), firsatListesi)
        tasarim.rvFirsat.adapter = adapter
        tasarim.rvKategoriler.adapter = adapterKategori


        return tasarim
    }
}