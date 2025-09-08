/* Import SDK classes */
import com.africastalking.Callback;
import com.africastalking.SmsService;
import com.africastalking.sms.Message;
import com.africastalking.sms.Recipient;
import com.africastalking.AfricasTalking;

import java.util.List;
import java.io.IOException;

public class TestSendingWithSenderID {

    public static void main(String[] args) {
		/* Set your app credentials */
		String USERNAME ="bollaApp";
		String API_KEY = "atsk_01e1b2bf693926aab071d85c0c40ba85e1adfacf15a041f68d26c96b47a63823429b23b3";

		/* Initialize SDK */
		AfricasTalking.initialize(USERNAME, API_KEY);

		/* Get the SMS service */
		SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);

		/* Set the numbers you want to send to in international format */
		String[] recipients = new String[] {"+254798169252"};

		/* Set your message */
		String message = "We are lumberjacks. We sleep all day and code all night";


		/* That’s it, hit send and we’ll take care of the rest */
		try {
			List<Recipient> response = sms.send(message, recipients, false);
			for (Recipient recipient : response) {
				System.out.print(recipient.number);
				System.out.print(" : ");
				System.out.println(recipient.status);
				System.out.println(recipient.statusCode);
				System.out.println(recipient.cost);
				System.out.println(recipient.messageId);
				
				break;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
   	}
}
