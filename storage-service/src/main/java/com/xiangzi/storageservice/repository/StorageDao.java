package com.xiangzi.storageservice.repository;

import com.xiangzi.storageservice.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageDao extends JpaRepository<Storage, Long> {

}
