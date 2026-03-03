package com.example.contactapp.data.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 2, exportSchema = false)
abstract class ContactDataBase : RoomDatabase() {
    abstract fun contactDao() : ContactDao
}