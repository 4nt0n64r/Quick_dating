package com.a4nt0n64r.quickdating.fragments.answers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.MainActivity.Companion.ANSWER_2
import com.a4nt0n64r.quickdating.R
import kotlinx.android.synthetic.main.a_1.*


class Answer_1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.a_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        woman_iv.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.setFragment(ANSWER_2)
        }

        back_arrow.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.supportFragmentManager.popBackStack()
            activity.showCardView()
        }

    }
}
