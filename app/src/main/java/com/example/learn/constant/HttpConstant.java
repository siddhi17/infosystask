package com.example.learn.constant;



public class HttpConstant {

    /**
     * base url for api
     */
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";

    /**
     * headers
     */
    public static final String JSON_TYPE = "Content-Type:application/json";

    /**
     * Api calls.
     */
    //create event screen
    public static final String GET_DATA = "facts.json";

    /**
     * STATUS CODE.
     */
    public static final int SUCCESS = 200;
    public static final int BAD_REQUEST = 401;
    public static final int INTERNAL_SERVER_ERROR = 500;


}
