package com.example.excalhandler.util.common;

public class CommonRegex {

    // yyyy-MM-dd HH:mm:ss
    public static final String DATEREGEX =
            "[1-9]{1}[0-9]{3}-[0-1]{0,1}[0-9]{1}-[0-3]{0,1}[0-9]{1} [0-2]{0,1}[0-9]{1}:[0-5]{0,1}[0-9]{1}:[0-5]{0,1}[0-9]{1}";

    // yyyy-MM-dd
    public static final String DATEDAYREGEX = "[1-9]{1}[0-9]{3}-[0-1]{0,1}[0-9]{1}-[0-3]{0,1}[0-9]{1}";

    // yyyy-MM
    public static final String DATEMONTHREGEX = "[1-9]{1}[0-9]{3}-[0-1]{0,1}[0-9]{1}";

    // HH:mm:ss
    public static final String TIMEREGEX = "[0-2]{0,1}[0-9]{1}:[0-5]{0,1}[0-9]{1}:[0-5]{0,1}[0-9]{1}";

    // number
    public static final String NUMBERREGEX = "[0-9]*";

    // number and null String
    public static final String NUMBER_NULLREGEX = "[0-9\\s]*";

    // number
    public static final String NUMBERLETTERREGEX = "[0-9a-zA-Z]*";

    //
    public static final String LETTERREGEX = "[A-Z]*";

    // number and null String
    public static final String NUMBERLETTER_NULLREGEX = "[0-9a-zA-Z\\s]*";

    // IP
    public static final String IPREGEX =
            "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b";

    // carNo
    public static final String CARNOREGX = "[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$";
}
