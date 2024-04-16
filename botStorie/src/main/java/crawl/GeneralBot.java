package crawl;

public class GeneralBot {
    StoryBot t;

    public GeneralBot(String baseUrl) {
        t = new StoryBot(baseUrl);
    }

    public void run() {
        t.start();
    }

    public void stop(){
        t.interrupt();
        try {
            t.sleep(0);
        } catch (InterruptedException ex) {
//            Logger.getLogger(GeneralBot.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
