package cn.harper.utils;

import cn.harper.core.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Info {
    private static final Logger logger = LogManager.getLogger(Client.instance.Name);

    public static Logger getLogger() {
        return logger;
    }
}
