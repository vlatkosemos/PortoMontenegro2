package com.example.dimit.portomontenegro.objects;

public class ZFacilities {

    public String Title;
    public String ImageUrl;
    public int Type;
    public ZFacilities()
    {
        Title="";
        Type=0;
        ImageUrl="";
    }

    public ZFacilities(String Title, String ImageUrl, Integer Type)
    {

        this.Title=Title;
        this.ImageUrl=ImageUrl;
        this.Type=Type;
    }
}
