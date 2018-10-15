package imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.component

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.module.AppModule
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.module.BuilderModule
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.MyApp
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, BuilderModule::class])
interface AppComponent {

	fun inject(app: MyApp)
}