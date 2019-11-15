package com.enunui.grandma.Interface.core;

import retrofit2.Response;

public class HttpErrorResponse {


    public static class HTTP_STATUS {
        private HTTP_STATUS() {
        }

        public final static int STATUS_200 = 200;
        public final static int STATUS_420 = 420;
        public final static int STATUS_404 = 404;
        public final static int STATUS_400 = 400;
        public final static int STATUS_403 = 403;
        public final static int STATUS_409 = 409;

    }
    private int httpStatusCode;
    private Response response;

    public HttpErrorResponse(int httpStatusCode, Response response) {
        this.httpStatusCode = httpStatusCode;
        this.response = response;
    }
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public Response getResponse() {
        return response;
    }
}
