import di.commonModules
import org.koin.core.context.startKoin

actual class KotlinInitializer {
    actual fun init() {
        startKoin {
            modules(commonModules, viewModelModule)
        }
    }
}