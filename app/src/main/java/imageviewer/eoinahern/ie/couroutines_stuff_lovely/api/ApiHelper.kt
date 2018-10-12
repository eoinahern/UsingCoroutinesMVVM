package imageviewer.eoinahern.ie.couroutines_stuff_lovely.api

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


const val endpoint: String = "http://partnerapi.funda.nl/feeds/Aanbod.svc/"

class ApiHelper {

	companion object {

		private var api: FundaApi? = null

		fun getInstance(): FundaApi {

			api?.let {
				return it
			}

			return Retrofit.Builder()
					.baseUrl(endpoint)
					.addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
					.build().create(FundaApi::class.java)
		}
	}
}