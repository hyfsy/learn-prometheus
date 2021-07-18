package com.hyf.prometheus.alarm;

import com.hyf.prometheus.alarm.bo.AlertManagerAlarmBo;
import com.hyf.prometheus.alarm.bo.GrafanaAlarmBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger log = LoggerFactory.getLogger(AlarmManagerController.class);

    @RequestMapping
    public String home() {
        return "home";
    }

    @PostMapping("str")
    public void str(@RequestBody AlertManagerAlarmBo<AlertManagerAlarmBo.Alert> alertManagerAlarmBo) {
        log.info("{}", alertManagerAlarmBo);
    }

    @PostMapping("grafana")
    public void grafana(@RequestBody GrafanaAlarmBo<GrafanaAlarmBo.Alert> grafanaAlarmBo) {
        log.info("{}", grafanaAlarmBo);
    }
}
