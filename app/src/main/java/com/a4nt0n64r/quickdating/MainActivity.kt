package com.a4nt0n64r.quickdating

import Answer_2
import Answer_3
import Loading
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.a4nt0n64r.quickdating.fragments.*
import com.a4nt0n64r.quickdating.fragments.answers.Answer_1
import kotlinx.android.synthetic.main.begin_quiz.*
import kotlinx.android.synthetic.main.begin_quiz.card_main
import kotlinx.android.synthetic.main.privacy_layout_removed.*


class MainActivity : AppCompatActivity() {

    val permissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.RECORD_AUDIO,
        android.Manifest.permission.ACCESS_NETWORK_STATE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.begin_quiz)

        writeNumberToSharedPrefs(0)

        if (hasNoPermissions()) {
            requestPermission()
        }

        next_button.setOnClickListener {
            setFragment(ANSWER_1)
        }
    }

    fun writeNumberToSharedPrefs(number: Int) {
        val myPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val myEditor = myPreferences.edit()
        myEditor.putInt(NUMBER, number)
        myEditor.apply()
    }

    fun readNumberFromSharedPrefs(): Int {
        val myPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        return myPreferences.getInt(NUMBER, 0)
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

    fun changeFragmentWithParameter(fragment: String, number: Int = 0) {
        if (isNetworkConnected()) {
            when (fragment) {
                FIND -> {
                    val frag = Find()
                    val bundle = Bundle()
                    bundle.putInt(NUMBER, number)
                    frag.arguments = bundle
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            frag, FIND
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                CAMERA -> {
                    val frag = Camera_fragment()
                    val bundle = Bundle()
                    bundle.putInt(NUMBER, number)
                    frag.arguments = bundle
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            frag, CAMERA
                        )
                        .addToBackStack(ADD_TO_BACK_STACK)
                        .commit()
                }
                LOADING_CAMERA -> {
                    val frag = Loading_camera()
                    val bundle = Bundle()
                    bundle.putInt(NUMBER, number)
                    frag.arguments = bundle
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragment_frame,
                            frag, LOADING_CAMERA
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

//        val BEGIN_QUIZ = "BEGIN_QUIZ"
        val ANSWER_1 = "ANSWER_1"
        val ANSWER_2 = "ANSWER_2"
        val ANSWER_3 = "ANSWER_3"
        val LOADING = "LOADING"

        val FIND = "FIND"
        val CAMERA = "CAMERA"
        val LOADING_CAMERA = "LOADING_CAMERA"

        val NUMBER = "NUMBER"

        val ERROR = "ERROR"

        val DEFAULT_NUMBER = 0

    }

    override fun onDestroy() {
        super.onDestroy()

        writeNumberToSharedPrefs(0)

    }
}
