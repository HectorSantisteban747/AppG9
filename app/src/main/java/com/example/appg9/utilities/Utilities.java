package com.example.appg9.utilities;

public class Utilities {
    public static final String TABLA_EVENTS = "events";
    public static final String CAMPO_IMG = "img";
    public static final String CAMPO_EVENT = "event";
    public static final String CAMPO_TYPE = "tipo";
    public static final String CAMPO_DATE = "date";
    public static final String CAMPO_TIME = "time";
    public static final String CAMPO_CONTACT = "contact";
    public static final String CAMPO_VALUE = "value";

    public static final String CREAR_TABLA_EVENTOS = "CREATE TABLE " + TABLA_EVENTS + "("+ CAMPO_IMG + " INTEGER, " + CAMPO_EVENT + " TEXT, " + CAMPO_TYPE + " TEXT, "+ CAMPO_DATE + " TEXT, "
    + CAMPO_TIME + " TEXT, " + CAMPO_CONTACT + " TEXT, " + CAMPO_VALUE + " INTEGER)";

}
