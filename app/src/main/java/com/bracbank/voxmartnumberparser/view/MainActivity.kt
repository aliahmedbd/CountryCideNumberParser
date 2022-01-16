package com.bracbank.voxmartnumberparser.view

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bracbank.voxmartnumberparser.R
import com.bracbank.voxmartnumberparser.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setBottomNavigationBar()
        val actionbar = supportActionBar
    }

    /**
     * Set bottom navigation with Nav controller as well the menu item also tagged with the
     * navigation
     */
    private fun setBottomNavigationBar() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        AppBarConfiguration(
            setOf(
                R.id.dialFragment,
                R.id.countryCodeFragment,
                R.id.profileFragment
            )
        )
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        showDialog()
    }

    /** Show an exit dialog to user confirmation */
    private fun showDialog() {
        val myQuittingDialogBox: AlertDialog = AlertDialog.Builder(this)
            .setTitle("Exit")
            .setIcon(R.mipmap.ic_launcher)
            .setMessage("Are you sure you want to exit the application?")
            .setPositiveButton(
                "Exit"
            ) { dialog: DialogInterface, _: Int ->
                moveTaskToBack(true)
                dialog.dismiss()
            }
            .setNegativeButton(
                "No"
            ) { dialog: DialogInterface, which: Int -> dialog.dismiss() }
            .create()
        myQuittingDialogBox.setOnShowListener {
            myQuittingDialogBox.getButton(AlertDialog.BUTTON_NEGATIVE)
                .setTextColor(Color.parseColor("#2f6699"))
            myQuittingDialogBox.getButton(AlertDialog.BUTTON_POSITIVE)
                .setTextColor(Color.parseColor("#90FF4500"))
        }
        myQuittingDialogBox.show()
    }
}