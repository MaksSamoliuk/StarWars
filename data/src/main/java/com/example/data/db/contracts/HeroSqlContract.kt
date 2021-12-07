package com.example.data.db.contracts

class HeroSqlContract {
    companion object{
        const val fetch = "SELECT * FROM ${RoomContract.tableHero}"
    }
}