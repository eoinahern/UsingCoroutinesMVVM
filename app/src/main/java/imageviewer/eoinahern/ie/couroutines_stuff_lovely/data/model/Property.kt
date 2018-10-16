package imageviewer.eoinahern.ie.couroutines_stuff_lovely.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Property(
		val AangebodenSindsTekst: String,
		val BronCode: String,
		val Foto: String,
		val FotoLarge: String,
		val Id: String
)