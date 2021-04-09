package com.example.testlistfromserver.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.testlistfromserver.R
import com.example.testlistfromserver.databinding.MainFragmentBinding
import com.example.testlistfromserver.viewmodel.AuthViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private val viewModel by viewModel<AuthViewModel>()
    lateinit var binding: MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )

        val mask = arguments?.getString("mask")
        binding.phoneInput.mask = mask

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.auth.observe(this) {

        }
        binding.signIn.setOnClickListener {

            viewModel.auth(binding.phoneInput.text.toString())

            val beginTransaction = activity?.supportFragmentManager?.beginTransaction()
//            beginTransaction?.addToBackStack(null)
            beginTransaction?.replace(R.id.container, ListFragment())?.commit()
        }
    }
}