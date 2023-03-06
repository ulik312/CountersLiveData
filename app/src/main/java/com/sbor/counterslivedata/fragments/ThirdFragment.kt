package com.sbor.counterslivedata.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sbor.counterslivedata.viewmodel.MyViewModel
import com.sbor.counterslivedata.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var viewModel: MyViewModel
    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MyViewModel::class.java]
        viewModel._operations.observe(viewLifecycleOwner, Observer {
            binding.textResult2.text = ""
            it.map { operation ->
                binding.textResult2.append("$operation ")
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}