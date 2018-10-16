package imageviewer.eoinahern.ie.couroutines_stuff_lovely.data.api

import imageviewer.eoinahern.ie.couroutines_stuff_lovely.data.model.PropertyWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FundaApi {

	@GET("json/ac1b0b1572524640a0ecc54de453ea9f/")
	fun getProperties(@Query("type") type: String,
				 @Query("zo") location: String,
				 @Query("page") page: Int): Call<PropertyWrapper>
}