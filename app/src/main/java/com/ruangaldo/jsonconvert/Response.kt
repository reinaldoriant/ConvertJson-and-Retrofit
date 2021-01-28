package com.ruangaldo.jsonconvert

data class Response(
	var isZomblo: Boolean? = null,
	var nIM: String? = null,
	var semester: Int? = null,
	var jurusan: String? = null,
	var matakuliah: List<MatakuliahItem?>? = null,
	var age: Int? = null,
	var name: String? = null
)

data class MatakuliahItem(
	val nama: String? = null
)

