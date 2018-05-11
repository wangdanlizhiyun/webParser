package com.lzy.webparser;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lizhiyun on 2018/4/12.
 */

public class Util {
    public static boolean parserWebUrl(String url) {
        try {
            Pattern pattern = Pattern
                    .compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
            return pattern.matcher(url).matches();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> match(String source, String element, String attr) {
        List<String> result = new ArrayList<String>();
        //2个顺序。。
        String reg = "<"+element+"[^>]+rel=\"apple-touch-icon[^>\"]+\"\\s"+attr+"=\"([^\"]+)\"";
        String reg1 = "<"+element+"[^>]+"+attr+"=\"([^\"]+)\"\\srel=\"apple-touch-icon[^>\"]+\"";

        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        m = Pattern.compile(reg1).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        return result;
    }

    public static String parserIcon(String body) {
        String icon = null;
        long start = System.currentTimeMillis();
        try {
            int index = body.indexOf("<head>");
            body = body.substring(index + 6);
            int index1 = body.indexOf("</head>");
            String header = body.substring(0, index1);
            icon = match(header, "link", "href").get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.v("test", "耗时=  " + (System.currentTimeMillis() - start));
        return icon;
    }


}
