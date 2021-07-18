package com.example.viloveul.ngulik.service;

import com.example.viloveul.ngulik.entity.Artikel;
import com.example.viloveul.ngulik.specification.ArtikelSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Fajrul Akbar Zuhdi 2021-07-18
 */
@Service
public interface ArtikelService {

    Page<Artikel> loadAll(Pageable pageable);

    Page<Artikel> loadAll(ArtikelSpecification specification, Pageable pageable);
}
