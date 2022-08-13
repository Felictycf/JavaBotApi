package com.wuzh.blog.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * ip工具类
 * Created by charlin on 2017/9/9.
 */
@Slf4j
public class IPUtil {

   public static String getIpAddr(HttpServletRequest request){
       String ip=null,unknown="unknow",seperator=",";
       int maxLength=15;
       try{
           ip=request.getHeader("x-forwarded-for");
           if (StringUtils.isEmpty(ip)||unknown.equalsIgnoreCase(ip)){
               ip=request.getHeader("Proxy-Client-IP");
           }
           if (StringUtils.isEmpty(ip)||ip.length()==0||unknown.equalsIgnoreCase(ip)){
               ip=request.getHeader("WL-Proxy-Client-IP");
           }
           if (StringUtils.isEmpty(ip)||unknown.equalsIgnoreCase(ip)){
               ip=request.getHeader("HTTP_CLIENT_IP");
           }
           if (StringUtils.isEmpty(ip)||unknown.equalsIgnoreCase(ip)){
               ip=request.getHeader("HTTP_X_FORWARDED_FOR");
           }
           if (StringUtils.isEmpty(ip)||unknown.equalsIgnoreCase(ip)){
               ip=request.getRemoteAddr();
           }
       }catch (Exception e){
           log.error("IpUtils EROR" ,e);
       }
       if (StringUtils.isEmpty(ip)&&ip.length()>maxLength){
           int idx=ip.indexOf(seperator);
           if (idx>0){
               ip=ip.substring(0,idx);
           }
       }
       return ip;
   }
}
