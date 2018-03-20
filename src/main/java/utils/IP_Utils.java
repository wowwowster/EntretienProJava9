package utils;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.util.SubnetUtils;


public class IP_Utils {


   /**
    * v�rification des ips autoris�es
    */
   public static boolean testIP(String codeSigle, String ip) {
      boolean isgood = false;


      /**
       * List<String> ips = ReseauManagerBean.getIpsAndSubnetMask(codeSigle); � remplir
       * 
       * 
       * */

      List<String> ips = new ArrayList<String>();
      for (String subnet : ips) {

         SubnetUtils utils = new SubnetUtils(subnet);
         utils.setInclusiveHostCount(true);
         isgood = utils.getInfo().isInRange(ip);
         if (isgood) {
            break;
         }
      }

      return true;
   }

   public static String getClientIpAddr(HttpServletRequest request) {
      System.out.println("Controle X-Forwarded-For");


      Enumeration<String> headerNames = request.getHeaderNames();
      while (headerNames.hasMoreElements()) {
         String headerName = headerNames.nextElement();
         System.out.println("headerName=" + headerName);

         Enumeration<String> headers = request.getHeaders(headerName);
         while (headers.hasMoreElements()) {
            String headerValue = headers.nextElement();
            System.out.println("headerValue=" + headerValue);
         }

      }

      String ip = request.getHeader("X-Forwarded-For");
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         System.out.println("Controle Proxy-Client-IP");
         ip = request.getHeader("Proxy-Client-IP");

      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         System.out.println("Controle WL-Proxy-Client-IP");
         ip = request.getHeader("WL-Proxy-Client-IP");
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         System.out.println("Controle HTTP_CLIENT_IP");
         ip = request.getHeader("HTTP_CLIENT_IP");
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         System.out.println("Controle HTTP_X_FORWARDED_FOR");
         ip = request.getHeader("HTTP_X_FORWARDED_FOR");
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         System.out.println("Controle RemoteAddr");
         ip = request.getRemoteAddr();
      }
      return ip;
   }
}
