package com.sniper.music.api.lastfm

import com.sniper.music.api.ApiConfiguration
import com.sniper.music.api.Environment

class LastFMApiConfiguration(private val isDebug: Boolean): ApiConfiguration {

    override val baseURL: String
        get() = Environment.LastFMAPI.getBuildUrl(isDebug)

    override val pinners: Array<String>
        get() = arrayOf("sha256/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=", "sha256/BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB=")

}
