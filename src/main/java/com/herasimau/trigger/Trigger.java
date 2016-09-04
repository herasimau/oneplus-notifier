package com.herasimau.trigger;

import com.herasimau.notifier.TelegramNotifier;
import com.herasimau.parser.Parser;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author herasimau on 03.09.2016.
 */
public class Trigger {

    private String telegramBotToken;
    private String notifyMessage;
    private int userChatId;
    private int delayInMillisecond;

    private Timer timer = new Timer();

    public void executeTask(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                    if(!isOutOfStock()){
                        new TelegramNotifier()
                                .setTelegramBotToken(telegramBotToken)
                                .setNotifyMessage(notifyMessage)
                                .setUserChatId(userChatId)
                                .notifyUser();

                        timer.cancel();
                    }
            }
        },0,delayInMillisecond);

    }



    public boolean isOutOfStock()  {
        String stockQuantity = new Parser().parse();
        return stockQuantity.equals("Out of stock");
    }

    public Trigger setTelegramBotToken(String telegramBotToken) {
        this.telegramBotToken = telegramBotToken;
        return this;
    }

    public Trigger setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
        return this;
    }

    public Trigger setUserChatId(int userChatId) {
        this.userChatId = userChatId;
        return this;
    }

    public Trigger setDelayInMillisecond(int delayInMillisecond) {
        this.delayInMillisecond = delayInMillisecond;
        return this;
    }
}




