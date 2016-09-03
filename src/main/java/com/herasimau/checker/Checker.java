package com.herasimau.checker;

import com.herasimau.notifier.TelegramNotifier;
import com.herasimau.parser.Parser;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author herasimau on 03.09.2016.
 */
public class Checker {

    private String telegramBotToken;
    private String notifyMessage;
    private int userChatId;
    private int delayInMillisecond;

    private Timer timer = new Timer();

    public void checkStock(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(!new Parser().isOutOfStock()){
                    new TelegramNotifier().setTelegramBotToken(telegramBotToken)
                            .setNotifyMessage(notifyMessage)
                            .setUserChatId(userChatId).notifyUser();

                    timer.cancel();
                }
            }
        },0,delayInMillisecond);

    }

    public Checker setTelegramBotToken(String telegramBotToken) {
        this.telegramBotToken = telegramBotToken;
        return this;
    }

    public Checker setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
        return this;
    }

    public Checker setUserChatId(int userChatId) {
        this.userChatId = userChatId;
        return this;
    }

    public Checker setDelayInMillisecond(int delayInMillisecond) {
        this.delayInMillisecond = delayInMillisecond;
        return this;
    }
}




