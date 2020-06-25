package com.cb.repository;

import com.cb.model.Session;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends ReactiveCouchbaseRepository<Session, String> {

}
