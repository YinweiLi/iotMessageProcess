package com.example.yinwei.iotmessageprocess;

import android.app.DatePickerDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ShowDetialActivity extends AppCompatActivity {


    TextView tv4Test;
    Button button4Begin,button4End,button4Search;
    ListView listView2Show;
    int beginYear,beginMonth,beginDay,endYear,endMonth,endDay;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            String[] s = bundle.getStringArray("name");
            tv4Test.setText(s[0]+s[1]);
            for(int i = 0 ; i < s.length ; i++){
                                    System.out.println(s[i]);
                               }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detial);
        tv4Test = (TextView) findViewById(R.id.textView);
        button4Begin = (Button)findViewById(R.id.button2BEGIN);
        button4End = (Button)findViewById(R.id.button2END);
        button4Search = (Button)findViewById(R.id.button2SEARCH);
        listView2Show = (ListView)findViewById(R.id.ListView2Show);


        button4Begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ShowDetialActivity.this,new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMtnth){
                        beginYear = year;
                        beginMonth = monthOfYear+1;
                        beginDay = dayOfMtnth;
//
                        tv4Test.setText("Begin Time:"+beginYear+"-"+beginMonth+"-"+beginDay+"End Time:"+endYear+"-"+endMonth+"-"+endDay);

                    }

                },1901,0,1).show();
            }
        });

        button4End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ShowDetialActivity.this,new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMtnth){
                        endYear = year;
                        endMonth = monthOfYear+1;
                        endDay = dayOfMtnth;
//
                        tv4Test.setText("Begin Time:"+beginYear+"-"+beginMonth+"-"+beginDay+"End Time:"+endYear+"-"+endMonth+"-"+endDay);
                    }

                },1901,2,1).show();
            }
        });

        button4Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//            new Thread(new SearchThread()).start();
            new Thread(new Runnable() {
                @Override
                public void run() {

 //***************************************************************************Call Service
                    String uriA = "http://192.168.43.154/test.php";
                    HttpURLConnection connection = null;

                    try {
                         URL url = new URL(uriA);
                         connection = (HttpURLConnection) url.openConnection();//打开http连接
                         connection.setConnectTimeout(5000);//连接的超时时间
                         connection.setUseCaches(false);//不使用缓存
                         connection.setReadTimeout(5000);//响应的超时时间
                         connection.setDoOutput(true);//设置这个连接是否可以写入数据
                         connection.setDoInput(true);//设置这个连接是否可以输出数据
                         connection.setRequestMethod("POST");//设置请求的方式

                         String jsonStr = "name=lywFromAndroid&password=1234567890";
                         OutputStream out = connection.getOutputStream();//输出流，用来发送请求，http请求实际上直到这个函数里面才正式发送出去
                         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
                         //创建字符流对象并用高效缓冲流包装它，便获得最高的效率,发送的是字符串推荐用字符流，其它数据就用字节流
                         bw.write(jsonStr);//把json字符串写入缓冲区中

                          bw.flush();
                          out.close();
                          bw.close();
                          if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                               System.out.println(HttpURLConnection.HTTP_OK+"************连接成功************");
                               InputStream it = connection.getInputStream();
                               BufferedReader br = new BufferedReader(new InputStreamReader(it));
                              String backResult = br.readLine();
                               String[] backResultA = backResult.split("<br>");
//                               for(int i = 0 ; i < backResultA.length ; i++){
//                                    System.out.println(backResultA[i]);
//                               }

                              Message message = new Message();
                              Bundle bundle = new Bundle();
//                              String[] sa = new String[2];
//                              sa[0] = "lyw";
//                              sa[1] = "222";
                              bundle.putStringArray("name",backResultA);

                              message.setData(bundle);
                              handler.sendMessage(message);
                              System.out.println("*********BACK MESSAGE:******************");


                            }
                          else{
                             System.out.println("**********连接失败************:");
                          }

                     } catch (Exception e) {
                          // TODO: handle exception
                          System.out.println("***************此處異常**************/r"+e.toString());
                        }
//*****************************************************************************************Call Service

                }
            }).start();
            String str = tv4Test.getText() + "    Searching......";
                tv4Test.setText(str);
            }
        });


    }
}
