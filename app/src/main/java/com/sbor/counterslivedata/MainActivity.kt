package com.sbor.counterslivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.sbor.counterslivedata.adapter.PagerAdapter
import com.sbor.counterslivedata.databinding.ActivityMainBinding
import com.sbor.counterslivedata.fragments.FirstFragment
import com.sbor.counterslivedata.fragments.SecondFragment
import com.sbor.counterslivedata.fragments.ThirdFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var myViewPager2 = binding.viewPager2
        myViewPager2.offscreenPageLimit = 3
        var myAdapter = PagerAdapter(supportFragmentManager, lifecycle)

        myAdapter.addFragment(FirstFragment())
        myAdapter.addFragment(SecondFragment())
        myAdapter.addFragment(ThirdFragment())

        myViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        myViewPager2.adapter = myAdapter
        val indicator = binding.dotsIndicator
        indicator.attachTo(binding.viewPager2)
    }
}