package com.a4nt0n64r.quickdating.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.find.*


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

        val activity = this.activity as MainActivity

        back_arrow.setOnClickListener {
            activity.supportFragmentManager.popBackStack()
        }

        begin_chat_button.setOnClickListener {
            if (!name_tv.text.isNullOrEmpty()) {
                activity.setFragment(MainActivity.POLICY)
            } else {
                showSnackbar("Введите имя!")
            }

        }

    }

    private fun showSnackbar(msg: String) {
        val snack = Snackbar.make(parent, msg, Snackbar.LENGTH_LONG)
        snack.show()
    }
}