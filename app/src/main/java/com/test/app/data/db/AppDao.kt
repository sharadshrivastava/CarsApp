package com.test.app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.app.data.db.entity.RegistrationEntity

@Dao
interface AppDao {

    @Query("SELECT * FROM RegistrationEntity")
    suspend fun registrations(): List<RegistrationEntity>

    @Query("SELECT * FROM RegistrationEntity WHERE id=:id")
    suspend fun registrationById(id: Int): RegistrationEntity?

    @Query("SELECT count(*) FROM RegistrationEntity")
    suspend fun entryCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(registrationEntity: RegistrationEntity?)

    @Query("DELETE FROM RegistrationEntity")
    suspend fun deleteAll()
}