package imageviewer.eoinahern.ie.couroutines_stuff_lovely

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.component.DaggerAppComponent
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.module.AppModule
import javax.inject.Inject


class MyApp : Application(), HasActivityInjector {

	@Inject
	lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

	override fun onCreate() {
		super.onCreate()
		DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
	}

	override fun activityInjector(): AndroidInjector<Activity> {
		return dispatchingAndroidInjector
	}

}



