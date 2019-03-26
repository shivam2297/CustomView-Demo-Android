package com.example.shivam.customviewsdemo.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.shivam.customviewsdemo.R
import com.example.shivam.customviewsdemo.custom_views.State
import kotlinx.android.synthetic.main.fragment_emotional_face.*

class EmotionalFaceFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emotional_face, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        happy_btn.setOnClickListener {
            emotional_face.happinessState = State.HAPPY
        }

        sad_btn.setOnClickListener {
            emotional_face.happinessState = State.SAD
        }
    }
}
