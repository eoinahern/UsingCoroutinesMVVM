package imageviewer.eoinahern.ie.couroutines_stuff_lovely.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PropertyWrapper(

		@Json(name = "Objects")
		val properties: List<Property>
)