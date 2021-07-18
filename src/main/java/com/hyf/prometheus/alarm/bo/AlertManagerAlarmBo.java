package com.hyf.prometheus.alarm.bo;

import java.util.Date;
import java.util.Map;

/**
 * AlertManager的告警通知信息实体
 *
 * @author baB_hyf
 * @date 2021/07/10
 */
public class AlertManagerAlarmBo<T> extends AlarmBo<AlertManagerAlarmBo.Alert> {

    private String              version;
    private String              groupKey;
    private int                 truncatedAlerts;
    private String              status; // firing/resolved
    private String              receiver;
    private Map<String, String> groupLabels;
    private Map<String, String> commonLabels;
    private Map<String, String> commonAnnotations;
    private String              externalURL;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public int getTruncatedAlerts() {
        return truncatedAlerts;
    }

    public void setTruncatedAlerts(int truncatedAlerts) {
        this.truncatedAlerts = truncatedAlerts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Map<String, String> getGroupLabels() {
        return groupLabels;
    }

    public void setGroupLabels(Map<String, String> groupLabels) {
        this.groupLabels = groupLabels;
    }

    public Map<String, String> getCommonLabels() {
        return commonLabels;
    }

    public void setCommonLabels(Map<String, String> commonLabels) {
        this.commonLabels = commonLabels;
    }

    public Map<String, String> getCommonAnnotations() {
        return commonAnnotations;
    }

    public void setCommonAnnotations(Map<String, String> commonAnnotations) {
        this.commonAnnotations = commonAnnotations;
    }

    public String getExternalURL() {
        return externalURL;
    }

    public void setExternalURL(String externalURL) {
        this.externalURL = externalURL;
    }

    @Override
    public String toString() {
        return "AlertManagerAlarmBo{" +
                "version='" + version + '\'' +
                ", groupKey='" + groupKey + '\'' +
                ", truncatedAlerts=" + truncatedAlerts +
                ", status='" + status + '\'' +
                ", receiver='" + receiver + '\'' +
                ", groupLabels=" + groupLabels +
                ", commonLabels=" + commonLabels +
                ", commonAnnotations=" + commonAnnotations +
                ", externalURL='" + externalURL + '\'' +
                ", alerts=" + getAlerts() +
                '}';
    }

    public static class Alert {
        private String              status; // resolved/firing
        private Map<String, String> labels;
        private Map<String, String> annotations;
        // 默认支持
        // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT+8")
        private Date                startsAt; // rfc3339
        // 传来的 0001-01-01T00:00:00Z 格式有问题
        // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SS'Z'", timezone = "GMT+8")
        private String              endsAt; // rfc3339
        private String              generatorURL;
        private String              fingerprint;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Map<String, String> getLabels() {
            return labels;
        }

        public void setLabels(Map<String, String> labels) {
            this.labels = labels;
        }

        public Map<String, String> getAnnotations() {
            return annotations;
        }

        public void setAnnotations(Map<String, String> annotations) {
            this.annotations = annotations;
        }

        public Date getStartsAt() {
            return startsAt;
        }

        public void setStartsAt(Date startsAt) {
            this.startsAt = startsAt;
        }

        public String getEndsAt() {
            return endsAt;
        }

        public void setEndsAt(String endsAt) {
            this.endsAt = endsAt;
        }

        public String getGeneratorURL() {
            return generatorURL;
        }

        public void setGeneratorURL(String generatorURL) {
            this.generatorURL = generatorURL;
        }

        public String getFingerprint() {
            return fingerprint;
        }

        public void setFingerprint(String fingerprint) {
            this.fingerprint = fingerprint;
        }

        @Override
        public String toString() {
            return "Alert{" +
                    "status='" + status + '\'' +
                    ", labels=" + labels +
                    ", annotations=" + annotations +
                    ", startsAt='" + startsAt + '\'' +
                    ", endsAt='" + endsAt + '\'' +
                    ", generatorURL='" + generatorURL + '\'' +
                    ", fingerprint='" + fingerprint + '\'' +
                    '}';
        }
    }
}
