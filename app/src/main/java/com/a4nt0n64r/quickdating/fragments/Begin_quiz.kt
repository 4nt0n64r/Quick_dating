package com.a4nt0n64r.quickdating.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.MainActivity.Companion.ANSWER_1
import com.a4nt0n64r.quickdating.R
import com.a4nt0n64r.quickdating.fragments.answers.Answer_1
import kotlinx.android.synthetic.main.a_1.back_arrow
import kotlinx.android.synthetic.main.begin_quiz.*
import kotlinx.android.synthetic.main.privacy_layout_removed.*

class Begin_quiz : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.begin_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_arrow.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.showCardView()
            activity.supportFragmentManager.popBackStack()
        }

        next_tv.setOnClickListener {
            val activity = this.activity as MainActivity
            activity.setFragment(ANSWER_1)
        }

    }
}