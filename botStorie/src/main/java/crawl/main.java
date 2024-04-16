package crawl;

public class main {
    public static void main(String[] args) {
        String baseUrl = "https://cotich.net/"; // Base URL for both crawlers

        // Create instances of each bot
        GeneralBot general = new GeneralBot(baseUrl);
        general.run();
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask(){
//            @Override
//            public void run() {
//                general.stop();
//            }
//        }, 5000);
    }
}
