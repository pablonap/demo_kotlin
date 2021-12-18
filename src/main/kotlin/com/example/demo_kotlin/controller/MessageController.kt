package com.example.demo_kotlin.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import com.example.demo_kotlin.service.MessageService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping

@RestController
class MessageResource(val service: MessageService) {
    @GetMapping
	fun index(): List<Message> = service.findMessages()
//    fun index(): List<Message> = listOf(
//        Message("1", "Hello!"),
//        Message("2", "Bonjour!"),
//        Message("3", "Privet!"),
//    )
	
	@PostMapping
    fun post(@RequestBody message: Message) {
        service.post(message)
    }
}

@Table("MESSAGES")
data class Message(@Id val id: String?, val text: String)