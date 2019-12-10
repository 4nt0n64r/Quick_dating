package com.a4nt0n64r.quickdating.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.R
import kotlinx.android.synthetic.main.internet_error.*


class Internet_error : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.internet_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ok_button.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.onBackPressed()
        }

        back_arrow.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.onBackPressed()
        }

    }
}