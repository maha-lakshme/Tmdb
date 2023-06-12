package com.maha.tmdb.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvshow: List<TvShow>
)