package kz.chocofamily.coroutinelesson.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kz.chocofamily.coroutinelesson.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainNavController: NavController

    private val intentVM: IntentVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("myMainActivity", "onCreate ${this.hashCode()}")
        setContentView(R.layout.activity_main)
        mainNavController = findNavController(this, R.id.flowNavHost)
        setupBottomNavigationView()
        if (savedInstanceState == null && intent != null) {
            intentVM.setResult(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intentVM.setResult(intent)
    }

    //region Navigation
    fun navigateToPin(args: Bundle? = null) {
        mainNavController.navigate(R.id.action_global_pinFragment, args)
    }
    //endregion

    //region Private
    private fun setupBottomNavigationView() {

        bottomNavView.selectedItemId = R.id.menuFragment // Нужно ставить то, что обычно открывается по умолчанию

        bottomNavView.setupWithNavController(mainNavController)

        mainNavController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.loginFragment -> hideBnv()
                R.id.someFlowFragment -> hideBnv()
                R.id.pinFragment -> hideBnv()
                else -> showBnv()
            }
        }

//        mainNavController.
    }

    private fun showBnv() {
        bottomNavView.visibility = View.VISIBLE
    }

    private fun hideBnv() {
        bottomNavView.visibility = View.GONE
    }
    //endregion
}
