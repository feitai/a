package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: ${NAME}
 * Author: heyv
 * Time: 2023 2023/7/27 13:56
 */
public class Test2 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Test2.class);
        logger.error("Usage: ${error}");
        logger.warn("Usage: ${warn}");
        logger.info("Usage: ${info}");
        logger.trace("Usage: ${trace}");
        logger.debug("Usage: ${debug}");
    }
}