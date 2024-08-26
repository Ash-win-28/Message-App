package com.ashwin.message_app.repository;

import com.ashwin.message_app.data.Folders;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoldersRepository extends CassandraRepository<Folders, String> {

    List<Folders> findByUserId(String userId);
}
