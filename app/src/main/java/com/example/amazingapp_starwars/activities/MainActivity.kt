package com.example.amazingapp_starwars.activities
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amazingapp.adapters.HeroAdapter
import com.example.amazingapp_starwars.R
import com.example.amazingapp_starwars.databinding.ActivityMainBinding
import com.example.domain.models.Hero
import com.example.amazingapp_starwars.presenters.HeroListPresenter
import com.example.amazingapp_starwars.views.HeroListView
import kotlinx.coroutines.DelicateCoroutinesApi
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(),HeroListView {
    lateinit var binding: ActivityMainBinding
    private val mAdapter = HeroAdapter()

    @InjectPresenter
   lateinit var heroListPresenter: HeroListPresenter

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setupAdapter()
       suspend {   heroListPresenter.fetchHeroes()}
    }

    private fun setupAdapter(){
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)

        binding.apply {
            recyclerHeroList.layoutManager = layoutManager
            recyclerHeroList.adapter = mAdapter
        }
    }
// View implemention
    override fun presentHeroes(data: List<Hero>) {
    binding.apply {
        recyclerHeroList.visibility = View.VISIBLE
        txtHeroListLoading.visibility = View.GONE
        mAdapter.setData(newHeroes = data)}

    }

    override fun presentLoading() {
        binding.apply {
            recyclerHeroList.visibility = View.GONE
            txtHeroListLoading.visibility = View.VISIBLE

        }
    }
}
