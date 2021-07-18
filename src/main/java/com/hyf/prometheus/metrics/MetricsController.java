package com.hyf.prometheus.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/07/17
 */
@RestController
@RequestMapping("v1")
public class MetricsController {

    @Resource
    private MeterRegistry meterRegistry;

    private Counter index_count;

    @PostConstruct
    public void post() {
        index_count = meterRegistry.counter("app_request_count", "request", "MetricsController.index");
    }

    @RequestMapping("index")
    public String index() {
        index_count.increment();
        return "index number: " + index_count.count();
    }
}
