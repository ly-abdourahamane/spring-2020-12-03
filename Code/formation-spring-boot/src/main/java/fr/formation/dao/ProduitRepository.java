package fr.formation.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>, JpaSpecificationExecutor<Produit> {
//	public List<Produit> findByPrice(BigDecimal price, Pageable page);
//	public int countByPrice(BigDecimal price);
	public Page<Produit> findByPrice(BigDecimal price, Pageable page);
	
	public List<Produit> findByPriceBetween(BigDecimal a, BigDecimal b);
	public List<Produit> findByPriceBetweenOrderByPriceDescLabelAsc(BigDecimal a, BigDecimal b);

	public List<Produit> findByPriceAndLabelContaining(BigDecimal price, String label);
	
	@Query("select p from Produit p where p.price < 10")
	public Optional<Produit> demoJpql();

	@Query("select p from Produit p where p.price < :paramprice")
	public Produit demoJpqlParamNomme(@Param("paramprice") BigDecimal price);

	@Query("select p from Produit p where p.price > ?1 and p.price < ?2")
	public Produit demoJpql(BigDecimal a, BigDecimal b);

	@Query(value = "SELECT * FROM produit WHERE PRO_PRICE > ?1 AND PRO_PRICE < ?2", nativeQuery = true)
	public Produit demoNative(BigDecimal a, BigDecimal b);

	@Query("select distinct p.createdOn from Produit p")
	public List<LocalDate> findCreatedOn();

//	public List<ProduitProjection> findAllByLabelContaining(String label);

	@Query("select p from Produit p")
	public <T> List<T> findAll(Class<T> clz);
}