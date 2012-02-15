package org.demond.java.dereference;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 */
public class Dereference
{
    public String dereferenceUrl(String url)
    {
        DereferenceReferences dereference = new DereferenceReferences();
        return dereference.getLocation(url);
    }

    public String dereferenceAndCheckUrl(String url)
    {
        return null;
    }
}
