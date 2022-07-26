package com.example.uefa_poc.repositories

import com.example.uefa_poc.repositories.data.PlayerInfo

class MockedSquadInfoRepository(private val image: Int) : SquadInfoFetcher {

    override fun fetchSquadInfo(team: String): List<PlayerInfo> {
        return ArrayList<PlayerInfo>().apply {
            add(0, PlayerInfo("Aleksandar Petrovic", "Defender", "11","Serbia", image))
            add(1, PlayerInfo("Aleksandar Petrovic", "Midfielder", "12","Serbia", image))
            add(2, PlayerInfo("Aleksandar Petrovic", "Midfielder", "13","Serbia", image))
            add(3, PlayerInfo("Aleksandar Petrovic", "Defender", "14","Serbia", image))
            add(4, PlayerInfo("Aleksandar Petrovic", "Defender", "15","Serbia", image))
            add(5, PlayerInfo("Aleksandar Petrovic", "Goalkeeper", "16","Serbia", image))
            add(6, PlayerInfo("Aleksandar Petrovic", "Defender", "17","Serbia", image))
            add(7, PlayerInfo("Aleksandar Petrovic", "Defender", "18","Serbia", image))
            add(8, PlayerInfo("Aleksandar Petrovic", "Midfielder", "19","Serbia", image))
            add(9, PlayerInfo("Aleksandar Petrovic", "Defender", "20","Serbia", image))
            add(10, PlayerInfo("Aleksandar Petrovic", "Defender", "21","Serbia", image))
            add(11, PlayerInfo("Aleksandar Petrovic", "Midfielder", "22","Serbia", image))
            add(12, PlayerInfo("Aleksandar Petrovic", "Midfielder", "23","Serbia", image))
            add(13, PlayerInfo("Aleksandar Petrovic", "Midfielder", "24","Serbia", image))
            add(14, PlayerInfo("Aleksandar Petrovic", "Defender", "25","Serbia", image))
            add(15, PlayerInfo("Aleksandar Petrovic", "Defender", "26","Serbia", image))
            add(16, PlayerInfo("Aleksandar Petrovic", "Forward", "27","Serbia", image))
            add(17, PlayerInfo("Aleksandar Petrovic", "Defender", "1","Serbia", image))
            add(18, PlayerInfo("Aleksandar Petrovic", "Forward", "2","Serbia", image))
            add(19, PlayerInfo("Aleksandar Petrovic", "Midfielder", "3","Serbia", image))
            add(20, PlayerInfo("Aleksandar Petrovic", "Forward", "4","Serbia", image))
            add(21, PlayerInfo("Aleksandar Petrovic", "Midfielder", "5","Serbia", image))
            add(22, PlayerInfo("Aleksandar Petrovic", "Coach", "","Serbia", image))
        }
    }
}