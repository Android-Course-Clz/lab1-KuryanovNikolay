package com.example.lesson

import PostAdapter
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson.models.Post
import com.example.lesson.models.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Пример данных пользователя
        val user = User(
            id = 1,
            name = "Николай Курьянов",
            avatarUrl = "https://sun9-20.userapi.com/s/v1/ig2/fmnsWTrH3sEPA9GJslSnAxq1RjzD5yjczC28bNcl8Xc5ZvgmCJv46FT_3z8d-dBGH1t9h7o2j76_-_FQQYw3wTX1.jpg?quality=95&as=32x32,48x48,72x72,108x108,160x160,240x240,360x360,480x480,540x540,640x640,720x720,960x960&from=bu&u=HfsMTLJECGGXSWWW76zMFzxOyYtJrz-UOSB_HFjgjCA&cs=807x807",
            status = "Active",
            age = 28,
            friendsCount = 200,
            city = "Moscow"
        )

        // Пример данных постов с изображениями
        val posts = listOf(
            Post(id = 1, userId = 1, content = "Post 1 content", date = "March 10, 2025", imageResId = R.drawable.prank),
            Post(id = 2, userId = 1, content = "Post 2 content", date = "March 9, 2025", imageResId = R.drawable.avatar) // Используйте реальные ресурсы
        )

        // Найдем элементы на странице
        val userData: TextView = findViewById(R.id.text_first)
        val userAvatar: ImageView = findViewById(R.id.image)

        // Заполняем данные пользователя
        userData.text = user.name
        userAvatar.setImageResource(R.drawable.prank) // Здесь загружается изображение

        // Настроим RecyclerView
        val postsRecyclerView: RecyclerView = findViewById(R.id.postsRecyclerView)
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = PostAdapter(posts)
    }
}
