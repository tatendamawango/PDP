package edu.ktu.pdp.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.ktu.pdp.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostController= supportFragmentManager.findFragmentById(R.id.fragment_layout) as NavHostFragment
        navController = navHostController.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        var isWorker = randomBoolean()

        if (isWorker) {
            val navInflater = navController.navInflater
            val graph = navInflater.inflate(R.navigation.nav_graph_worker)
            navController.graph = graph

            bottomNavigationView.menu.clear()
            bottomNavigationView.inflateMenu(R.menu.worker_nav)
        } else {
            val navInflater = navController.navInflater
            val graph = navInflater.inflate(R.navigation.nav_graph_manager)
            navController.graph = graph

            bottomNavigationView.menu.clear()
            bottomNavigationView.inflateMenu(R.menu.manager_nav)
        }
        setupWithNavController(bottomNavigationView, navController)
    }
    private fun randomBoolean(): Boolean {
        return listOf(true, false).random()
    }

}