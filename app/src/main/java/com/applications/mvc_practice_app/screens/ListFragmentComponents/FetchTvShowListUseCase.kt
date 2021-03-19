package com.applications.mvc_practice_app.screens.ListFragmentComponents

import com.applications.mvc_practice_app.model.movie.MovieList
import com.applications.mvc_practice_app.model.tv_show.TvShowList
import com.applications.mvc_practice_app.networking.Apis.TvShowApi
import com.applications.mvc_practice_app.networking.Constants
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchTvShowListUseCase(private val tvShowApi: TvShowApi) {

    sealed class Result {
        class Success(val tvShowList: TvShowList) : Result()
        object Failure : Result()
    }


    suspend fun getTvShowList(page: Int, type: Constants.ListType): FetchTvShowListUseCase.Result {

        return withContext(Dispatchers.IO) {
            try {
                val response = when (type) {
                    Constants.ListType.TV_LATEST -> tvShowApi.getLatestTvShows(Constants.API_KEY, page)
                    Constants.ListType.TV_POPULAR -> tvShowApi.getPopularTvShows(Constants.API_KEY, page)
                    Constants.ListType.TV_TOP_RATED -> tvShowApi.getTopRatedTvShows(Constants.API_KEY, page)
                    else -> throw error("It is not movie type")
                }
                val tvShowList = response.body()

                if (!response.isSuccessful || tvShowList == null)
                    return@withContext FetchTvShowListUseCase.Result.Failure

                return@withContext Result.Success(tvShowList)
            } catch (t: Throwable) {
                if (t !is CancellationException)
                    return@withContext FetchTvShowListUseCase.Result.Failure

                throw  t
            }

        }

    }
}