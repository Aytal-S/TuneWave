package com.allenhouse.mini_project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allenhouse.mini_project.databinding.FragmentProfileBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class profile : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("userName", "Guest")
        val email = sharedPreferences.getString("userEmail", "guest@example.com")

        binding.username.text = name
        binding.email.text = email
        
        binding.profile.setOnClickListener {
            val i = Intent(requireContext(), MainActivity::class.java)
            startActivity(i)
        }
        binding.logout.setOnClickListener {
            requireActivity().finishAffinity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}