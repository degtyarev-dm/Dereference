package org.demond.java.dereference;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 * Date: 27.01.12
 * Time: 18:39
 */
public class DereferenceFactoryCreater
{
    private static Logger logger = Logger.getLogger(DereferenceFactoryCreater.class);

    private Pattern bitlyPattern = Pattern.compile("((http:\\/\\/)?bit\\.ly\\/.*)");
    private Pattern clckruPattern = Pattern.compile("((http:\\/\\/)?clck\\.ru\\/.*)");
    private Pattern isgdPattern = Pattern.compile("((http:\\/\\/)?is\\.gd\\/.*)");
    private Pattern googlPattern = Pattern.compile("((http:\\/\\/)?goo\\.gl\\/.*)");
    private Pattern tcoPattern = Pattern.compile("((http:\\/\\/)?t\\.co\\/.*)");

    public DereferenceReferences getFactory(String url)
    {
        if(logger.isDebugEnabled())
           logger.debug("url: "+url);
        Matcher bitlyMatcher = bitlyPattern.matcher(url);
        if(bitlyMatcher.find())
        {
            if(logger.isDebugEnabled())
                logger.debug("is bit.ly url");
            return new DereferenceBitLy();
        }
        Matcher clckruMatcher = clckruPattern.matcher(url);
        if(clckruMatcher.find())
        {
            if(logger.isDebugEnabled())
                logger.debug("is clck.ru url");
            return new DereferenceClckRu();
        }
        Matcher isgdMatcher = isgdPattern.matcher(url);
        if(isgdMatcher.find())
        {
            if(logger.isDebugEnabled())
                logger.debug("is is.gd url");
            return new DereferenceIsGd();
        }
        Matcher googlMatcher = googlPattern.matcher(url);
        if(googlMatcher.find())
        {
            if(logger.isDebugEnabled())
                logger.debug("is goo.gl url");
            return new DereferenceGooGl();
        }
        Matcher tcoMatcher = tcoPattern.matcher(url);
        if(tcoMatcher.find())
        {
            if(logger.isDebugEnabled())
                logger.debug("is t.co url");
            return new DereferenceTCo();
        }
        else
        {
            logger.warn("Can't match url: "+url);
            return null;
        }
    }
}
