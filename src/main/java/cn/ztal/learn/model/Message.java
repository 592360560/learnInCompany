package cn.ztal.learn.model;

import java.io.Serializable;

public class Message implements Serializable {
    private String title;
    private String info;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
