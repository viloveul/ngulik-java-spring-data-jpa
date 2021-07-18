package com.example.viloveul.ngulik;

import com.example.viloveul.ngulik.entity.Artikel;
import com.example.viloveul.ngulik.service.ArtikelService;
import com.example.viloveul.ngulik.specification.ArtikelSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class NgulikApplicationTests {

	@Autowired
	private ArtikelService artikelService;

	@Test
	void testLoadAll() {
		Page<Artikel> artikels = this.artikelService.loadAll(PageRequest.of(0, 5));
		Assertions.assertNotEquals(artikels.getTotalElements(), 0L);
	}

	@Test
	void testLoadAllBySpecification() {
		ArtikelSpecification specification = new ArtikelSpecification();
		specification.setJudul("%Judul%");
		specification.setIsi("%03%");
		specification.setKeyword("%Data%");
		Page<Artikel> artikels = this.artikelService.loadAll(specification, PageRequest.of(0, 5));
		Assertions.assertNotEquals(artikels.getTotalElements(), 0L);
	}
}
