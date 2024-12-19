package com.taewoo.sololifeapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.taewoo.sololifeapp.R
import com.taewoo.sololifeapp.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    /** dataBinding **/
    private lateinit var binding : FragmentHomeBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("HomeFragment", "onCreateView")

        /** FragmentBinding은 ActivityBinding이랑 다르다. **/
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.tipTap.setOnClickListener {
            Log.d("HomeFragment", "tipTap")
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

            /** tip버튼을 누르면 tip으로 이동 **/
            // it으로 전달된 객체를 참조한다. -> 여기서 말하는 객체는 뷰
            it.findNavController().navigate(R.id.action_homeFragment_to_tipFragment)

        }

        /** 여기서 it는 talkTap을 가르킴 **/
        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_talkFragment)
        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_bookmarkFragment)
        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_storeFragment)
        }



        return binding.root
    }
}