package com.herasimau.notifier;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * @author herasimau on 03.09.2016.
 */
public class TelegramNotifier {

    private String telegramBotToken;
    private String notifyMessage;
    private int userChatId;


    private TelegramBot bot = TelegramBotAdapter.build(telegramBotToken);


    public TelegramNotifier(){
    }

    public TelegramNotifier setTelegramBotToken(String telegramBotToken){
        this.telegramBotToken = telegramBotToken;
        return this;
    }

    public TelegramNotifier setUserChatId(int userChatId){
        this.userChatId = userChatId;
        return this;
    }

    public TelegramNotifier setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
        return this;
    }

    public void notifyUser() {

        if(notifyMessage!= null && userChatId!=0){
             bot.execute(new SendMessage(userChatId, notifyMessage));
        }

    }
}
