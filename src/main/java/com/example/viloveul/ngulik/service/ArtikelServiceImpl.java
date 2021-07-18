package com.example.viloveul.ngulik.service;

import com.example.viloveul.ngulik.entity.Artikel;
import com.example.viloveul.ngulik.repository.ArtikelRepository;
import com.example.viloveul.ngulik.specification.ArtikelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Fajrul Akbar Zuhdi 2021-07-18
 */
@Service
public class ArtikelServiceImpl implements ArtikelService {

    @Autowired
    private ArtikelRepository artikelRepository;

    @Override
    public Page<Artikel> loadAll(Pageable pageable) {
        return this.artikelRepository.findAll(pageable);
    }

    @Override
    public Page<Artikel> loadAll(ArtikelSpecification specification, Pageable pageable) {
        return this.artikelRepository.findAll(specification, pageable);
    }
}
