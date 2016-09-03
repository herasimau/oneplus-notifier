import com.herasimau.checker.Checker;

/**
 * @author herasimau on 03.09.2016.
 */
public class Main {

    public static void main(String[] args) {

       new Checker().setTelegramBotToken("YOUR_TOKEN")
                    .setUserChatId(0) // CHAT ID WHERE TO SEND NOTIFICATION
                    .setNotifyMessage("YOUR_NOTIFICATION_MESSAGE")
                    .setDelayInMillisecond(10000) //delay in ms to parse https://oneplus.net for updates.
                    .checkStock();

    }


}
