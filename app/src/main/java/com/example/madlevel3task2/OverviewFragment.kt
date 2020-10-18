package com.example.madlevel3task2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel3task2.databinding.FragmentOverviewBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
const val PORTAL = "portal"
class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding
    private val portals = arrayListOf<PortalCard>()
    private val portalAdapter =
        PortalCardAdapter(portals) { portalCard: PortalCard -> portalCardClicked(portalCard) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPortalCards.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.rvPortalCards.adapter = portalAdapter
        addPortalCardResult()
    }

    private fun addPortalCardResult() {
        setFragmentResultListener(PORTAL) { _, bundle ->
            bundle.getParcelable<PortalCard>(PORTAL)?.let {
                portals.add(it)
            } ?: Log.e("PortalCard", "No PortalCard received!")
        }
    }

    private fun portalCardClicked(portalCard: PortalCard) {

    }

}