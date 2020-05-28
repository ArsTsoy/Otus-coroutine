package kz.chocofamily.coroutinelesson.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import kz.chocofamily.coroutinelesson.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(this, R.id.flowNavHost)
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }
}
