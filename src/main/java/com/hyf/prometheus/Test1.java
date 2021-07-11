package com.hyf.prometheus;

import io.prometheus.client.*;
import io.prometheus.client.exporter.PushGateway;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/**
 * @author baB_hyf
 * @date 2021/07/09
 */
public class Test1 {

    public static void main(String[] args) {

        counter();
        gauge();
        summary();
        histogram();

        labels();
        register();
        pushGateway();

    }

    public static void counter() {
        Counter request_total = Counter.build()
                .name("request_total").help("Total request.").register();
        request_total.inc();
        // Your code here.
    }

    public static void gauge() {
        Gauge inprogressRequests = Gauge.build()
                .name("inprogress_requests").help("Inprogress requests.").register();
        inprogressRequests.inc();
        // Your code here.
        inprogressRequests.dec();
        inprogressRequests.setToCurrentTime(); // Set to current unixtime.
    }

    public static void summary() {
        Summary receivedBytes = Summary.build()
                .name("requests_size_bytes").help("Request size in bytes.").register();
        Summary requestLatency = Summary.build()
                .name("requests_latency_seconds").help("Request latency in seconds.").register();
        Summary.Timer requestTimer = requestLatency.startTimer();
        try {
            // Your code here.
        } finally {
            receivedBytes.observe(111);
            requestTimer.observeDuration();
        }

        Summary requestLatency2 = Summary.build()
                .quantile(0.5, 0.05)   // Add 50th percentile (= median) with 5% tolerated error
                .quantile(0.9, 0.01)   // Add 90th percentile with 1% tolerated error
                .name("requests_latency_seconds").help("Request latency in seconds.").register();
        requestLatency2.time(() -> {
            // Your code here.
        });
    }

    public static void histogram() {
        Histogram requestLatency = Histogram.build()
                .name("requests_latency_seconds").help("Request latency in seconds.").register();
        Histogram.Timer requestTimer = requestLatency.startTimer();
        try {
            // Your code here.
        } finally {
            requestTimer.observeDuration();
        }

        requestLatency.time(() -> {
            // Your code here.
        });
    }

    public static void labels() {
        Counter requests = Counter.build()
                .name("my_library_requests_total").help("Total requests.")
                .labelNames("method").register();
        requests.labels("getMethod").inc();
        // Your code here.
    }

    public static void register() {
        CollectorRegistry defaultRegistry = CollectorRegistry.defaultRegistry;
        defaultRegistry.register(new Collector() {
            @Override
            public List<MetricFamilySamples> collect() {
                return null;
            }
        });
    }

    // 允许从无法抓取的作业中推送指标
    public static void pushGateway() {
        try {
            Map<String, String> stringStringMap = PushGateway.instanceIPGroupingKey();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        PushGateway pushGateway = new PushGateway("");
        try {
            pushGateway.push((Collector) null, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
