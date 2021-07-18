package com.hyf.prometheus.alarm.bo;

/**
 * Grafana的告警通知信息实体
 *
 * @author baB_hyf
 * @date 2021/07/18
 */
public class GrafanaAlarmBo<T> extends AlertManagerAlarmBo<GrafanaAlarmBo.Alert> {

    private String title;
    private String state; // alerting/normal/pending/~~nodata~~/error
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + " Child GrafanaAlarmBo{" +
                "title='" + title + '\'' +
                ", state='" + state + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static class Alert extends AlertManagerAlarmBo.Alert {
        private String silenceURL;
        private String dashboardURL;
        private String panelURL;
        private String valueString;

        public String getSilenceURL() {
            return silenceURL;
        }

        public void setSilenceURL(String silenceURL) {
            this.silenceURL = silenceURL;
        }

        public String getDashboardURL() {
            return dashboardURL;
        }

        public void setDashboardURL(String dashboardURL) {
            this.dashboardURL = dashboardURL;
        }

        public String getPanelURL() {
            return panelURL;
        }

        public void setPanelURL(String panelURL) {
            this.panelURL = panelURL;
        }

        public String getValueString() {
            return valueString;
        }

        public void setValueString(String valueString) {
            this.valueString = valueString;
        }

        @Override
        public String toString() {
            String s = super.toString();
            return s + " Child Alert{" +
                    "silenceURL='" + silenceURL + '\'' +
                    ", dashboardURL='" + dashboardURL + '\'' +
                    ", panelURL='" + panelURL + '\'' +
                    ", valueString='" + valueString + '\'' +
                    '}';
        }
    }
}
