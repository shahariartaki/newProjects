package com.example.taki.newproject.notice_board;

public class noticeboard_model {
    private String title;
    private String publishDate;
    private String more;
    private String name;

    public noticeboard_model() {
    }

    public noticeboard_model(String title, String publishDate, String more) {

        this.title=title;
        this.publishDate=publishDate;
        this.more=more;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }


}
