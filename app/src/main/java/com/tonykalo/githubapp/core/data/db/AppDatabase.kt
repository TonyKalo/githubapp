package com.tonykalo.githubapp.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tonykalo.githubapp.core.data.db.entity.EntityExample

@Database(entities = [EntityExample::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
