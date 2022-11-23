package com.catnip.animemunity.data.network.api.datasource

import com.catnip.animemunity.data.network.api.model.Anime
import com.catnip.animemunity.data.network.api.model.AnimeDetail
import com.catnip.animemunity.data.network.api.service.GogoAnimeApiService

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface GogoAnimeApiDataSource {

    suspend fun getAnimeList(page: Int = 1): List<Anime>

    suspend fun getTopAiringList(page: Int = 1): List<Anime>

    suspend fun getRecentReleaseAnimeList(page: Int = 1): List<Anime>

    suspend fun getDetailAnime(animeId: String): AnimeDetail

}

class GogoAnimeApiDataSourceImpl(private val service : GogoAnimeApiService) : GogoAnimeApiDataSource{
    override suspend fun getAnimeList(page: Int): List<Anime> {
        return service.getAnimeList(page)
    }

    override suspend fun getTopAiringList(page: Int): List<Anime> {
        return service.getTopAiringAnimeList(page)
    }

    override suspend fun getRecentReleaseAnimeList(page: Int): List<Anime> {
        return service.getRecentReleaseAnimeList(page)
    }

    override suspend fun getDetailAnime(animeId: String): AnimeDetail {
        return service.getAnimeDetail(animeId)
    }
}