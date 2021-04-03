package com.init.api.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.api.entitys.Image;

public interface ImageDao extends JpaRepository<Image, Long>{}
