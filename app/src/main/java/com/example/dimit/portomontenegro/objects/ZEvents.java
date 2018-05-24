package com.example.dimit.portomontenegro.objects;

public class ZEvents {

    public String Title;
    public String ImageUrl;
    public String Type;

    public ZEvents()
    {
        Title="";
        ImageUrl="";
        Type="";
    }

    public ZEvents(String Title, String ImageUrl, String Type)
    {

        this.Title=Title;
        this.Type=Type;
        this.ImageUrl=ImageUrl;
    }
}
