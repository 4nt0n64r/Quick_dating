package com.a4nt0n64r.quickdating.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.MainActivity.Companion.CAMERA
import com.a4nt0n64r.quickdating.MainActivity.Companion.NUMBER

import com.a4nt0n64r.quickdating.R
import kotlinx.android.synthetic.main.a_1.*
import kotlinx.android.synthetic.main.a_1.back_arrow
import kotlinx.android.synthetic.main.find.*
import kotlin.random.Random

class Loading_camera : Fragment() {

    val timerSeconds = 5
    lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loading_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = this.activity as MainActivity

        var number = 0
        val bundle = this.arguments
        if (bundle != null) {
            number = bundle.getInt(NUMBER)
        }

        timer = object : CountDownTimer((timerSeconds * 1000).toLong(), 1000) {

            override fun onTick(l: Long) {
            }

            override fun onFinish() {
                activity.changeFragmentWithParameter(CAMERA,number)
            }
        }.start()

        back_arrow.setOnClickListener {
            activity.supportFragmentManager.popBackStack()
            timer.cancel()
        }
    }

    override fun onDetach() {
        super.onDetach()
        if (timer != null) {
            timer.cancel()
        }
    }
}