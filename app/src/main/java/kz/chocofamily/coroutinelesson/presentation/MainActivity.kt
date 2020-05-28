package kz.chocofamily.coroutinelesson.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kz.chocofamily.coroutinelesson.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainNavController = findNavController(this, R.id.flowNavHost)
        setupNavigation()
    }

    //region Navigation
    fun navigateToPin() {
        mainNavController.navigate(R.id.action_global_pinFragment)
    }
    //endregion

    //region Private
    private fun setupNavigation() {

        bottomNavView.selectedItemId = R.id.menuFragment2
        bottomNavView.setupWithNavController(mainNavController)

        mainNavController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.loginFragment -> hideBnv()
                R.id.someFlowFragment -> hideBnv()
                R.id.pinFragment -> hideBnv()
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
    //endregion
}
