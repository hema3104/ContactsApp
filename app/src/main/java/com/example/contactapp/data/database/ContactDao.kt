package com.example.contactapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts_table ORDER BY username ASC")
    fun getContactsSortedByName(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts_table ORDER BY dateOfCreation ASC")
    fun getContactsSortedByDate(): Flow<List<Contact>>



}