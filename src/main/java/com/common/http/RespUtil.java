package com.common.http;

import com.common.util.MapUtil;

import java.util.Map;

public class RespUtil {
    public static boolean isSuccess(Map<String, Object> resp) {
        int code = MapUtil.getInt(resp, "code");
        return code >= 0 && code < 300;
    }

    public static boolean isUnauthorized(Map<String, Object> resp) {
        return MapUtil.getInt(resp, "code") == RespEnum.UNAUTHORIZED.getCode();
    }

    public static Map<String, Object> resp(RespEnum resp) {
        return resp.toMap();
    }

    public static Map<String, Object> resp(RespEnum resp, String msg) {
        Map<String, Object> ret = resp.toMap();
        ret.put("msg", msg);
        return ret;
    }

    public static Map<String, Object> respOK() {
        return resp(RespEnum.OK);
    }

    public static Map<String, Object> respOK(String msg) {
        return resp(RespEnum.OK, msg);
    }

    public static Map<String, Object> respError() {
        return resp(RespEnum.ERROR);
    }

    public static Map<String, Object> respError(String msg) {
        return resp(RespEnum.ERROR, msg);
    }

    public static Map<String, Object> badRequest() {
        return resp(RespEnum.BAD_REQUEST);
    }

    public static Map<String, Object> notImplemented() {
        return resp(RespEnum.NOT_IMPLEMENTED);
    }
}