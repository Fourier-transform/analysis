package com.legend.analysis.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Iterator;
import java.util.List;

@Service
public class Handler {

    public static void main(String a[]) {

      /*  Reader r=new Reader();
        List list = r.readRawFile("D://123.txt","utf-8");
        list.forEach(s->{
            System.out.println(s);
                }
        );*/
    }

    @Scheduled(fixedDelay = 2000)
    public void doSomeThing() {

    }
}
