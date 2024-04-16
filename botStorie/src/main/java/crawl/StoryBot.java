package crawl;

import crawl.Entity.Truyen;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class StoryBot extends BaseBot{
    public StoryBot(String baseUrl) {
        super(baseUrl);
    }

    @Override
    protected void crawl(String baseUrl){
        super.crawl(baseUrl);
        for (String url : visitedUrls) {
            processPageData(url);
        }
    }

    protected void processPageData(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            String type = ".news-item"; // The tags for story
            Elements data = doc.select(type);
            String tag = ".title > h1 > a";
            Elements tags = doc.select(tag);
            if (!tags.html().isEmpty()) {
                System.out.println("Tags: " + tags.html());
            }
            for (Element item : data) {
                String title = item.select("h4 > a").html();
                String linkUrl = item.select("h4 > a").attr("href");
                String img = item.select(".img > a > img").attr("src");
                String info = item.select(".info-post").text();
                String sapo = item.select(".sapo").text();

                Truyen t = new Truyen(title, img, linkUrl, info, sapo);
                System.out.println(t);

            }
        } catch (IOException ex) {
//            Logger.getLogger(StoryBot.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
