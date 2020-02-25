package jp.gree.techcon.common

import jp.gree.techcon.common.datasource.db.SessionDao
import jp.gree.techcon.common.datasource.network.Api
import jp.gree.techcon.common.repository.ArticleRepository
import jp.gree.techcon.common.repository.SessionRepository
import jp.gree.techcon.common.usecase.SessionDetailService
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object CommonModule {
    lateinit var kodein: Kodein

    fun initialize(appState: AppState) {
        kodein = Kodein {
            // misc
            bind<AppDatabase>() with singleton { AppDatabase(driver("app.db")) }
            bind<AppState>() with singleton { appState }

            // data
            bind<SessionDao>() with singleton { SessionDao(instance()) }
            bind<Api>() with singleton { Api(instance()) }

            // repo
            bind<SessionRepository>() with singleton { SessionRepository(instance(), instance()) }
            bind<ArticleRepository>() with singleton { ArticleRepository(instance()) }
        }
    }
}
