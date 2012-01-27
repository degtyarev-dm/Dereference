package org.demond.java.dereference;

import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 * Date: 27.01.12
 * Time: 20:11
 */
public class DereferenceClckRu extends DereferenceReferences
{
    private static Logger logger = Logger.getLogger(DereferenceClckRu.class);
    
    @Override
    public String dereference(String referenceUrl)
    {
        if(logger.isDebugEnabled())
            logger.debug("try dereference "+referenceUrl);
        return getLocation(referenceUrl);
    }
}
