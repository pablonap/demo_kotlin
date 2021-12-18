package com.example.demo_kotlin.service

import org.springframework.stereotype.Service
import com.example.demo_kotlin.repository.MessageRepository
import com.example.demo_kotlin.controller.Message

@Service
class MessageService(val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findMessages()

    fun post(message: Message){
        db.save(message)
    }
}