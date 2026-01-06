package com.pulica.features.connection.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pulica.features.connection.databinding.FragmentConnectionMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConnectionMainFragment : Fragment() {

    private var _binding: FragmentConnectionMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ConnectionMainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConnectionMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
