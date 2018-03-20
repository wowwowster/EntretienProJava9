package IPAccess;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.util.SubnetUtils;

public class Control_IP_OnLogon {


   /** Début Capture de l'adresse ip */

   public boolean control(HttpServletRequest request) {
      String ipAddress = request.getHeader("X-FORWARDED-FOR");
      if (ipAddress == null) {
         ipAddress = request.getRemoteAddr();
         System.out.println("Le client n'est pas connecté à un serveur proxy - Adresse IP :" + ipAddress);
      } else {
         System.out.println("Le client est connecté à un serveur proxy  - Adresse IP :" + ipAddress);
      }

      /** Fin Capture de l'adresse ip */

      boolean isGoodIP = false;
      List<String> ips = new ArrayList<String>();
      ips.add("10.0.3.1/32"); // IP unique, voir site
                              // http://cric.grenoble.cnrs.fr/Administrateurs/Outils/CalculMasque/
      ips.add("10.0.4.255/20");
      ips.add("10.0.5.1/24");

      for (String subnet : ips) {

         SubnetUtils utils = new SubnetUtils(subnet);
         utils.setInclusiveHostCount(true);
         isGoodIP = utils.getInfo().isInRange(ipAddress);

      }

      return isGoodIP;
   }
}
