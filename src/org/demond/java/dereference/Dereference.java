package org.demond.java.dereference;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 * Date: 27.01.12
 * Time: 19:13
 */
public class Dereference
{
    public String dereferenceUrl(String url)
    {
        DereferenceFactoryCreater factoryCreater = new DereferenceFactoryCreater();
        DereferenceReferences dereference = factoryCreater.getFactory(url);
        return dereference.dereference(url);  
    }

    public String dereferenceAndCheckUrl(String url)
    {
        return null;
    }
}
