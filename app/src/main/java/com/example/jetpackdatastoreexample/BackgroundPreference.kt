package com.example.jetpackdatastoreexample

import android.content.Context

import androidx.datastore.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BackgroundPreference(  context: Context)
{
    private val dataStore: DataStore<Preferences> =
        context.createDataStore("background_resource")

    companion object{
       val BACKGROUND_COLOR = preferencesKey<Int>(name = "main_background")
    }

    suspend fun saveBackground(value: Int)
    {
        dataStore.edit { preferences ->
            preferences[BACKGROUND_COLOR] = value

        }
    }

    val backgroundColor: Flow<Int> = dataStore.data.map {preferences ->
        preferences[BACKGROUND_COLOR]?:-1
    }



}