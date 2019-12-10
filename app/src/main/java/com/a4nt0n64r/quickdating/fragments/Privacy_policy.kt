package com.a4nt0n64r.quickdating.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.R
import kotlinx.android.synthetic.main.a_1.back_arrow
import kotlinx.android.synthetic.main.privacy_layout.*

class Privacy_policy : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.privacy_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accept_tv.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.setFragment(MainActivity.CAMERA)
        }

        back_arrow.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.supportFragmentManager.popBackStack()
        }

        cancel_tv.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.supportFragmentManager.popBackStack()
        }

    }
}