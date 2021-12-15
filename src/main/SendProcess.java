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


    // [
    // {SLIP_SNO=1,
    // ESSNC_CNTN=일 석,
    // AC_AMT=1400,
    // AC_CD=복리후생비_실비식대_석식,
    // VAT_AMT=127,
    // SVOS=1273,
    // SUP_NM=GS25 제주노형점,
    // MNG_DT=20211023}];

    // [{AC_AMT=1400}];

    // [];

    // [{AC_AMT=0}];

    public Document makeDocument() {

        //given

        List<LinkedHashMap<String, Object>> sql1 = new ArrayList<LinkedHashMap<String, Object>>();
        List<LinkedHashMap<String, Object>> sql2 = new ArrayList<LinkedHashMap<String, Object>>();
        List<LinkedHashMap<String, Object>> sql3 = new ArrayList<LinkedHashMap<String, Object>>();
        List<LinkedHashMap<String, Object>> sql4 = new ArrayList<LinkedHashMap<String, Object>>();
        List<LinkedHashMap<String, Object>> sql5 = new ArrayList<LinkedHashMap<String, Object>>();

        
        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

        String[] key1 = new String[] { "MOB_SLIP_NO", "USER_NM", "DEPT_NM", "SLIP_AMT", "ESSNC_CNTN", "ACNT_DT", "REG_DTM",
                "SLIP_ST_CD" };

        Object[] data1 = new Object[] { "MOBSL2021120388", "정용진", "관리정보팀", 1400, "정용진_신청(모바일_경비신청)", 20211023,
                "2021-12-15 11:23:33.0", 1 };
        Object[] data2 = new Object[] { "MOBSL2021120388", "정용진", "관리정보팀", 3333, "정용진_신청(모바일_경비신청)", 20211023,
                "2021-12-15 11:23:33.0", 1 };
        Object[] data3 = new Object[] { "MOBSL2021120388", "정용진", "관리정보팀", 4444, "정용진_신청(모바일_경비신청)", 20211023,
                "2021-12-15 11:23:33.0", 1 };


        List<Object[]> list1 = new ArrayList<Object[]>();

        list1.add(data1);
        list1.add(data2);
        list1.add(data3);

        for (Object[] obj : list1) {
            map = new LinkedHashMap<String, Object>();
            for (int i = 0; i < key1.length; i++) {
                map.put(key1[i], obj[i]);
            }
            sql1.add(map);
        }

        String[] key2 = new String[] { "SLIP_SNO", "ESSNC_CNTN", "AC_AMT", "AC_CD", "VAT_AMT", "SVOS", "SUP_NM", "MNG_DT" };

        Object[] data4 = new Object[] { 1, "일 석", 1400, "복리후생비_실비식대_석식", 127, 1273, "GS25 제주노형점", 20211023 };

        map = new LinkedHashMap<String, Object>();
        for (int i = 0; i < key2.length; i++) {
            map.put(key2[i], data4[i]);
        }
        sql2.add(map);

        String[] key3 = new String[] { "AC_AMT" };

        Object[] data5 = new Object[] { 1400 };

        map = new LinkedHashMap<String, Object>();
        for (int i = 0; i < key3.length; i++) {
            map.put(key3[i], data5[i]);
        }
        sql3.add(map);


        String[] key4 = new String[] { "AC_AMT" };

        Object[] data6 = new Object[] { 0 };
        
        map = new LinkedHashMap<String, Object>();
        for (int i = 0; i < key4.length; i++) {
            map.put(key4[i], data6[i]);
        }
        sql5.add(map);


        for(LinkedHashMap<String, Object> maps : sql1){

            for (String key : maps.keySet()) {
                // System.out.println(map.size());
                System.out.println(key.toLowerCase().replaceAll("_", "") + '=' + maps.get(key));
    
            }

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
