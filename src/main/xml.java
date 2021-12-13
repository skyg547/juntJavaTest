package main;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class xml {

    public static void main(String[] args) {
        URL portalUrl = null;

        try {
            portalUrl =  new URL("http://portaldev.daiso.co.kr:8080/ikep/rest/comb/autoappr/report");  
            
        } catch (Exception e) {
            //TODO: handle exception
        }

        System.out.println("Protocol : " + portalUrl.getProtocol());   
        System.out.println("host : " + portalUrl.getHost());   
        System.out.println("path : " + portalUrl.getPath());   
        System.out.println("file : " + portalUrl.getFile());   
        System.out.println("port : " + portalUrl.getPort());         
        
        // type Post
        // url: "http://portaldev.daiso.co.kr:8080/ikep/rest/comb/autoappr/report", 개발
        // url: "http://portal.daiso.co.kr/rest/comb/autoappr/report",
        // header {Content-Type: application/x-www-form-urlencoded; charset=UTF-8}
        // "X-HTTP-Method-Override: Post"
        // time out 
        /* data
            {	"FORM_ID": "100041222282",
				"APPR_TITLE": "경비전용 삼성카드 " + response.sql1[0].ESSNC_CNTN,
				"USER_ID": erpId,
				"XML_PARAM": root,
				"PORTAL_ID": "P1",
				"APPKEY_01": "1000",
				"APPKEY_02": response.sql1[0].MOB_SLIP_NO
            }               
        */
        
        /* 데이터 구조 
        "<root>"
         '<dataset01>
         <mobslipno>' + $.fn.limitSpecialCharacters(response.sql1[0].MOB_SLIP_NO) + '</mobslipno>' +
				'<regusernm>' + $.fn.limitSpecialCharacters(response.sql1[0].USER_NM) + '</regusernm>' +
				'<regdeptnm>' + $.fn.limitSpecialCharacters(response.sql1[0].DEPT_NM) + '</regdeptnm>' +
				'<slipamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(response.sql1[0].SLIP_AMT)) + '</slipamt>' +
				'<essnccntn>' + $.fn.limitSpecialCharacters(response.sql1[0].ESSNC_CNTN) + '</essnccntn>' +
				'<acntdt>' + $.fn.limitSpecialCharacters(response.sql1[0].ACNT_DT.substr(0, 4)) + '-' + response.sql1[0].ACNT_DT.substr(4, 2) + '-' + response.sql1[0].ACNT_DT.substr(6, 2) + '</acntdt>' +
				'<regdtm>' + $.fn.limitSpecialCharacters(response.sql1[0].REG_DTM.substr(0, 10)) + '</regdtm></dataset01>';
               
                <dataset02>
                '<record>' +
                '<slipsno>' + $.fn.limitSpecialCharacters(element.SLIP_SNO) + '</slipsno>' +
                '<essnccntn>' + $.fn.limitSpecialCharacters(element.ESSNC_CNTN) + '</essnccntn>' +
                '<accd>' + $.fn.limitSpecialCharacters(element.AC_CD) + '</accd>' +
                '<acamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.AC_AMT)) + '</acamt>' +
                '<svos>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.SVOS)) + '</svos>' +
                '<vatamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.VAT_AMT)) + '</vatamt>' +
                '</record>';
                '</dataset02>'

                '<dataset03><amt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(response.sql3[0].AC_AMT)) + '</amt></dataset03>';
              
                '</dataset04>'
                '<record>' +
					'<slipsno>' + $.fn.limitSpecialCharacters(element.SLIP_SNO) + '</slipsno>' +
					'<essnccntn>' + $.fn.limitSpecialCharacters(element.ESSNC_CNTN) + '</essnccntn>' +
					'<accd>' + $.fn.limitSpecialCharacters(element.AC_CD) + '</accd>' +
					'<acamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.AC_AMT)) + '</acamt>' +
					'<svos>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.SVOS)) + '</svos>' +
					'<vatamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.VAT_AMT)) + '</vatamt>' +
					'</record>';

                '</dataset04>'

                    '<dataset05><amt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(response.sql5[0].AC_AMT)) + '</amt></dataset05>';
                   
                    "</root>" 
                     */ 
                    
                
        String xmlDatasStringf = "";

        xmlDatasStringf += "<root>";

        xmlDatasStringf += "<dataset01>";
        xmlDatasStringf += "<mobslipno>100041222282</mobslipno>";
        xmlDatasStringf += "<regusernm>김성욱</regusernm>";
        xmlDatasStringf += "<regdeptnm>영업팀</regdeptnm>";
        xmlDatasStringf += "<slipamt>1,000,000</slipamt>";
        xmlDatasStringf += "<essnccntn>삼성카드</essnccntn>";
        xmlDatasStringf += "<acntdt>2017-01-01</acntdt>";
        xmlDatasStringf += "<regdtm>2017-01-01</regdtm></dataset01>";

        xmlDatasStringf += "<dataset02>";
        xmlDatasStringf += "<record>";
        xmlDatasStringf += "<slipsno>1</slipsno>";
        xmlDatasStringf += "<essnccntn>삼성카드</essnccntn>";
        xmlDatasStringf += "<accd>1</accd>";
        xmlDatasStringf += "<acamt>1,000,000</acamt>";
        xmlDatasStringf += "<svos>1,000,000</svos>";
        xmlDatasStringf += "<vatamt>0</vatamt>";
        xmlDatasStringf += "</record>";
        xmlDatasStringf += "</dataset02>";

        xmlDatasStringf += "<dataset03><amt>1,000,000</amt></dataset03>";

        xmlDatasStringf += "<dataset04>";
        xmlDatasStringf += "<record>";
        xmlDatasStringf += "<slipsno>1</slipsno>";
        xmlDatasStringf += "<essnccntn>삼성카드</essnccntn>";
        xmlDatasStringf += "<accd>1</accd>";
        xmlDatasStringf += "<acamt>1,000,000</acamt>";
        xmlDatasStringf += "<svos>1,000,000</svos>";   
        xmlDatasStringf += "<vatamt>0</vatamt>";
        xmlDatasStringf += "</record>";
        xmlDatasStringf += "</dataset04>";

        xmlDatasStringf += "<dataset05><amt>1,000,000</amt></dataset05>";

        xmlDatasStringf += "</root>";


        try {

            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode == 200) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}