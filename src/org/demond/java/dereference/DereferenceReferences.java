package org.demond.java.dereference;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 * Date: 24.01.12
 * Time: 18:33
 */
public abstract class DereferenceReferences
{
    private static Logger logger = Logger.getLogger(DereferenceReferences.class);

    private static final String USER_AGENT="Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.121 Safari/535.2";
    private static final String REFERRER = "http://www.google.com";
    private static final boolean FOLLOW_REDIRECTS = false;
    public String dereference(String referenceUrl)
    {
        return referenceUrl;
    }
    
    public Connection.Response getResponse(String url)
    {
        Connection.Response response = null;
        try
        {
            response = Jsoup.connect(url).referrer(REFERRER).userAgent(USER_AGENT).followRedirects(FOLLOW_REDIRECTS).execute();
            return response;
        } catch (IOException e)
        {
            logger.warn("Warning: ",e);
        }
        return response;
    }
    
    protected String getLocation(String referenceUrl)
    {
        Connection.Response response = getResponse(referenceUrl);
        if(response!=null && response.headers()!=null && !response.headers().isEmpty() && response.headers().get("Location")!=null)
        {
            if(logger.isDebugEnabled())
                logger.debug("Location = "+response.headers().get("Location"));

            return response.headers().get("Location");
        }
        else
        {
            logger.warn("Can't dereference!");
            return referenceUrl;
        }
    }
}
