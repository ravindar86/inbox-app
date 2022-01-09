package com.message.inboxapp.folders.repository;

import com.message.inboxapp.folders.model.Folder;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends CassandraRepository<Folder, String> {

    public List<Folder> findAllById(String id);
}
