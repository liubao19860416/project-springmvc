package com.saick.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.meidusa.fastjson.JSON;
import com.meidusa.fastjson.JSONObject;
import com.saick.base.controller.requestobject.SaikeMobileHead;

/**
 * 几个可以使用静态导包方式引入的参数方法
 */
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.junit.Assert.*;

/**
 * BindingResultController测试类
 * 
 * 测试了数组提交，参数校验，restful风格请求参数
 * 
 * @author Liubao
 * @2014年12月14日
 * 
 */
public class BindingResultControllerTest extends BaseControllerTest {

    private static String url;
    
    @Test
    public void testIntBatch() throws Exception {
        url="/binding/intBatch?ids=";
        Integer[] strs1=new Integer[]{1,2,22};
        /**
         * 需要转换为下面的格式提交
         */
        String strs2=new String("1,2,22");
        mockMvc.perform(MockMvcRequestBuilders.post(url+strs2)
                .header("content-type", CONTENT_TYPE_JSON)
                .content(JSON.toJSONString(strs2))
                )
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.content().contentType(CONTENT_TYPE_JSON) )
                .andExpect( MockMvcResultMatchers.content().encoding(CONTENT_ENCODE) );
    }
    
    @Test
    public void testStringBatch() throws Exception {
        url="/binding/stringBatch?strs=";
        String[] strs1=new String[]{"1","2","A","刘保"};
        /**
         * 需要转换为下面的格式提交
         */
        String strs2=new String("1,2,A,刘保");
        mockMvc.perform(MockMvcRequestBuilders.post(url+strs2)
                .header("content-type", CONTENT_TYPE_JSON)
                .content(JSON.toJSONString(strs2))
                )
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.content().contentType(CONTENT_TYPE_JSON) )
                .andExpect( MockMvcResultMatchers.content().encoding(CONTENT_ENCODE) );
    }
    
    @Test
    public void testRequestParam() throws Exception {
        url="/binding/testRequestParam?groupId=297539";
        String groupId="297539";
        Map<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .header("content-type", CONTENT_TYPE_JSON)
                //.content(JSON.toJSONString(params))
                )
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.content().contentType(CONTENT_TYPE_JSON) )
                .andExpect( MockMvcResultMatchers.content().encoding(CONTENT_ENCODE) );
    }
    
    @Test
    public void testPathvariable() throws Exception {
        url="/binding/testPathvariable/";
        long userid=297539;
        Map<String, Object> params = new HashMap<>();
        params.put("userid", userid);
        mockMvc.perform(MockMvcRequestBuilders.post(url+userid)
                .header("content-type", CONTENT_TYPE_JSON)
                .content(JSON.toJSONString(params)))
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.content().contentType(CONTENT_TYPE_JSON) )
                .andExpect( MockMvcResultMatchers.content().encoding(CONTENT_ENCODE) );
    }
    
    @Test
    public void testCommitOrder() throws Exception {
        url = "/binding/testValidated.action";
        //头信息
        SaikeMobileHead head=new SaikeMobileHead();
        head.setAppCode("GrapeToC");
        head.setAppVersion("1.0");
        head.setDeviceId("358967043761541");
        head.setPlateformType("android");
        head.setSourceCode("1");
        head.setUserAccount("560047");
        head.setUserToken("token");
        String jsonString = JSON.toJSONString(head);
        
        Map<String, Object> params = new HashMap<>();
        params.put("userId", 297539);
        //params.put("userId", "");
        params.put("maintVelmodelId", 1);
        params.put("dealerCode", "475");
//        params.put("dealerCode", "");
        params.put("orderUName", "张三11111111");
        params.put("vkt", "60000");
        params.put("vlp", "京A45789");//中文算1个字符
        params.put("startDate", "2014-12-25");
        params.put("timeArea", "09:00-09:30");
        params.put("orderUTel", "18245786932");
        params.put("maintAmt", "789.000");
        params.put("laborhourDs", "0.90");
        //可为空
        params.put("userRemark", "ok");
        params.put("dealerProductCode", "5");
        
        //备用
//        params.put("source", "app");
//        params.put("payType", "1");
//        params.put("pickVelAmt", "200.00");
//        params.put("invTitle", "上汽集团");
//        params.put("invType", "1");
//        params.put("retVelAddr", "上海市徐汇区");
//        params.put("isUnSelect", "1");
//        params.put("orderAmt", "800.00");
//        params.put("dyType", "1");
//        params.put("pickVelAddr", "上海市徐汇区");
//        params.put("retVelAmt", "100.00");
//        params.put("maintDate", "2014-06-12 00:00:00");
//        params.put("orderProjListClassName",  "Project");
//        params.put("orderPartsListClassName",  "Parts");
//        params.put("dsId", 8);
//        params.put("partsDs", "0.9");
//        params.put("mdseTypeId", 1);
//        params.put("maintMdseId", 1);
        
        List<Map> partsList = new ArrayList<Map>();
        Map<String, Object> paramProjList = new HashMap<>();
        //paramProjList.put("partsNo", "2");
        paramProjList.put("partsCode", "502");
        paramProjList.put("partsName", "嘉实多4L");
        paramProjList.put("partsGuideprice", "320.00");
        paramProjList.put("partsDosage", "2");
        partsList.add(paramProjList);
        
        List<Map> partsList2 = new ArrayList<Map>();
        Map<String, Object> paramProjList2 = new HashMap<>();
        //paramProjList2.put("partsNo", "3");
        paramProjList2.put("partsCode", "504");
        paramProjList2.put("partsName", "空气滤芯");
        paramProjList2.put("partsGuideprice", "620.00");
        paramProjList2.put("partsDosage", "2");
        partsList2.add(paramProjList2);
        
        List<Map> objects = new ArrayList<Map>();
        Map<String, Object> paramProjs = new HashMap<>();
        //paramProjs.put("subProjId", 1);
        paramProjs.put("projId", 1);
        //paramProjs.put("isOptionalParts", "1");
        paramProjs.put("projName", "换机油");
        paramProjs.put("projAmt", "400.00");
        paramProjs.put("laborhour", "3");
        paramProjs.put("totalMoney", "3000.00");
        //paramProjs.put("guidePrice", "3000.00");
        paramProjs.put("laborhourGuideprice", "65.50");
        paramProjs.put("cpUrl", "http://www.baidu.com");
        //paramProjs.put("recoTypeId", 1);
        paramProjs.put("orderPartsList", partsList);
        objects.add(paramProjs);
        Map<String, Object> paramProjs2 = new HashMap<>();
        //paramProjs2.put("subProjId", 2);
        paramProjs2.put("projId", 2);
        //paramProjs2.put("isOptionalParts", "2");
        paramProjs2.put("projName", "空调系统清洗");
        paramProjs2.put("projAmt", "600.00");
        paramProjs2.put("laborhour", "2");
        paramProjs2.put("totalMoney", "5500.00");
        //paramProjs2.put("guidePrice", "5000.00");
        paramProjs2.put("laborhourGuideprice", "75.50");
        paramProjs2.put("cpUrl", "http://www.baidu.com");
        //paramProjs2.put("recoTypeId", 1);
        paramProjs2.put("orderPartsList", partsList2);
        objects.add(paramProjs2);
        params.put("orderProjList", objects);
        
        List<Map> csrvProdList = new ArrayList<Map>();
        Map<String, Object> paramCsrvProd = new HashMap<>();
        paramCsrvProd.put("projName", "清洗节气门");
        paramCsrvProd.put("partsName", "清洗剂");
        paramCsrvProd.put("projGuideprice", "3000.00");
        paramCsrvProd.put("projPrmtprice", "2000.00");
        paramCsrvProd.put("projDesc", "描述");
        paramCsrvProd.put("imageUrl", "http://image.url");
        paramCsrvProd.put("dealerId", 151853);
        paramCsrvProd.put("csrvProdId", 59);//清洗节气门
        csrvProdList.add(paramCsrvProd);
        //params.put("csrvProdList", csrvProdList);
        
        //params.put("age", "0.9");
        
        //JSON字符串格式化方式
        JSONObject.toJSONString(params);
        JSON.toJSONString(params);
        
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .header("content-type", CONTENT_TYPE_JSON)
                .header("saikemobilehead", jsonString)
                .content(JSON.toJSONString(params)))
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.content().contentType(CONTENT_TYPE_JSON) )
                .andExpect( MockMvcResultMatchers.content().encoding(CONTENT_ENCODE) );

    }
    
    @Test
    public void testValidated() throws Exception {
        url = "/binding/testValidated.action";
        //头信息
        SaikeMobileHead head=new SaikeMobileHead();
        head.setAppCode("GrapeToC");
        head.setAppVersion("1.0");
        head.setDeviceId("358967043761541");
        head.setPlateformType("android");
        head.setSourceCode("1");
        head.setUserAccount("560047");
        head.setUserToken("");
        String jsonString = JSON.toJSONString(head);
        
        Map<String, Object> params = new HashMap<>();
        /*params.put("userId", 100);
//        params.put("userId", -1);
        params.put("dealerCode", "26999");
//         params.put("dealerCode", "");
        // params.put("dealerCode", null);
        //params.put("startDate", "2014:12:12");
        params.put("startDate", "2014-12-12");
        params.put("timeArea", "09:00-10:00");//([0,1,2][0-9][:])[-]([0,1,2][0-9][:])
        //params.put("timeArea", "09:00:10:00");
        params.put("orderUTel", "18611478781");
        //params.put("orderUTel", "11611478781");
        params.put("maintAmt", "300.80");
        //params.put("maintAmt", "300");
        params.put("laborhourDs", "1.9");
        params.put("laborhourDs", "0.9");*/
        
        params.put("userId", 297539);
        params.put("maintVelmodelId",5);
        params.put("dealerCode", "475");
        params.put("orderUName", "张三");
        params.put("vkt", "100");
        params.put("vlp", "京A45889");
        params.put("startDate", "2014-12-25");
        params.put("timeArea", "09:00-09:301");
        params.put("orderUTel", "152457869321");
        params.put("maintAmt", "789.00");
        params.put("laborhourDs", "0.9");
        
        //可为空
//        params.put("userRemark", "ok");
//        params.put("dealerProductCode", "5");
        
        //备用
//        params.put("source", "app");
//        params.put("payType", "1");
//        params.put("pickVelAmt", "200.00");
//        params.put("invTitle", "上汽集团");
//        params.put("invType", "1");
//        params.put("retVelAddr", "上海市徐汇区");
//        params.put("isUnSelect", "1");
//        params.put("orderAmt", "800.00");
//        params.put("dyType", "1");
//        params.put("pickVelAddr", "上海市徐汇区");
//        params.put("retVelAmt", "100.00");
//        params.put("maintDate", "2014-06-12 00:00:00");
        
        
        List<Map> partsList = new ArrayList<Map>();
        Map<String, Object> paramProjList = new HashMap<>();
        //paramProjList.put("partsNo", "2");
        paramProjList.put("partsCode", "502");
        paramProjList.put("partsName", "嘉实多4L");
        partsList.add(paramProjList);
        
        List<Map> partsList2 = new ArrayList<Map>();
        Map<String, Object> paramProjList2 = new HashMap<>();
        //paramProjList2.put("partsNo", "3");
        paramProjList2.put("partsCode", "504");
        paramProjList2.put("partsName", "空气滤芯");
        partsList2.add(paramProjList2);
        
        List<Map> objects = new ArrayList<Map>();
        Map<String, Object> paramProjs = new HashMap<>();
        paramProjs.put("projId", 1);
        paramProjs.put("projName", "换机油");
        paramProjs.put("projAmt", "400.00");
        paramProjs.put("totalMoney", "3000.00");
        paramProjs.put("orderPartsList", partsList);
        objects.add(paramProjs);
        params.put("orderProjList", objects);
        
        /**
         * 不能包含请求参数没有的参数
         */
        //params.put("age", "0.9");
        
        //JSON字符串格式化方式
        JSONObject.toJSONString(params);
        JSON.toJSONString(params);

        //自定义的结果校验匹配器
        //Matcher matcher = new CouponViewObjectMatcher();
        
        mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .header("content-type",CONTENT_TYPE_JSON)
                        .header("saikemobilehead", jsonString).content(JSON.toJSONString(params)))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE_JSON))
                        .andExpect(MockMvcResultMatchers.content().encoding(CONTENT_ENCODE))
                        //.andExpect(MockMvcResultMatchers.content().string(matcher))
                        //.andExpect(MockMvcResultMatchers.content().string(JSON.toJSONString(viewObjects)))
                        ;
        
    }
    
}
/**
 * 自定义的内部类，结果校验匹配器
 */
/*class CouponViewObjectMatcher extends MyBaseMatcher<CouponViewObjectMatcher, CouponViewObject> {

        @Override
        protected void checkResponseViewObjects(List<CouponViewObject> couponViewObjects) {

            assertFalse(couponViewObjects.isEmpty());
            assertTrue(couponViewObjects.size() == 11);

            CouponViewObject couponViewObject = couponViewObjects.get(0);
            assertEquals("323", couponViewObject.getCode());

            CouponViewObject couponViewObject2 = couponViewObjects.get(1);

            assertTrue(Float.valueOf(couponViewObject2.getMoneyAmount()) >= Float
                    .valueOf(couponViewObject.getMoneyAmount()));

            assertTrue(Integer.valueOf(couponViewObject2.getFitToMaxDaysUsed()) >= Integer
                    .valueOf(couponViewObject2.getFitToMinDaysUsed()));
        }
    }
*/
