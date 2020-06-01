package kz.chocofamily.coroutinelesson.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kz.chocofamily.coroutinelesson.R
import kz.chocofamily.coroutinelesson.presentation.fragments.DEEPLINK
import kz.chocofamily.coroutinelesson.presentation.fragments.IsAlreadyAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mainNavController: NavController

    private var deeplink = ""
    private val isAlreadyAuth: IsAlreadyAuth by viewModels()
    private var isAuthorized = false

//    private val intentVM: IntentVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainNavController = findNavController(this, R.id.flowNavHost)
        setupBottomNavigationView()
        if (savedInstanceState == null && intent != null) {
            deeplink = intent?.getStringExtra(DEEPLINK) ?: ""
            Log.i("myMainActivity", "in savedInstanceState deeplink = $deeplink")
        }

        Log.i(
            "myMainActivity",
            "authState = ${if (isAlreadyAuth.getInstantResult() == IsAlreadyAuth.AuthState.Success) "success" else "fail"}"
        )
        isAuthorized = isAlreadyAuth.getInstantResult() == IsAlreadyAuth.AuthState.Success

        Log.i("myMainActivity", "hash = ${this.hashCode()}")
        checkAuthAndNavigateIfNeed()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
//        intentVM.setResult(intent)
        deeplink = intent?.getStringExtra(DEEPLINK) ?: ""
        Log.i("myMainActivity", "in onNewIntent deeplink = $deeplink")
        navigateToDeeplink()
    }

    //region Navigation
    fun navigateToPin(args: Bundle? = null) {
        mainNavController.navigate(R.id.action_global_pinFragment, args)
    }
    //endregion

    //region Private
    private fun setupBottomNavigationView() {

        bottomNavView.selectedItemId =
            R.id.menuFragment // Нужно ставить то, что обычно открывается по умолчанию

        bottomNavView.setupWithNavController(mainNavController)

        mainNavController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
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

    private fun checkAuthAndNavigateIfNeed() {
        navigateToDeeplink()
        if (!isAuthorized) {
            mainNavController.navigate(R.id.action_global_loginFragment)
        }
    }

    private fun navigateToDeeplink() {
        if (deeplink.isNotBlank()) {
            Log.i("myMainActivity", "in checkAuthAndNavigateIfNeed deeplink = $deeplink")
            val deepLinkBuilder = NavDeepLinkRequest.Builder
                .fromUri(deeplink.toUri())
                .build()
            mainNavController.navigate(deepLinkBuilder)

        }
    }
    //endregion
}
