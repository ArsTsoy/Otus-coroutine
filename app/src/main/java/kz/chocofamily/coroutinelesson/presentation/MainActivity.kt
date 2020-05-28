package kz.chocofamily.coroutinelesson.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
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
        bottomNavView.setupWithNavController(navController)
        bottomNavView.selectedItemId = R.id.menuFragment2

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.loginFragment -> hideBnv()
                R.id.someFlowFragment -> hideBnv()
                else -> showBnv()
            }
        }
    }


    private fun showBnv() {
        bottomNavView.visibility = View.VISIBLE
    }

    private fun hideBnv() {
        bottomNavView.visibility = View.GONE
    }
}
