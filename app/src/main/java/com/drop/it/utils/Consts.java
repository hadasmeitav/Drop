package com.drop.it.utils;

/**
 * Created by hadas on 30/05/2017.
 */

public class Consts {

    public static final String ADDRESS = "Address";

    public static class Environment {

        public static boolean IS_PRODUCTION = false;
        public static String BASE_URL = "https://prd.thecompany.com/api/";

        public static void setEnvironment(boolean isProduction) {
            if (isProduction) {
                IS_PRODUCTION = true;
                BASE_URL = "https://prd.thecompany.com/api/";
            } else {
                IS_PRODUCTION = false;
                BASE_URL = "https://staging.thecompany.com/api/";
            }
        }
    }
}
