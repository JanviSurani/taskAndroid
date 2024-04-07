package com.example.taskandroid.NavigationGraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.taskandroid.R


class DataFragment : Fragment() {
//      private  var _binding:DataFragmentBinding?=null
//    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val  view= inflater.inflate(R.layout.fragment_data, container, false)

        val button=view.findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_dataFragment_to_homeFragment)
        }
        return view
    }


}


//     _binding= DataFragmentBinding.inflate(R.layout.fragment_data, container, false)
//     val view=binding.root
////        val button=view.findViewById<Button>(R.id.button2)
//
//        binding.button.setOnClickListener {
//
//
//            val name = binding.etName.text.toString()
//            val email = binding.etEmail.text.toString()
//
//            val user = User(name,email, password)
//
//            val action =
////            findNavController().navigate(R.id.action_dataFragment_to_homeFragment)
//
//            findNavController().navigate(
//                action
//            )
//
//
//        }
//        return view
//    }
//}
//
//class DataFragmentBinding {
//
//}




