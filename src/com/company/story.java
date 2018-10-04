package com.company;

public class story {
    private String title;
    private String subTitle;
    private String link;
    private String imgLink;
    public story(String title,String subTitle,String link,String imgLink){
        this.title = title;
        this.subTitle = subTitle;
        this.link = link;
        this.imgLink = imgLink;
    }

    public String getTitle(){
        return this.title;
    }

    public String getSubTitle(){
        return this.subTitle;
    }

    public String getLink(){
        return this.link;
    }

    public String getImgLink(){
        return this.imgLink;
    }
}
