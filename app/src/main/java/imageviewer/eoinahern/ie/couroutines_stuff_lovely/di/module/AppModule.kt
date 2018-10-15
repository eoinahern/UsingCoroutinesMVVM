package imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.module

import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.MyApp
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.api.FundaApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class AppModule(private val myApp: MyApp) {

	@Singleton
	@Provides
	fun getContext(): Context {
		return myApp.applicationContext
	}


	@Provides
	@Singleton
	fun apiEndpoint() : String = "http://partnerapi.funda.nl/feeds/Aanbod.svc/"


	@Singleton
	@Provides
	fun getApi(endpoint : String): FundaApi {

		return Retrofit.Builder()
				.baseUrl(endpoint)
				.addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
				.build().create(FundaApi::class.java)

	}

}