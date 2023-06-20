package com.vois.DeviceConfiguration.constant;

import com.vois.DeviceConfiguration.util.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ResponseCodes {
    @Value(Value = "success")
    public static final int SUCCESS = 200;
    @Value(Value = "CREATED")
    public static final int CREATED = 201;

    @Value(Value = "permission assign to the user successfully")
    public static final int PERMISSION_ASSIGN = 202;
    @Value(Value = "device deleted successfully")
    public static final int DELETED = 203;
    @Value(Value = "PIN updated successfully")
    public static final int PIN_UPDATED = 204;
    @Value(Value = "let's config some device ")
    public static final int WE_HAVE_DEVICE_TO_CONFIG = 205;
    @Value(Value = "device id not exist")
    public static final int DEVICE_ID_NOT_EXIST = 301;
    @Value(Value = "pin must be consist of 7 digit only")
    public static final String PIN_PROPERTIES = "302";
    @Value(Value = "can't be null")
    public static final String PIN_NOT_NULL = "303";
    @Value(Value = "PIN must be digit only can't be chars")
    public static final String PIN_MUST_BE_DIGIT = "304";
    @Value(Value = "there is no device to config ")
    public static final int THERE_IS_NO_DEVICE_TO_CONFIG = 305;


    public static String getDesc(int constantValue) {
        String Desc = "";
        Field[] interfaceFields = ResponseCodes.class.getFields();
        for (Field f : interfaceFields) {
            try {
                if (Integer.valueOf(f.get(null).toString()) == constantValue) {
                    Annotation annotation = f.getAnnotation(Value.class);
                    if (annotation instanceof Value) {
                        Value objValue = (Value) annotation;
                        Desc = objValue.Value();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Desc;

    }

}
