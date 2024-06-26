package com.example.taskandroid.NavigationGraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.taskandroid.R


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home3, container, false)

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_dataFragment)
        }

        return view
    }

}

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view=inflater.inflate(R.layout.fragment_home3, container, false)
//
//        val button=view.findViewById<Button>(R.id.button)
//        button.setOnClickListener {
//
//            findNavController().navigate(R.id.action_homeFragment_to_dataFragment)
//        }
//
//        return view
//    }
//

//}