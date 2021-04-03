package com.init.api.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.api.entitys.Message;

public interface MessageDao extends JpaRepository<Message, Long>{}
