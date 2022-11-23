package com.catnip.animemunity.data.repository

import com.catnip.animemunity.base.BaseRepository
import com.catnip.animemunity.base.wrapper.Resource
import com.catnip.animemunity.data.network.api.datasource.GogoAnimeApiDataSource
import com.catnip.animemunity.data.network.api.model.Anime
import com.catnip.animemunity.data.network.api.model.AnimeDetail

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface AnimeRepository {
    suspend fun getAnimeList(page: Int = 1): Resource<List<Anime>>

    suspend fun getTopAiringList(page: Int = 1): Resource<List<Anime>>

    suspend fun getRecentReleaseAnimeList(page: Int = 1): Resource<List<Anime>>

    suspend fun getDetailAnime(animeId: String): Resource<AnimeDetail>

}


class AnimeRepositoryImpl(private val networkDataSource: GogoAnimeApiDataSource) : AnimeRepository, BaseRepository() {
    override suspend fun getAnimeList(page: Int): Resource<List<Anime>> {
        return doNetworkCall { networkDataSource.getAnimeList(page) }
    }

    override suspend fun getTopAiringList(page: Int): Resource<List<Anime>> {
        return doNetworkCall { networkDataSource.getTopAiringList(page) }
    }

    override suspend fun getRecentReleaseAnimeList(page: Int): Resource<List<Anime>> {
        return doNetworkCall { networkDataSource.getRecentReleaseAnimeList(page) }
    }

    override suspend fun getDetailAnime(animeId: String): Resource<AnimeDetail> {
        return doNetworkCall { networkDataSource.getDetailAnime(animeId) }
    }
}