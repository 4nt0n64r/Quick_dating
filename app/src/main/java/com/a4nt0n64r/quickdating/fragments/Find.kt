package com.a4nt0n64r.quickdating.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.MainActivity.Companion.DEFAULT_NUMBER
import com.a4nt0n64r.quickdating.MainActivity.Companion.NUMBER
import com.a4nt0n64r.quickdating.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.find.*
import kotlin.random.Random


class Find : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.find, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var number = 0

        number = createNumber(number)

        val str = number.toString() + " " + getString(R.string.find_people)
        description_tv.text = str
        //1 собеседник
        //2,3,4 собеседника
        //5-20 собеседников
        //5-10 собеседников

        val activity = this.activity as MainActivity
        activity.writeNumberToSharedPrefs(number)

        back_arrow.setOnClickListener {
            activity.supportFragmentManager.popBackStack()
            activity.writeNumberToSharedPrefs(DEFAULT_NUMBER)
        }

        begin_chat_button.setOnClickListener {
            if (!name_tv.text.isNullOrEmpty()) {
                activity.changeFragmentWithParameter(MainActivity.LOADING_CAMERA, number)
            } else {
                showSnackbar("Введите имя!")
            }
        }

    }

    private fun createNumber(number: Int): Int {
        if (number == 0) {
            val activity = this.activity as MainActivity
            val sp = activity.readNumberFromSharedPrefs()
            if (sp != 0) {
                return sp
            } else {
                return Random.nextInt(21, 10000)
            }
        }
        return number
    }

    private fun showSnackbar(msg: String) {
        val snack = Snackbar.make(parent, msg, Snackbar.LENGTH_LONG)
        snack.show()
    }
}