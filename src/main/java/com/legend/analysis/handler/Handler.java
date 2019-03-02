package com.legend.analysis.handler;

import com.legend.analysis.mapper.LogMapper;
import com.legend.analysis.reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Handler {
    @Autowired
    private LogMapper userMapper;
    public static void  main(String a[]){

      /*  Reader r=new Reader();
        List list = r.readRawFile("D://123.txt","utf-8");
        list.forEach(s->{
            System.out.println(s);
                }
        );*/
    }
}
