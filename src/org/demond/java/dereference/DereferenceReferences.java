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
 */
public class DereferenceReferences
{
    private static Logger logger = Logger.getLogger(DereferenceReferences.class);

    private static final String USER_AGENT="Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.121 Safari/535.2";
    private static final String REFERRER = "http://www.google.com";
    private static final boolean FOLLOW_REDIRECTS = false;

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
            String location = response.headers().get("Location");
            if(logger.isDebugEnabled())
                logger.debug("Location = "+location);
            String subLocation = getResponse(response.headers().get("Location")).headers().get("Location");
            while(subLocation!=null && !subLocation.equals(location))
            {
                if(logger.isDebugEnabled())
                    logger.debug("subLocation="+subLocation);
                location = subLocation;
                subLocation = getResponse(location).headers().get("Location");
            }
            return location;
        }
        else
        {
            logger.info("Can't dereference!");
            return referenceUrl;
        }
    }
}
