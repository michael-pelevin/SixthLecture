package com.example.sixthlecture

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.gson.Gson

val userData = """
    {
      "id": "1",
        "FIO": "Иванов Иван Иванович",
        "status": true,
        "BD": "1.01.1980",
        "avatar": "https://cdn.pixabay.com/photo/2018/08/28/12/41/avatar-3637425_960_720.png",
        "experience": "2 года 5 месяцев",
        "phone": "+79999999999",
        "email": "example@ex.ru",
        "vk": "https://vk.com/tensor_company",
        "department": "Отдел разработок и исследований",
        "position": "Ведущий инжинер-программист (3 категории, моб)",
        "projects": "Проект 1,Проект 2",
        "achievements": "1 год работы, 2 года работы,Нашел тот баг",
        "awards": "Лучший разработчик 2021"
      
    }
"""

var gson = Gson()
var data = gson?.fromJson(userData, Person.PersonData::class.java)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val status = findViewById<TextView>(R.id.userStatus)
        val avatar = findViewById<ImageView>(R.id.userAvatar)
        val bd = findViewById<TextView>(R.id.userBD)
        val exp = findViewById<TextView>(R.id.userExperience)
        val fio = findViewById<TextView>(R.id.userName)
        val phone = findViewById<TextView>(R.id.userPhone)
        val email = findViewById<TextView>(R.id.userEmail)
        val vkTitle = findViewById<TextView>(R.id.vkTitle)
        val vk = findViewById<TextView>(R.id.userVK)
        val dept = findViewById<TextView>(R.id.userDept)
        val position = findViewById<TextView>(R.id.userPosition)
        val achievements = findViewById<TextView>(R.id.userAchievements)
        val awards = findViewById<TextView>(R.id.userAwards)

        phone.text = data.phone
        email.text = data.email

        if (data.vk != ""){
            vk.text = data.vk
        } else {
            vk.visibility = View.GONE
            vkTitle.visibility = View.GONE
        }

        val message = findViewById<Button>(R.id.sendMessage)
        val call = findViewById<Button>(R.id.sendCall)
        val achievementsBtn = findViewById<TextView>(R.id.achievementsButton)
        val awardsBtn = findViewById<TextView>(R.id.awardsButton)


//        if (data.avatar != "") {
//            val url = URL(data.avatar)
//            val httpConn: HttpURLConnection = url.openConnection() as HttpURLConnection
//
//            httpConn.connect()
//            val resCode: Int = httpConn.getResponseCode()
//
//            if (resCode == HttpURLConnection.HTTP_OK) {
//                val inS: InputStream = httpConn.getInputStream()
//                val bitmap = BitmapFactory.decodeStream(inS)
//                avatar.setImageBitmap(bitmap)
//            }
//        }

        var awardsFlag = false
        var achievementsFlag = false


        message.setOnClickListener{
            Toast.makeText(applicationContext, "Сообщение на "+ data.email, Toast.LENGTH_SHORT).show()
        }

        call.setOnClickListener{
            Toast.makeText(applicationContext, "Вызов на "+ data.phone, Toast.LENGTH_SHORT).show()
        }


        achievementsBtn.setOnClickListener {
            if (achievementsFlag) {
                achievements.visibility = View.GONE
                achievementsBtn.text = getString(R.string.expand)
                achievementsFlag = false
            } else {
                achievements.visibility = View.VISIBLE
                achievementsBtn.text = getString(R.string.collapse)
                achievementsFlag = true
            }
        }

        awardsBtn.setOnClickListener {
            if(awardsFlag){
                awards.visibility = View.GONE
                awardsBtn.text = getString(R.string.expand)
                awardsFlag = false
            }else{
                awards.visibility = View.VISIBLE
                awardsBtn.text = getString(R.string.collapse)
                awardsFlag = true
            }
        }


        if (data.status){
            status.text = getString(R.string.online)
            status.setTextColor(Color.GREEN)
        }
        else {
            status.text = getString(R.string.offline)
            status.setTextColor(Color.GRAY)
        }

        bd.text = data.BD
        exp.text = data.experience

        fio.text = data.FIO

        dept.text = data.department
        position.text = data.position

        if(data.achievements != ""){
            achievements.text = data.achievements
        }else{
            achievements.text = getString(R.string.none_achievements)
        }

        if(data.achievements != ""){
            awards.text = data.awards
        }else{
            awards.text = getString(R.string.none_awards)
        }
    }
}