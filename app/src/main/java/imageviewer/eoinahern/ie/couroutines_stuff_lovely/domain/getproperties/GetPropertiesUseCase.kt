package imageviewer.eoinahern.ie.couroutines_stuff_lovely.domain.getproperties

import imageviewer.eoinahern.ie.couroutines_stuff_lovely.api.FundaApi
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.PerScreen
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.domain.UseCase
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.model.Property
import java.lang.Exception
import javax.inject.Inject

@PerScreen
class GetPropertiesUseCase @Inject constructor(private val fundaApi: FundaApi) : UseCase<List<Property>>() {

	override suspend fun executeonBackground(): List<Property> {
		val resp = fundaApi.getProperties("koop", "/amsterdam/", 1).execute()
		return resp.body()?.properties ?: throw Exception("boo")
	}


}