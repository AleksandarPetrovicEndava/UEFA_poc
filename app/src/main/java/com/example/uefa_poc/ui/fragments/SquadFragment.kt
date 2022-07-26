package com.example.uefa_poc.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uefa_poc.R
import com.example.uefa_poc.databinding.FragmentSquadBinding
import com.example.uefa_poc.repositories.data.PlayerInfo
import com.example.uefa_poc.ui.activities.DetailsActivity
import com.example.uefa_poc.viewmodels.SquadViewModel
import com.example.uefa_poc.viewmodels.UIUtils

@Suppress("UNCHECKED_CAST")
class SquadFragment : Fragment() {

    private lateinit var binding: FragmentSquadBinding
    private val viewModel: SquadViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSquadBinding.inflate(inflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.squadInfo.observe(viewLifecycleOwner) {
           updatePlayerLists(it as HashMap<String, ArrayList<PlayerInfo>>)
        }
        setupTheme((activity as DetailsActivity).getThemeIndex())
        setupData()
    }

    private fun setupTheme(themeIndex: Int) {
        when(themeIndex) {
            1 -> applyUCLTheme()
            else -> applyUELTheme()
        }
    }

    private fun applyUELTheme() {
        binding.parentLinearLayout.setBackgroundResource(R.color.uel_primary)
        binding.divider1.setBackgroundResource(R.color.uel_secondary)
        binding.divider2.setBackgroundResource(R.color.uel_secondary)
        binding.divider3.setBackgroundResource(R.color.uel_secondary)
        binding.divider4.setBackgroundResource(R.color.uel_secondary)
        binding.playerListBLabel.setBackgroundResource(R.color.uel_secondary)
    }

    private fun applyUCLTheme() {
        binding.parentLinearLayout.setBackgroundResource(R.color.ucl_primary)
        binding.divider1.setBackgroundResource(R.color.ucl_secondary)
        binding.divider2.setBackgroundResource(R.color.ucl_secondary)
        binding.divider3.setBackgroundResource(R.color.ucl_secondary)
        binding.divider4.setBackgroundResource(R.color.ucl_secondary)
        binding.playerListBLabel.setBackgroundResource(R.color.ucl_secondary)
    }

    private fun updatePlayerLists(squadMembersMap: HashMap<String, ArrayList<PlayerInfo>>?) {
         val goalkeeperAdapter = PlayerInfoAdapter(context!!, squadMembersMap?.get("Goalkeeper")!!)
         val defenderAdapter = PlayerInfoAdapter(context!!, squadMembersMap?.get("Defender")!!)
         val midfielderAdapter = PlayerInfoAdapter(context!!, squadMembersMap?.get("Midfielder")!!)
         val forwardAdapter = PlayerInfoAdapter(context!!,squadMembersMap?.get("Forward")!!)
         val coachAdapter = PlayerInfoAdapter(context!!, squadMembersMap?.get("Coach")!!)

         binding.goalkeepersListView.adapter = goalkeeperAdapter
         UIUtils.setListViewHeightBasedOnItems(binding.goalkeepersListView)
         binding.defendersListView.adapter = defenderAdapter
         UIUtils.setListViewHeightBasedOnItems(  binding.defendersListView)
         binding.midfieldersListView.adapter = midfielderAdapter
         UIUtils.setListViewHeightBasedOnItems(binding.midfieldersListView)
         binding.forwardsListVIew.adapter = forwardAdapter
         UIUtils.setListViewHeightBasedOnItems(binding.forwardsListVIew)
         binding.coachListView.adapter = coachAdapter
         UIUtils.setListViewHeightBasedOnItems(binding.coachListView)
    }

    private fun setupData() {
        viewModel.getSquadInfo()
    }
}