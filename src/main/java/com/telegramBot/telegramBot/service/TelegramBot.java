package com.telegramBot.telegramBot.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.telegramBot.telegramBot.credentials.Credentials;

@Service
public class TelegramBot{
	
	public void sendMessage(String message) throws IOException {
		Credentials cred = new Credentials();
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        urlString = String.format(urlString, cred.botToken, cred.chatID, message);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            StringBuilder sb = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
//            You can set this String to any TextView
//            String response = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}

/**
@Service
public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        final String messageTextReceived = update.getMessage().getText();

        System.out.println("User message: " + messageTextReceived);

        final long chatId = update.getMessage().getChatId();

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Thanks for writing to us");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return cred.botUsername;
    }

    @Override
    public String getBotToken() {
        return cred.apiToken;
    }
}
*/