package com.hackerrank.weather.exceptions.types;

public interface ErrorTypes {

    /*
     * http-4xx
     */
    String BAD_REQUEST = "bad-request";
    String UNAUTHORIZED = "unauthorized";
    String FORBIDDEN = "forbidden";
    String NOT_FOUND = "not-found";
    String GONE = "gone";
    String TOO_MANY_REQUESTS = "too-many-requests";
    String USER_BLOCKED = "user-blocked";

    /*
     * http-5xx
     */
    String REQUEST_FAILED = "request-failed";
    String BAD_GATEWAY = "bad-gateway";
    String GATEWAY_TIMEOUT = "gateway-timeout";
    String INTERNAL_SERVER_ERROR = "internal-server-error";


    String EMPTY_PARAM = "empty-param";


}