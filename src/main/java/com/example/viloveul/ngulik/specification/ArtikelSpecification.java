package com.example.viloveul.ngulik.specification;

import com.example.viloveul.ngulik.entity.Artikel;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fajrul Akbar Zuhdi 2021-07-18
 */
@Setter
public class ArtikelSpecification implements Specification<Artikel> {

    private String judul;
    private String isi;
    private String keyword;

    @Override
    public Predicate toPredicate(Root<Artikel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> andPredicates = new ArrayList<>();
        List<Predicate> orPredicates = new ArrayList<>();
        if (this.judul != null) {
            andPredicates.add(criteriaBuilder.like(root.get("judul"), this.judul));
        }
        if (this.isi != null) {
            andPredicates.add(criteriaBuilder.like(root.get("isi"), this.isi));
        }
        if (this.keyword != null) {
            orPredicates.add(criteriaBuilder.like(root.get("judul"), this.keyword));
            orPredicates.add(criteriaBuilder.like(root.get("isi"), this.keyword));
        }
        Predicate andPredicate = criteriaBuilder.and(andPredicates.toArray(new Predicate[0]));
        Predicate orPredicate = criteriaBuilder.or(orPredicates.toArray(new Predicate[0]));

        return criteriaBuilder.or(andPredicate, orPredicate);
    }
}
