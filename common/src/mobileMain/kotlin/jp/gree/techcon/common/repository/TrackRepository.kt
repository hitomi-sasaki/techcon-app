package jp.gree.techcon.common.repository

import jp.gree.techcon.common.datasource.network.Api
import jp.gree.techcon.common.model.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TrackRepository(private val api: Api) {
    fun getTracks(): Flow<List<Track>> = flow {
        val tracks = api.getTracks()
        emit(tracks)
    }
}
