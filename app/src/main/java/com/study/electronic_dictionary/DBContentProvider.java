package com.study.electronic_dictionary;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DBContentProvider extends ContentProvider {
    public static final int DICT_NUM = 0;

    //包路径authority
    public static final String AUTHORITY = "com.study.electronic_dictionary";

    //用UriMatcher可以帮助过滤到TableA还是TableB,
    private static UriMatcher uriMatcher;
    private Database database;

    //静态代码块做初始化
    static {
        //初始化常量UriMatcher.NO_MATCH表示不匹配任何路径的返回码
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
//        第二步注册需要的Uri:
        uriMatcher.addURI(AUTHORITY,"dict",DICT_NUM);
    }


    public DBContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = database.getWritableDatabase();
        int delectRows = 0;
        switch (uriMatcher.match(uri)){
            case DICT_NUM:
                //match方法匹配后会返回一个匹配码Code，即在使用注册方法addURI时传入的第三个参数。
                delectRows = db.delete("dict", selection, selectionArgs);
                break;
        }
        return delectRows;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        switch (uriMatcher.match(uri)){
            case DICT_NUM:
                return "vnd.android.cursor.dir/vnd.com.study.electronic_dictionary.dict";       //d知道uri,就可以访问数据库dict的表
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        SQLiteDatabase db = database.getWritableDatabase();
        Uri uriReturn = null;
        switch (uriMatcher.match(uri)){
            case DICT_NUM:
                db.insert("dict",null,values);
                break;
        }
        return uriReturn;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        database = new Database(getContext(),"dict",null,2);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        //查询数据
        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cursor = null;
        //判断是查询哪个表
        switch (uriMatcher.match(uri)){
            case DICT_NUM:
                cursor = db.query("dict",projection,selection,selectionArgs,null,null,sortOrder);

                break;
        }

        return cursor;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        SQLiteDatabase db = database.getWritableDatabase();
        int updateraws = 0;
        switch (uriMatcher.match(uri)){
            case DICT_NUM:
                updateraws = db.update("dict", values, selection, selectionArgs);
                break;
        }
        return updateraws;
    }
}
