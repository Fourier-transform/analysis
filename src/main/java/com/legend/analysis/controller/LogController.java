package com.legend.analysis.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.legend.analysis.mapper.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/v1")
public class LogController {

    @Autowired
    private LogService logService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public void addLog(Log Log) {

        File file = new File("D:/user.txt");
        List<Log> insrtList = new ArrayList();
        try {
            String content = FileUtils.readFileToString(file, "UTF-8");
            JSONObject jsonObject = JSONObject.parseObject(content);
            JSONArray body = jsonObject.getJSONArray("body");
            Iterator<Object> iterator = body.iterator();
            while (iterator.hasNext()) {
                JSONObject next = (JSONObject) iterator.next();
                String userName = next.getString("userName");
                List accountSet = (List) next.get("accountSet");
                String id = "";
                if (null != accountSet && !accountSet.isEmpty()) {
                    JSONObject set = (JSONObject) accountSet.get(0);
                    id = set.getString("accountId");
                }
                Long cocoId = next.getLong("cocoId");
                if (StringUtils.isNotBlank(id)) {
                    Log l = new Log();
                    l.setId(id);
                    l.setField1(userName);
                    l.setField2(String.valueOf(cocoId));
                    insrtList.add(l);
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        insrtList.forEach(l -> {
            logService.insert(l);

        });
    }

}
