package org.demond.java.dereference;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 * Date: 20.04.12
 * Time: 19:21
 */
public class GoogleSafebrowsingChecker
{
    private static Logger logger = Logger.getLogger(GoogleSafebrowsingChecker.class);
    private String requestUrl="https://sb-ssl.google.com/safebrowsing/api/lookup";
    private String apikey = "ABQIAAAACtYlh1rLPpEdO5cpRqlpGhQMm0KiMby2vkWuSNxo4P0QFYaO-Q";
    private String client="api";
    private String appver="1.0";
    private String pver="3.0";

    private static final String CLEAR = "clear";

    public String check(String urlString)
    {
        String result = "";
        try
        {
            String request = requestUrl+"?"+"client="+client+"&apikey="+apikey+"&appver="+appver+"&pver="+pver+"&url="+encodeUrl(urlString);
            if(logger.isDebugEnabled())
                logger.debug(request);
            URL url = new URL(request);
            URLConnection conn = url.openConnection();
            StringBuilder sb = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null)
            {
                sb.append(line);
            }
            rd.close();
            result = sb.toString();
        }
        catch (Exception e)
        {
            logger.warn("Warning",e);
        }
        if(result.equals(""))
            return CLEAR;
        return result;
    }


    private String encodeUrl(String url)
    {
        try
        {
            return java.net.URLEncoder.encode(url, "UTF-8");
        }
        catch(UnsupportedEncodingException e)
        {
            logger.warn("Warning ",e);
        }
        return "";
    }
}
