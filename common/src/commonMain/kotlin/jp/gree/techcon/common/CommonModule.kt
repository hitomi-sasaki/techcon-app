package jp.gree.techcon.common

import jp.gree.techcon.common.datasource.db.SessionDao
import jp.gree.techcon.common.repository.ArticleRepository
import jp.gree.techcon.common.repository.SessionRepository
import jp.gree.techcon.common.usecase.ArticleDetailUseCase
import jp.gree.techcon.common.usecase.ArticleListUseCase
import jp.gree.techcon.common.usecase.SessionDetailUseCase
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object CommonModule {
    val kodein: Kodein by lazy { setupDi() }

    private fun setupDi(): Kodein {
        val kodein = Kodein {
            // misc
            bind<AppDatabase>() with singleton { AppDatabase(driver("app.db")) }

            // data
            bind<SessionDao>() with singleton { SessionDao(instance()) }

            // repo
            bind<SessionRepository>() with singleton { SessionRepository(instance()) }
            bind<ArticleRepository>() with singleton { ArticleRepository() }

            // usecase
            bind<ArticleDetailUseCase>() with singleton { ArticleDetailUseCase(instance()) }
            bind<ArticleListUseCase>() with singleton { ArticleListUseCase(instance()) }
            bind<SessionDetailUseCase>() with singleton { SessionDetailUseCase(instance()) }
        }
        return kodein
        /*
        val viewModel = module {
            single { SessionListViewModel() }
            single { (sessionId: Long) -> SessionDetailViewModel(sessionId) }
        }

        val useCase = module {
            single { SessionListUseCase() }
            single { SessionDetailUseCase() }
        }

        val repository = module {
            single { SessionRepository() }
        }

        val network = module {
            single { DummySessionApi() }
        }

        startKoin {
            modules(listOf(viewModel, useCase, repository, network))
        }
         */

    }
}
