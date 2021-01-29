package com.ruangaldo.jsonconvert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity2 : AppCompatActivity() {
    private var rvMain: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val jsonTest: String =
                applicationContext.assets.open("Student2.json").bufferedReader().use { it.readText() }

        var test = Test()

        val jsonObject = JSONObject(jsonTest)
        val page = jsonObject.getInt("page")
        val totalPages = jsonObject.getInt("total_pages")
        val totalResults = jsonObject.getInt("total_results")

        val resultItem = arrayListOf<ResultsItem>()

        val resultsItemArray = jsonObject.getJSONArray("results")

        for (i in 0 until resultsItemArray.length()) {
            val jsonObjectResult = resultsItemArray.getJSONObject(i)

            val genreArray = jsonObjectResult.getJSONArray("genre_ids")
            val genreItem = arrayListOf<Int>()

            for (i in 0 until genreArray.length()) {
                genreItem.add(genreArray.getInt(i))
            }

            val countryArray = jsonObjectResult.getJSONArray("origin_country")
            val countryItem = arrayListOf<String>()

            for (i in 0 until countryArray.length()) {
                countryItem.add(countryArray.getString(i))
            }

            resultItem.add(
                    ResultsItem(
                            firstAirDate = jsonObjectResult.getString("first_air_date"),
                            id = jsonObjectResult.getInt("id"),
                            name = jsonObjectResult.getString("name"),
                            originalLanguage = jsonObjectResult.getString("original_language"),
                            originalName = jsonObjectResult.getString("original_name"),
                            overview = jsonObjectResult.getString("overview"),
                            popularity = jsonObjectResult.getDouble("popularity"),
                            posterPath = jsonObjectResult.getString("poster_path"),
                            voteAverage = jsonObjectResult.getInt("vote_average"),
                            voteCount = jsonObjectResult.getInt("vote_count"),
                            genreIds = genreItem,
                            originCountry = countryItem
                    )
            )
        }
        test.page = page
        test.totalPages = totalPages
        test.results = resultItem
        test.totalResults = totalResults

        val test2 = Gson().fromJson(jsonTest,Test::class.java)
        findViewById<TextView>(R.id.tvShowData).text = test2.toString()

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}