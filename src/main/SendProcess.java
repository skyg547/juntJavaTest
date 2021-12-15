package main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SendProcess {

    public static void main(String[] args) {

        new SendProcess().makeDocument();
        System.out.println(1);

    }

    /*
     * [
     * {MOB_SLIP_NO=MOBSL2021120388,
     * USER_NM=정용진,
     * DEPT_NM=관리정보팀,
     * SLIP_AMT=1400,
     * ESSNC_CNTN=정용진_신청(모바일_경비신청),
     * ACNT_DT=20211023,
     * REG_DTM=2021-12-15 11:23:33.0, SLIP_ST_CD=1},
     * 
     * {MOB_SLIP_NO=MOBSL2021120388,
     * USER_NM=정용진,
     * DEPT_NM=관리정보팀,
     * SLIP_AMT=1400,
     * ESSNC_CNTN=정용진_신청(모바일_경비신청),
     * ACNT_DT=20211023,
     * REG_DTM=2021-12-15 11:23:33.0,
     * SLIP_ST_CD=1},
     * 
     * {MOB_SLIP_NO=MOBSL2021120388,
     * USER_NM=정용진,
     * DEPT_NM=관리정보팀,
     * SLIP_AMT=1400,
     * ESSNC_CNTN=정용진_신청(모바일_경비신청),
     * ACNT_DT=20211023,
     * REG_DTM=2021-12-15 11:23:33.0,
     * SLIP_ST_CD=1}];
     */

    List<LinkedHashMap<String, Object>> sql2 = null;

    // [
    // {SLIP_SNO=1,
    // ESSNC_CNTN=일 석,
    // AC_AMT=1400,
    // AC_CD=복리후생비_실비식대_석식,
    // VAT_AMT=127,
    // SVOS=1273,
    // SUP_NM=GS25 제주노형점,
    // MNG_DT=20211023}];

    List<LinkedHashMap<String, Object>> sql3 = null;
    // [{AC_AMT=1400}];

    List<LinkedHashMap<String, Object>> sql4 = null;
    // [];

    List<LinkedHashMap<String, Object>> sql5 = null;
    // [{AC_AMT=0}];

    public Document makeDocument() {

        List<LinkedHashMap<String, Object>> sql1 = new ArrayList<LinkedHashMap<String, Object>>();

        String[] a = new String[] { "MOB_SLIP_NO", "USER_NM", "DEPT_NM", "SLIP_AMT", "ESSNC_CNTN", "ACNT_DT", "REG_DTM",
                "SLIP_ST_CD" };
        Object[] b = new Object[] { "MOBSL2021120388", "정용진", "관리정보팀", 1400, "정용진_신청(모바일_경비신청)", 20211023,
                "2021-12-15 11:23:33.0", 1 };
        Object[] c = new Object[] { "MOBSL2021120388", "정용진", "관리정보팀", 3333, "정용진_신청(모바일_경비신청)", 20211023,
                "2021-12-15 11:23:33.0", 1 };
        Object[] d = new Object[] { "MOBSL2021120388", "정용진", "관리정보팀", 4444, "정용진_신청(모바일_경비신청)", 20211023,
                "2021-12-15 11:23:33.0", 1 };





        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], b[i]);
            // System.out.println(map.get(a[i]));
        }

        sql1.add(map);

        for (String key : map.keySet()) {
            // System.out.println(map.size());
            System.out.println(key.toLowerCase().replaceAll("_", "") + '=' + map.get(key));

        }

        Document doc = null;

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            doc = builder.newDocument();
            doc.setXmlStandalone(true);

            Element root = doc.createElement("root");

            doc.appendChild(root);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return doc;
    }

    public Element makeElement() {

        return null;

    }

}
