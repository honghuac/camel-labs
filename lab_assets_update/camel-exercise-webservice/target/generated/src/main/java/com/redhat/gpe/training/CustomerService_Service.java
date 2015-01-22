package com.redhat.gpe.training;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.0.redhat-60024
 * 2015-01-14T12:34:40.963+07:00
 * Generated source version: 2.6.0.redhat-60024
 * 
 */
@WebServiceClient(name = "CustomerService", 
                  wsdlLocation = "file:/Users/hchin/Desktop/TH-JDG-FUSE/FOR%20STUDENTS/fuse-labs/labs/lab_assets_update/camel-exercise-webservice/src/main/resources/wsdl/CustomerService.wsdl",
                  targetNamespace = "http://training.gpe.redhat.com/") 
public class CustomerService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://training.gpe.redhat.com/", "CustomerService");
    public final static QName CustomerServicePort = new QName("http://training.gpe.redhat.com/", "CustomerServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/hchin/Desktop/TH-JDG-FUSE/FOR%20STUDENTS/fuse-labs/labs/lab_assets_update/camel-exercise-webservice/src/main/resources/wsdl/CustomerService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/hchin/Desktop/TH-JDG-FUSE/FOR%20STUDENTS/fuse-labs/labs/lab_assets_update/camel-exercise-webservice/src/main/resources/wsdl/CustomerService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns CustomerService
     */
    @WebEndpoint(name = "CustomerServicePort")
    public CustomerService getCustomerServicePort() {
        return super.getPort(CustomerServicePort, CustomerService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerService
     */
    @WebEndpoint(name = "CustomerServicePort")
    public CustomerService getCustomerServicePort(WebServiceFeature... features) {
        return super.getPort(CustomerServicePort, CustomerService.class, features);
    }

}
