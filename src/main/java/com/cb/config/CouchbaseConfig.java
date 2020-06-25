package com.cb.config;

import com.couchbase.client.java.cluster.ClusterInfo;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;
import org.springframework.data.couchbase.config.BeanNames;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CouchbaseConfig extends AbstractReactiveCouchbaseConfiguration {

    @Value("${app.couchbase.bootstrap-hosts}")
    private String host;

    @Value("${app.couchbase.bucket.name}")
    private String sessionBucketName;


    @Value("${app.couchbase.username}")
    private String userName;

    @Value("${app.couchbase.password}")
    private String password;

    @Override
    public CouchbaseEnvironment couchbaseEnvironment() {
        return super.couchbaseEnvironment();
    }

    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList(host);
    }

    @Override
    protected String getBucketName() {
        return sessionBucketName;
    }

    @Override
    protected String getBucketPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }


    @Bean(name = BeanNames.COUCHBASE_CLUSTER_INFO)
    public ClusterInfo couchbaseClusterInfo() throws Exception {
        return this.couchbaseCluster().clusterManager(userName, password).info();
    }

}
