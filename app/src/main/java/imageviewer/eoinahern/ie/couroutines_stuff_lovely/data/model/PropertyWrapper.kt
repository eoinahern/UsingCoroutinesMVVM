package imageviewer.eoinahern.ie.couroutines_stuff_lovely.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.data.model.Property

@JsonClass(generateAdapter = true)
data class PropertyWrapper(

		@Json(name = "Objects")
		val properties: List<Property>
)