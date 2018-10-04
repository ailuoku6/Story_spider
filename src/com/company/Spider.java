package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Spider {
    private String aimLink;
    private ArrayList<String> pages = new ArrayList<String>();
    private ArrayList<story> stories = new ArrayList<story>();

    public Spider(String aimLink) throws IOException {
        this.aimLink = aimLink;
        this.pages.add(this.aimLink);
        Document doc = Jsoup.connect(this.aimLink).timeout(6000).get();
        Elements Sts = doc.getElementsByTag("article");
        Elements page_index = doc.getElementsByClass("page-numbers");
        for (Element st:Sts){
            story sto = new story(st.select(".entry-title a").text(),st.select(".archive-content").text(),this.aimLink+st.select(".entry-more a").attr("href"),st.select("img").attr("src"));
            this.stories.add(sto);
        }

        for (Element page:page_index){
            this.pages.add(this.aimLink+page.attr("href"));
        }
    }

    public ArrayList<String> getPages(){
        return this.pages;
    }

    public ArrayList<story> getStories(){
        return this.stories;
    }

    public String getStoryDetail(int Index) throws IOException {
        Document StoryDoc = Jsoup.connect(this.stories.get(Index).getLink()).get();
        Elements phs = StoryDoc.select("p");
        StringBuffer text = new StringBuffer();
        for (Element p:phs){
            text.append("    "+p.text()+"\n");
        }
        return text.toString();
    }

    public void spiderCliPage(int Index) throws IOException{
        Document doc  =Jsoup.connect(this.pages.get(Index)).get();
        Elements Sts = doc.getElementsByTag("article");
        for (Element st:Sts){
            story sto = new story(st.select(".entry-title a").text(),st.select(".archive-content").text(),this.aimLink+st.select(".entry-more a").attr("href"),st.select("img").attr("src"));
            this.stories.add(sto);
        }
    }

}
