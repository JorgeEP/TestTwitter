import twitter4j.*;
import twitter4j.auth.*;
import java.io.*;


public class TestTwitter {
    static String CONSUMER_KEY        = "tM4ZCfnkB8waqawxolJ7CHiP3";
    static String CONSUMER_KEY_SECRET = "Yv6ZySZSyGimcU8kcHKbjfcFSnWgtelxkooSGo59Y8eCPkczCl";
    
    public static void main(String[] args) throws Exception {
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
        
        // here's the difference
        String accessToken       = "161307183-Q1DNQGFiHyRq7uICC1oyp7PJSGkHTiCK1U1TLMmB";
        String accessTokenSecret = "Fmaxi99M4a1MSQZ3uu3lvJsAh4FZP8RJIG9ufldkIz2Hh";
        AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
        twitter.setOAuthAccessToken(oathAccessToken);
        // end of difference
        
        // updating twitter status
        twitter.updateStatus("hi.. im updating this using Namex Tweet for Demo");

        System.out.println("\nReading Twitter Timeline:");

        // I'm reading your timeline
        ResponseList<Status> list = twitter.getHomeTimeline();
        
        for(Status each: list) {       
            System.out.println("Sent by: @" + each.getUser().getScreenName()
                    + " - " + each.getUser().getName() + "\n" + each.getText()
                    + "\n");
        }
    }

}
