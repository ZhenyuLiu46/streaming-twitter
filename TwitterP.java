
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.io.*;

public class TwitterP {
	
	public static void main(String[] args) throws Exception {
		PrintWriter writer = new PrintWriter("testOutput.txt", "UTF-8");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("*")
		  .setOAuthConsumerSecret("*")
		  .setOAuthAccessToken("*-*")
		  .setOAuthAccessTokenSecret("*");
		
		StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	        	writer.println(status.getUser().getName() + " : " + status.getText());
	            System.out.println(status.getUser().getName() + " : " + status.getText());
	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
	    };
	    TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
	    twitterStream.addListener(listener);
	    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
	    twitterStream.sample();
		
		
		

