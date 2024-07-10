package com.example.effectivemobileapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.effectivemobileapplication.databinding.ActivityMainBinding
import com.example.effectivemobileapplication.di.MainActivityComponentProvider
import com.example.effectivemobileapplication.features.tickets.musicaltickets.getFragmentScreen
import com.example.effectivemobileapplication.navigation.MainMenuRouterImpl
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    private val navigator = AppNavigator(this, R.id.navFragment)

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MainActivityComponentProvider)
            .providerMainActivityComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }
        if (savedInstanceState==null){
            router.replaceScreen(getFragmentScreen())
        }
        val routerImpl=MainMenuRouterImpl(router)
        val test=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val test2=NavigationBarView.OnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_hotel->{
                    routerImpl.openHotels()
                    return@OnItemSelectedListener true
                }
                R.id.navigation_profile->{
                    routerImpl.openProfile()
                    return@OnItemSelectedListener true
                }
                R.id.navigation_subscribers->{
                    routerImpl.openSubscribers()
                    return@OnItemSelectedListener true
                }
                R.id.navigation_location->{
                    routerImpl.openGps()
                    return@OnItemSelectedListener true
                }
                R.id.navigation_tickets->{
                    routerImpl.openTickets()
                    return@OnItemSelectedListener true
                }
            }
            false
        }
        binding.bottomNavigation.setOnItemSelectedListener(test2)

    }
    override fun onResumeFragments() {
        super.onResumeFragments()

        navigationHolder.setNavigator(navigator)
    }
}