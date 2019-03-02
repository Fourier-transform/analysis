package com.legend.analysis.controller;


import com.legend.analysis.mapper.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/")
public class LogController {

    @Autowired
    private LogService logService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public void addLog(Log Log) {
        Log.setField1("11");
        Log.setId("11");
         logService.insert(Log);
    }

}
