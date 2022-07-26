package com.example.uefa_poc.models

import com.example.uefa_poc.repositories.SquadInfoFetcher
import com.example.uefa_poc.repositories.data.PlayerInfo

class SquadInfoModel(private val repository: SquadInfoFetcher) {

    fun getSquadInfo(team: String): HashMap<String, List<PlayerInfo>> {
        return sortMemberInfo(repository.fetchSquadInfo(team))
    }

    private fun sortMemberInfo(squadInfo: List<PlayerInfo>): HashMap<String, List<PlayerInfo>> {
       val infoMap = hashMapOf<String, List<PlayerInfo>>()
        val goalkeeperList = ArrayList<PlayerInfo>()
        val defenderList = ArrayList<PlayerInfo>()
        val midfielderList = ArrayList<PlayerInfo>()
        val forwardList = ArrayList<PlayerInfo>()
        val coachList = ArrayList<PlayerInfo>()

        squadInfo.forEach {
            when(it.position) {
              "Goalkeeper"  -> goalkeeperList.add(it)
              "Defender"  -> defenderList.add(it)
              "Midfielder"  -> midfielderList.add(it)
              "Forward"  -> forwardList.add(it)
              "Coach"  -> coachList.add(it)
            }
        }

        infoMap["Goalkeeper"] = goalkeeperList
        infoMap["Defender"] = defenderList
        infoMap["Midfielder"] = midfielderList
        infoMap["Forward"] = forwardList
        infoMap["Coach"] = coachList
        return infoMap
    }
}