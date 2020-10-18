package com.example.madlevel3task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.madlevel3task2.databinding.FragmentAddPortalBinding

class AddPortalFragment : Fragment() {

    private lateinit var binding: FragmentAddPortalBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPortalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddPortal.setOnClickListener {
            addPortal()
        }
    }

    private fun addPortal() {
        val portalTitle = binding.etTitle.text.toString()
        val portalUrl = binding.etUrl.text.toString()

        if (portalTitle.isNotBlank() and portalUrl.isNotBlank()) {
            setFragmentResult(PORTAL, bundleOf(PORTAL to PortalCard(portalTitle, portalUrl)))

            findNavController().popBackStack()
        } else
            Toast.makeText(activity, "Invalid portal", Toast.LENGTH_SHORT).show()
    }
}
