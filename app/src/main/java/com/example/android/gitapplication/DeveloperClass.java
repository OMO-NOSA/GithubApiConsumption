package com.example.android.gitapplication;

/**
 * Created by NOSSY on 9/7/2017.
 */

public class DeveloperClass {

    private String userName;
    private String avatarUrl;
    private String htmlUrl;

    public DeveloperClass(String userName,String avatarUrl,String htmlUrl)
    {
        this.userName=userName;
        this.avatarUrl=avatarUrl;
        this.htmlUrl=htmlUrl;

    }

    public String getUserName() {
        return userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}

