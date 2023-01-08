package com.telegramBot.telegramBot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telegramBot.telegramBot.service.TelegramBot;

@RestController
public class BotController {
	
	@Autowired
	private TelegramBot telegramBot;

	@PostMapping("/telegramBot")
	public void sendMessage(@RequestBody String message) throws IOException
	{
		this.telegramBot.sendMessage(message);
	}
}
