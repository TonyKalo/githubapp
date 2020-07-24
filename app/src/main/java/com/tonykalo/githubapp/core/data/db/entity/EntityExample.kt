package com.tonykalo.githubapp.core.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "example")
data class EntityExample(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "surname")
    var surname: String = ""
)
