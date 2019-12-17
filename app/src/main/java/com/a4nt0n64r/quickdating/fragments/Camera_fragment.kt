package com.a4nt0n64r.quickdating.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.quickdating.MainActivity
import com.a4nt0n64r.quickdating.R
import kotlinx.android.synthetic.main.camera_layout.*
import kotlinx.android.synthetic.main.camera_layout.description_tv
import kotlinx.android.synthetic.main.find.*
import kotlin.random.Random


class Camera_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.camera_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var number = 0

        val bundle = this.arguments
        if (bundle != null) {
            number = bundle.getInt(MainActivity.NUMBER)
        }

        val str = number.toString() + " " + getString(R.string.find_people)
        description_tv.text = str

        camera.setLifecycleOwner(viewLifecycleOwner)

        val activity = this.activity as MainActivity

        cancel_camera.setOnClickListener {
            activity.supportFragmentManager.popBackStack()
        }

    }

    override fun onResume() {
        super.onResume()
        camera.open()
    }

    override fun onPause() {
        super.onPause()
        camera.close()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        camera.destroy()
    }

}
