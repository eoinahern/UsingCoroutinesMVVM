package imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.PerScreen
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda.FundaDataActivity


@Module
abstract class BuilderModule {

	@PerScreen
	@ContributesAndroidInjector
	abstract fun contributesFundaActivity(): FundaDataActivity

}