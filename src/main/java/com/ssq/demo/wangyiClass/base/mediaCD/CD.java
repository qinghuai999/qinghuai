package com.ssq.demo.wangyiClass.base.mediaCD;

import lombok.Data;

/**
 * @Author 苏诗淇
 * @Date 2020/6/6 16:00
 * @Description: 实体类
 */
@Data
public class CD {
    private String title;
    private String artist;
    private int numOfTracks;
    private int playingTime;
    private boolean gotIt;
    private String content;

    public CD(String title, String artist, int numOfTracks, int playingTime, boolean gotIt, String content) {
        this.title = title;
        this.artist = artist;
        this.numOfTracks = numOfTracks;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.content = content;
    }

    public void print() {
        System.out.println("title: " + title + ", artist: " + artist + ", gotIt: " + gotIt);
    }
}
