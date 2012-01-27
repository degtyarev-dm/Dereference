package org.demond.java.dereference;

import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 * Date: 27.01.12
 * Time: 20:24
 */
public class DereferenceGooGl extends DereferenceReferences
{
    private static Logger logger = Logger.getLogger(DereferenceGooGl.class);

    @Override
    public String dereference(String referenceUrl)
    {
        if(logger.isDebugEnabled())
            logger.debug("try dereference "+referenceUrl);
        return getLocation(referenceUrl);
    }
}
