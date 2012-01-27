package org.demond.java.dereference;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 * Date: 24.01.12
 * Time: 18:35
 */
public class DereferenceBitLy extends DereferenceReferences
{
    private static Logger logger = Logger.getLogger(DereferenceBitLy.class);
    
    @Override
    public String dereference(String referenceUrl)
    {
        if(logger.isDebugEnabled())
            logger.debug("try dereference "+ referenceUrl);
        return getLocation(referenceUrl);
    }

}
