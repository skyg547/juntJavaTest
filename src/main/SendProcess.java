package main;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.naming.ldap.HasControls;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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


        List<Object[]> list1 = new ArrayList<Object[]>();

        list1.add(data1);

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
        System.out.println(1);


        /*
        for(LinkedHashMap<String, Object> maps : sql1){

            for (String key : maps.keySet()) {
                // System.out.println(map.size());
                System.out.println(key.toLowerCase().replaceAll("_", "") + '=' + maps.get(key));
    
            }

        }*/
    
        //when

        Document doc = null;

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            doc = builder.newDocument();

            doc.setXmlStandalone(true);

            Element root = doc.createElement("root");
            
            Stack<String> dataStack2 = new Stack<>();
            dataStack2.push("record");
            dataStack2.push("dataset02");

            
            makeElement(doc, root, dataStack1, sql1);
            // makeElement(doc, root, new String[] {"dataset02", "record"},  sql2);           
            // makeElement(doc, root, new String[] {"dataset03"}, sql3);
            // makeElement(doc, root, new String[] {"dataset04", "record"}, sql4);
            // makeElement(doc, root, new String[] {"dataset05"}, sql5);

            doc.appendChild(root);

            TransformerFactory factory2 = TransformerFactory.newInstance();
            Transformer transformer = factory2.newTransformer();

            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // 정렬 스페이스 4칸
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes"); // doc.setXmlStandalone(true); 했을때 붙어서 출력되는 부분 개행
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new OutputStreamWriter(System.out, "UTF-8")); // 문서 로 만들기 

            StreamResult result2 = new StreamResult( new ByteArrayOutputStream()); // 바이트 배열로 만들기 

            
            transformer.transform(source, result2);
            System.out.println(new String(((ByteArrayOutputStream)result2.getOutputStream()).toByteArray(), "UTF-8"));
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        return doc;
    }

    public Element makeElement(Document doc, Element element, Stack<String> tagNames, List<LinkedHashMap<String, Object>> sqlList) {

        if(tagNames.size() == 1){
            
            for(LinkedHashMap<String, Object> map : sqlList){
                Element child = doc.createElement(tagNames.peek());
                
                for(String key : map.keySet()){
                    Element child2 = doc.createElement(key.toLowerCase().replaceAll("_", ""));
                    child2.appendChild(doc.createTextNode(map.get(key).toString()));
                    child.appendChild(child2);
                }
                element.appendChild(child);
                return element;
            }
            
        }

        Element childElement = doc.createElement(tagNames.pop());
        makeElement(doc, childElement, tagNames, sqlList);
        
        element.appendChild(childElement);
        for (LinkedHashMap<String,Object> linkedHashMap : sqlList) {
            for (String key : linkedHashMap.keySet()) {
                // System.out.println(map.size());
                System.out.println(key.toLowerCase().replaceAll("_", "") + '=' + linkedHashMap.get(key));
    
            }
            
        }
        
        return childElement;
    }

    public static void sendAppr(String xmlDataString, List<LinkedHashMap<String, Object>> sql){
        try {
            URL portalUrl = new URL("http://portaldev.daiso.co.kr:8080/ikep/rest/comb/autoappr/report");
            
            HttpURLConnection conn = (HttpURLConnection) portalUrl.openConnection();
     
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            StringBuffer sb = new StringBuffer();

            HashMap<String, String> pList = new HashMap<String, String>();

                 
            pList.put("FORM_ID", "100041222282");
            pList.put("APPR_TITLE","경비전용 삼성카드" +  sql.get(0).get("ESSNC_CNTN").toString());
            pList.put("USER_ID", sql.get(0).get("USER_NM").toString());
            pList.put("XML_PARAM", xmlDataString);
            pList.put("PORTAL_ID", "P1");
            pList.put("APPKEY_01", "1000");
            pList.put("APPKEY_02", sql.get(0).get("MOB_SLIP_NO").toString());

            Set<String> keys = pList.keySet();

            for(   String key : keys){

                sb.append(key +"="+pList.get(key)+"&");
            }

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            PrintWriter writer = new PrintWriter(wr);
            writer.write(sb.toString());
            writer.flush();

            System.out.println(conn.getResponseCode()); 
            System.out.println( conn.getResponseMessage());
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));            

            String line = null;

            while((line = in.readLine()) != null) {// 잃기
                System.out.println(line);
            }
            in.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    

    }
}



