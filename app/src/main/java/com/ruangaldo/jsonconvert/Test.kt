package com.ruangaldo.jsonconvert

data class ResultsItem(
	var firstAirDate: String? = null,
	var overview: String? = null,
	var originalLanguage: String? = null,
	var genreIds: List<Int?>? = null,
	var posterPath: String? = null,
	var originCountry: List<String?>? = null,
	var originalName: String? = null,
	var popularity: Double? = null,
	var voteAverage: Int? = null,
	var name: String? = null,
	var id: Int? = null,
	var voteCount: Int? = null
)

data class Test(
	var page: Int? = null,
	var totalPages: Int? = null,
	var results: List<ResultsItem?>? = null,
	var totalResults: Int? = null
)

