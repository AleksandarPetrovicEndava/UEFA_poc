package com.example.uefa_poc.repositories

import com.example.uefa_poc.repositories.data.PlayerInfo

interface SquadInfoFetcher {

    fun fetchSquadInfo(team: String) : List<PlayerInfo>
}