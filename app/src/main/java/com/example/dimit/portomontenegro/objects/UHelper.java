package com.example.dimit.portomontenegro.objects;

/**
 * Created by vlatko.bojkovski on 20.3.2018.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
*/
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

public class UHelper {
    final Context context;

    public UHelper() {
        context = null;
    }

    public UHelper(Context context) {
        this.context = context;
    }

    private static final String URL3 = "http://demo6.semos.com.mk/uService.asmx";
    private static final String NAMESPACE3 = "http://demo6.semos.com.mk/";

    private static final String METHOD_NAME3 = "GetPodatoci";
    private static final String SOAP_ACTION3 = "http://demo6.semos.com.mk/GetPodatoci";

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toLowerCase();
        } catch (java.security.NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
        return null;
    }

    public JSONArray GetPodatoci(String podatoci) {
        JSONArray vrati = new JSONArray();
        SoapObject request = new SoapObject(NAMESPACE3, METHOD_NAME3);
        //if w3schools
        //request.addProperty("Celsius", "32");
        //request.addProperty("languageid", Integer.toString(languageId));
        request.addProperty("podatoci", podatoci);
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(request);

        AndroidHttpTransport aht = new AndroidHttpTransport(URL3);
        try {
            aht.call(SOAP_ACTION3, soapEnvelope);
            SoapPrimitive rez = (SoapPrimitive) soapEnvelope.getResponse();
            vrati = new JSONArray(rez.toString());

        } catch (Exception e) {

        }
        return vrati;

    }

    public JSONObject GetPodatoci(UModuleRequest req) {
        JSONObject vrati = new JSONObject();
        SoapObject request = new SoapObject(NAMESPACE3, METHOD_NAME3);
        request.addProperty("podatoci", req.toJson().toString());
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(request);
        AndroidHttpTransport aht = new AndroidHttpTransport(URL3);
        try {
            aht.call(SOAP_ACTION3, soapEnvelope);
            SoapPrimitive rez = (SoapPrimitive) soapEnvelope.getResponse();
            vrati = new JSONObject(rez.toString());
        } catch (Exception e) {
            String k = "{ \"OK\":\"" + e.getMessage() + "\" }";
            try {
                vrati = new JSONObject(k);
            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return vrati;
    }

    public UModuleResponse GetPodatoci2(UModuleRequest req) {
        UModuleResponse vrati = new UModuleResponse();
        SoapObject request = new SoapObject(NAMESPACE3, METHOD_NAME3);

        request.addProperty("podatoci", req.toJson().toString());
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(request);

        AndroidHttpTransport aht = new AndroidHttpTransport(URL3);
        try {
            aht.call(SOAP_ACTION3, soapEnvelope);
            SoapPrimitive rez = (SoapPrimitive) soapEnvelope.getResponse();
            JSONObject jo = new JSONObject(rez.toString());

            String metod = jo.optString("metod");
            String status = jo.optString("status");
            String message = jo.optString("message");
            String podatoci = jo.optString("podatoci");
            String data = jo.optString("data");

            vrati.metod = metod;
            vrati.status = status;
            vrati.message = message;
            vrati.podatoci = podatoci;
            vrati.data = data;
        } catch (Exception e) {
            vrati.message = e.getMessage().toString();
        }


        return vrati;

    }

    public String GetPodatociString(UModuleRequest req) {
        String vrati = "";
        SoapObject request = new SoapObject(NAMESPACE3, METHOD_NAME3);
        request.addProperty("podatoci", req.toJson());
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(request);
        AndroidHttpTransport aht = new AndroidHttpTransport(URL3);
        try {
            aht.call(SOAP_ACTION3, soapEnvelope);
            SoapPrimitive rez = (SoapPrimitive) soapEnvelope.getResponse();
            vrati = rez.toString();
        } catch (Exception e) {
            vrati = "GRESKA " + e.getMessage();
        }
        return vrati;
    }
}
