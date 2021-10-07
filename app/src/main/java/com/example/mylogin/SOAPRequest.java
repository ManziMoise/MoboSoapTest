package com.example.mylogin;

public class SOAPRequest {

//    String URL= "http://52.36.87.202/";
//    String SOAPACTION= "";
//    String NAMESPACE="http://52.36.87.202/";
//    String METHOD="checkCredentials";
//    String RESULT="";

    public static final String NAMESPACE = "http://tests.mcash.rw/rwandatest/services/";
    public static final String METHOD = "access";
    public static final String SOAPACTION = "http://tests.mcash.rw/rwandatest/services/access";
    public static final String URL = "http://tests.mcash.rw/rwandatest/services/access?wsdl";


    public SOAPRequest(String namespace, String method) {
    }
}
