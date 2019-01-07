package com.javademo.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.javademo.cases.BaseTest;

import macaca.java.biz.CommonUIBean;

public class BaseUtils extends BaseTest{
 /*   public static CommonUIBean getBeanByIndex(CommonUIBean cub, int index){
        CommonUIBean cub_new = cub;
        Map<String, Object>  m_cub = transBean2Map(cub);
      	 addXpathIndex4Map(m_cub, index);
      	 itrMap(m_cub);
        transMap2Bean(m_cub, cub_new);
        Map<String, Object>  m_cub_new = transBean2Map(cub_new);
        System.out.println("\n\n");
        itrMap(m_cub_new);
        return cub_new;
       }
       
       public static void itrMap(Map<String, Object> map){
      	 Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
             Map.Entry<String, Object> entry = it.next();
             System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
       }
       
       public static void addXpathIndex4Map(Map<String, Object> imap, int index){

       	imap.put("androidValue", imap.get("androidValue")+"["+ index +"]");
       	imap.put("iosValue", imap.get("iosValue")+"["+ index +"]");
       }
       
       public static void transMap2Bean(Map<String, Object> map, Object obj) {
       	 
           try {
               BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
               PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

               for (PropertyDescriptor property : propertyDescriptors) {
                   String key = property.getName();

                   if (map.containsKey(key)) {
                       Object value = map.get(key);
                       Method setter = property.getWriteMethod();
                       setter.invoke(obj, value);
                   }

               }

           } catch (Exception e) {
               System.out.println("transMap2Bean Error " + e);
           }

           return;

       }
       
       public static Map<String, Object> transBean2Map(Object obj) {

           if(obj == null){
               return null;
           }        
           Map<String, Object> map = new HashMap<String, Object>();
           try {
               BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
               PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
               for (PropertyDescriptor property : propertyDescriptors) {
                   String key = property.getName();

                   if (!key.equals("class")) {
                       Method getter = property.getReadMethod();
                       Object value = getter.invoke(obj);

                       map.put(key, value);
                   }

               }
           } catch (Exception e) {
               System.out.println("transBean2Map Error " + e);
           }

           return map;

       }
       
       public static void clickBack() throws Exception{
    	   driver.back();
       }
       
       */

       
}
