package com.example.dimit.portomontenegro.objects;

/**
 * Created by vlatko.bojkovski on 20.3.2018.
 */

public class UModuleRequest
{
    public String metod;
    public String username;
    public String type;
    public String token;
    public String p1;
    public String p2;
    public String p3;
    public String p4;
    public String p5;
    public String p6;
    public String p7;
    public String p8;
    public String p9;
    public String p10;
    public UModuleRequest() {
        metod = "";
        username = "";
        type = "";
        token = "";
        p1 = "";
        p2 = "";
        p3 = "";
        p4 = "";
        p5 = "";
        p6 = "";
        p7 = "";
        p8 = "";
        p9 = "";
        p10 = "";
    }
    public String toJson(){
        String k = "{ ";
        k+=" \"metod\":\""+metod+"\", ";
        k+=" \"username\":\""+username+"\", ";
        k+=" \"type\":\""+type+"\", ";
        k+=" \"token\":\""+token+"\", ";
        k+=" \"p1\":\""+p1+"\", ";
        k+=" \"p2\":\""+p2+"\", ";
        k+=" \"p3\":\""+p3+"\", ";
        k+=" \"p4\":\""+p4+"\", ";
        k+=" \"p5\":\""+p5+"\", ";
        k+=" \"p6\":\""+p6+"\", ";
        k+=" \"p7\":\""+p7+"\", ";
        k+=" \"p8\":\""+p8+"\", ";
        k+=" \"p9\":\""+p9+"\", ";
        k+=" \"p10\":\""+p10+"\" }";
        return k;
    }

}
