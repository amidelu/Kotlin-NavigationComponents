package com.andro4everyone.navigationarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarId)

        val navController = Navigation.findNavController(this, R.id.navHostFragmentId)

        setUpBottomNav(navController)
        setUpSideNav(navController)
        setUpActionBar(navController)
    }

    //calling safe argument for land mood caz bottom nav is not implemented there
    private fun setUpBottomNav(navController: NavController) {
        bottomNavId?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    private fun setUpSideNav(navController: NavController) {
        navViewId?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    private fun setUpActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayoutId)
    }

    //inflating menu toolbar over menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    //navigation item select code goes here
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(this, R.id.navHostFragmentId)
        val navigated = NavigationUI.onNavDestinationSelected(item, navController)
        return navigated || super.onOptionsItemSelected(item)
    }

    //navigation up function which will show hamburger menu in land mood and up arrow after going to any menu activity
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.navHostFragmentId), drawerLayoutId)
    }
}
