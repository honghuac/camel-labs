package com.redhat.gpe.training.camel;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XpathCBRRoute extends RouteBuilder {

	private static final Logger logger = LoggerFactory.getLogger( XpathCBRRoute.class );

    @EndpointInject(ref="sourceDirectoryXml")
    Endpoint sourceUri;

    @EndpointInject(ref="euroSinkXml")
    Endpoint euroSinkUri;

    @EndpointInject(ref="usdSinkXml")
    Endpoint usdSinkUri;

    @EndpointInject(ref="otherSinkXml")
    Endpoint otherSinkUri;

	public void configure() throws Exception {	

		from( sourceUri )
            .convertBodyTo(String.class)
                .choice()
                .when(xpath("/pay:Payments/pay:Currency = 'EUR'")
                      .namespace("pay", "http://training.gpe.redhat.com/payment"))
                    .log("This is an Euro Payment: ${file:onlyname}")
                    .to(euroSinkUri)
                .when(xpath("/pay:Payments/pay:Currency = 'USD'")
                      .namespace("pay", "http://training.gpe.redhat.com/payment"))
                    .log("This is an USD Payment: ${file:onlyname}")
                    .to(usdSinkUri)
                .otherwise()
                    .log("This is an Other Currency Payment: ${file:onlyname}")
                    .to(otherSinkUri);
	}

}
