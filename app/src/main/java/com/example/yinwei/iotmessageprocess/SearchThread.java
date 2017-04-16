package com.example.yinwei.iotmessageprocess;


import android.os.Handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yinwei on 2017/4/16.
 */

public class SearchThread implements Runnable {

    public SearchThread() {
        super();

        try {

        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    //    @Override
//    public void run() {
//        // TODO 自动生成的方法存根
//
//
//
//        String uriA = "http://192.168.1.113/test.php";
//        HttpURLConnection connection = null;
//
//        try {
//
//            URL url = new URL(uriA);
//            connection = (HttpURLConnection) url.openConnection();//打开http连接
//            connection.setConnectTimeout(5000);//连接的超时时间
////                connection.setUseCaches(false);//不使用缓存
//            connection.setReadTimeout(5000);//响应的超时时间
//            connection.setDoOutput(true);//设置这个连接是否可以写入数据
//            connection.setDoInput(true);//设置这个连接是否可以输出数据
//            connection.setRequestMethod("POST");//设置请求的方式
//
//            String jsonStr = "name=lywFromAndroid&password=1234567890";
//            OutputStream out = connection.getOutputStream();//输出流，用来发送请求，http请求实际上直到这个函数里面才正式发送出去
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
//            //创建字符流对象并用高效缓冲流包装它，便获得最高的效率,发送的是字符串推荐用字符流，其它数据就用字节流
//            bw.write(jsonStr);//把json字符串写入缓冲区中
//
//            bw.flush();
//            out.close();
//            bw.close();
//            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
//                System.out.println(HttpURLConnection.HTTP_OK+"************连接成功************");
//                InputStream it = connection.getInputStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(it));
//                String backResult = br.readLine();
//                String[] backResultA = backResult.split("<br>");
//                for(int i = 0 ; i < backResultA.length ; i++){
//                    System.out.println(backResultA[i]);
//                }
//
//                System.out.println("*********BACK MESSAGE:******************");
//                Handler handler = new Handler();
//
//            }
//            else{
//                System.out.println("**********连接失败************:");
//            }
//
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            System.out.println("***************此處異常**************/r"+e.toString());
//
//        }
//
//
//    }

}
