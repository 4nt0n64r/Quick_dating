package com.a4nt0n64r.quickdating

import Answer_2
import Answer_3
import Loading
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.a4nt0n64r.quickdating.fragments.Camera_fragment
import com.a4nt0n64r.quickdating.fragments.Find
import com.a4nt0n64r.quickdating.fragments.Internet_error
import com.a4nt0n64r.quickdating.fragments.Privacy_policy
import com.a4nt0n64r.quickdating.fragments.answers.Answer_1
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val permissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.RECORD_AUDIO,
        android.Manifest.permission.ACCESS_NETWORK_STATE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_button.setOnClickListener {
            setFragment(ANSWER_1)
        }


    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 0)
    }

    private fun hasNoPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) != PackageManager.PERMISSION_GRANTED
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fragments = supportFragmentManager.fragments
        if (fragments.isEmpty()) {
            card_main.visibility = VISIBLE
        }
    }

    fun showCardView() {
        card_main.visibility = VISIBLE
    }


    fun setFragment(fragment: String) {
        if (isNetworkConnected()) {
            when (fragment) {
                ANSWER_1 -> {
                    card_main.visibility = INVISIBLE
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            Answer_1(), ANSWER_1
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                ANSWER_2 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            Answer_2(), ANSWER_2
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                ANSWER_3 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            Answer_3(), ANSWER_3
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                LOADING -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            Loading(), LOADING
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                FIND -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            Find(), FIND
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                CAMERA -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            Camera_fragment(), CAMERA
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                POLICY -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            Privacy_policy(), POLICY
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                ERROR -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            Internet_error(), ERROR
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
            }
        } else {
            card_main.visibility = INVISIBLE
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_frame,
                    Internet_error(), ERROR
                )
                .addToBackStack(ADD_TO_BACK_STACK)
                .commit()
        }


    }

    private fun isNetworkConnected(): Boolean {
        val cm =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
    }

    companion object {
        val ADD_TO_BACK_STACK = "ADD_TO_BACK_STACK"

        val ANSWER_1 = "ANSWER_1"
        val ANSWER_2 = "ANSWER_2"
        val ANSWER_3 = "ANSWER_3"
        val LOADING = "LOADING"
        val FIND = "FIND"
        val POLICY = "POLICY"
        val CAMERA = "CAMERA"
        val ERROR = "ERROR"

    }
}
