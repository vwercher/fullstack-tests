package com.javachallenge.backend.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("authentication")
public class AuthenticationProperty {
    private final Security security = new Security();


    public static class Security {
        private String origemPermitida;
        private boolean enableHttps;

        public String getOrigemPermitida() {
            return origemPermitida;
        }

        public void setOrigemPermitida(String origemPermitida) {
            this.origemPermitida = origemPermitida;
        }

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }
    }

    public Security getSecurity() {
        return security;
    }
}
