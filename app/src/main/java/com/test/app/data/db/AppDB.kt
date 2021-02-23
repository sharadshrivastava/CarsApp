package com.test.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.app.data.db.entity.RegistrationEntity

@Database(entities = [RegistrationEntity::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun appDao(): AppDao
}