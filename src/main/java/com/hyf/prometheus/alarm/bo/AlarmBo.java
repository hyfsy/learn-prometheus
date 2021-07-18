package com.hyf.prometheus.alarm.bo;

import java.util.List;

/**
 * @author baB_hyf
 * @date 2021/07/18
 */
public class AlarmBo<T> {

    private List<T> alerts;

    public List<T> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<T> alerts) {
        this.alerts = alerts;
    }

    @Override
    public String toString() {
        return "AlarmBo{" +
                "alerts=" + alerts +
                '}';
    }
}
