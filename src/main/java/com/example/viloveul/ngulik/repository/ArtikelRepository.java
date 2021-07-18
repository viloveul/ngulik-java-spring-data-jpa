package com.example.viloveul.ngulik.repository;

import com.example.viloveul.ngulik.entity.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Fajrul Akbar Zuhdi 2021-07-18
 */
@Repository
public interface ArtikelRepository extends JpaRepository<Artikel, Long>, JpaSpecificationExecutor<Artikel> {
}
