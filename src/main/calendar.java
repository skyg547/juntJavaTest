package main;

import java.text.DateFormat;
import java.util.Calendar;

import org.apache.xmlbeans.impl.common.SniffedXmlInputStream;

public class calendar {
    public static void main(String[] args) {
        System.out.println(1);

        Calendar cal = Calendar.getInstance();
        System.out.println((cal.getTime().toLocaleString()));

        cal.set(2022, 1 - 1, 3);
        System.out.println((cal.getTime().toString()));

        cal.add(cal.MONTH, -1);
        
        StringBuffer sb = new StringBuffer();

        sb.append(cal.get(cal.YEAR));
        // sb.append("-");
        sb.append(cal.get(cal.MONTH) + 1);
        sb.append("01");
        System.out.println(sb.toString());
        // System.out.println((cal.getTime().toString()));
        // DateFormat dateFormat = DateFormat.getDateTimeInstance();
        
        // String[] dates = dateFormat.format(cal.getTime()).replace(".", "").split(" ");
        // for (int i = 0; i < 3; i++) {
        //     if (dates[i].length() == 1) {
        //         dates[i] = String.format("%02", dates[i]);
        //     }
        //     sb.append(dates[i]);
        //     System.out.println(dates[i]);
        // }
        // System.out.println(sb.toString());

        // for (String string : dateFormat.format(cal.getTime()).split(" ")) {
        // System.out.println(string);

        // }
        // // System.out.println(.[0]);
        // System.out.println(dateFormat.format(cal.getTime()).replace(".", "").split("
        // ")[0]);
        // System.out.println(dateFormat.format(cal.getTime()).replaceAll("",
        // "").length());

    }
}
