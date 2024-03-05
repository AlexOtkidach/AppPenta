package com.example.penta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {

    private lateinit var adapter: ChatAdapter
    private lateinit var recyclerViewChat: RecyclerView
    private lateinit var editTextMessage: EditText
    private val messages: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerViewChat = findViewById(R.id.recyclerViewChat)
        editTextMessage = findViewById(R.id.editTextMessage)
        val buttonSend: Button = findViewById(R.id.buttonSend)

        val messages = mutableListOf("Привет", "Что у вас за вопрос?", "Чем я смогу помочь?")
        adapter = ChatAdapter(messages)
        recyclerViewChat.adapter = adapter
        recyclerViewChat.layoutManager = LinearLayoutManager(this)

        buttonSend.setOnClickListener {
            val message = editTextMessage.text.toString()
            if (message.isNotBlank()) {
                sendMessage(message)
                editTextMessage.text.clear()
            }
        }
    }

    private fun sendMessage(message: String) {
        val newMessage = "Вы: $message"
        messages.add(newMessage) // Предполагается, что messages - это ваш список сообщений
        adapter.notifyDataSetChanged()
        recyclerViewChat.scrollToPosition(adapter.itemCount - 1)
    }
}