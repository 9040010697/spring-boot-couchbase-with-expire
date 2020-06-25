package com.cb.model;

import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
@Document(expiryExpression = "${app.couchbase.bucket.expire}", expiryUnit = TimeUnit.MINUTES)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {

    @Id
    private String sessionId;

    public Session(String sessionId) {
        this.sessionId = sessionId;
    }
}
