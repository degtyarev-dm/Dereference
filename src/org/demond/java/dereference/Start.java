package org.demond.java.dereference;


import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: degtyarev.dm
 * Date: 24.01.12
 * Time: 18:32
 */
public class Start
{
    private static Logger logger = Logger.getLogger(Start.class);

    public static void main(String [] args)
    {
        logger.info("[start]");
        //http://bit.ly/xZ8zCZ  ->  http://autokadabra.ru/shouts/47417
        //http://clck.ru/0q     ->  http://google.com
        //http://is.gd/qQ9jHv   ->  http://yandex.ru
        //http://goo.gl/K2zBM   ->  http://habrahabr.ru/
        //http://t.co/TENldP40  ->  http://moto.ly/rls2

        String url = "http://t.co/7gvMxglJ";
        Dereference dereference = new Dereference();
        dereference.dereferenceUrl(url);
        logger.info("[finish]");
    }
}
