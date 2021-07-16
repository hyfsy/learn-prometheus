package com.hyf.prometheus.alarm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2021/07/10
 */
@RestController
@RequestMapping("alarm")
public class AlarmManagerController {

    @RequestMapping
    public String home() {
        return "home";
    }

    @PostMapping("str")
    public void str(@RequestBody AlarmBo alarmBo) {
        System.out.println(alarmBo);
    }
}
