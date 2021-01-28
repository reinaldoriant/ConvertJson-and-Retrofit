package com.ruangaldo.jsonconvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonStudent:String=applicationContext.assets.open("Student.json").bufferedReader().use{it.readText()}
        val student=Response()

        val jsonObject=JSONObject(jsonStudent)
        val nama=jsonObject.getString("Name")
        val age=jsonObject.getInt("age")
        val jurusan=jsonObject.getString("jurusan")
        val nim=jsonObject.getString("NIM")
        val semester=jsonObject.getInt("Semester")
        val isZomblo=jsonObject.getBoolean("IsZomblo")

        student.name=nama
        student.age=age
        student.jurusan=jurusan
        student.nIM=nim
        student.semester=semester
        student.isZomblo=isZomblo

        val matakuliahItem= arrayListOf<MatakuliahItem>()
        val matakuliahArray =jsonObject.getJSONArray("Matakuliah")
        for(i in 0 until matakuliahArray.length()){
            val jsonObjectMatakul=matakuliahArray.getJSONObject(i)
            val nama=jsonObjectMatakul.getString("nama")
            matakuliahItem.add(MatakuliahItem(nama))
        }
        student.matakuliah=matakuliahItem
        findViewById<TextView>(R.id.cobaText).text=student.toString()


    }
}