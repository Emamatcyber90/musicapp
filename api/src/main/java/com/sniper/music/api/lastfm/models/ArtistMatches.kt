package com.sniper.music.api.lastfm.models

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class ArtistMatches: Serializable {

    @SerializedName("artist")
    @Expose
    lateinit var artist: List<Artist>

}
