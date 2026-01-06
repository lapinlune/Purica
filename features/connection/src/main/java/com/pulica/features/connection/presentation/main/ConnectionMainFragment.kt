package com.pulica.features.connection.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.pulica.features.connection.databinding.FragmentConnectionMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonHello.setOnClickListener {
            viewModel.getHelloMessage()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.helloMessageState.collectLatest { state ->
                // Show/Hide progress bar
                binding.progressBar.isVisible = state.isLoading

                // Show message if not empty
                if (state.message.isNotBlank()) {
                    binding.textHelloMessage.text = state.message
                }

                // Show error if not empty
                if (state.error.isNotBlank()) {
                    binding.textHelloMessage.text = state.error
                    Toast.makeText(requireContext(), state.error, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
