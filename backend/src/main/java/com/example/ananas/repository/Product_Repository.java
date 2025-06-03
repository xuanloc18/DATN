package com.example.ananas.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ananas.entity.Product;

@Repository
public interface Product_Repository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    List<Product> findTop4ByOrderBySoldQuantityDesc();

    @Query("select count (p) from Product p where p.category.categoryId = :id")
    int getNumberProductOfCategory(int id);

    @Query("SELECT MAX(p.price) FROM Product p")
    Double findMaxPrice();

    @Query("SELECT MIN(p.price) FROM Product p")
    Double findMinPrice();

    @Query(
            value = "SELECT c.category_name, SUM(pv.stock) AS total_stock " + "FROM ananas.product_variant pv "
                    + "INNER JOIN ananas.product p ON pv.product_id = p.product_id "
                    + "INNER JOIN ananas.category c ON p.category_id = c.category_id "
                    + "GROUP BY c.category_name",
            nativeQuery = true)
    List<Object[]> getProductNameAndStock();

    @Query(
            value = "SELECT c.category_name, p.product_name, SUM(pv.stock) AS total_stock "
                    + "FROM ananas.product_variant pv "
                    + "INNER JOIN ananas.product p ON pv.product_id = p.product_id "
                    + "INNER JOIN ananas.category c ON p.category_id = c.category_id "
                    + "GROUP BY p.product_name, c.category_name",
            nativeQuery = true)
    List<Object[]> getProductNameAndStockAndCategoryName(Pageable pageable);

    @Query(
            value = "SELECT MONTH(p.created_at) AS month, " +
                    "SUM(variant_stats.total_stock) AS totalStock, " +
                    "SUM(p.sold_quantity) AS totalSold " +
                    "FROM ananas.product p " +
                    "JOIN ( " +
                    "    SELECT product_id, SUM(stock) AS total_stock " +
                    "    FROM ananas.product_variant " +
                    "    GROUP BY product_id " +
                    ") AS variant_stats ON p.product_id = variant_stats.product_id " +
                    "WHERE YEAR(p.created_at) = YEAR(CURRENT_DATE) " +
                    "GROUP BY MONTH(p.created_at) " +
                    "ORDER BY MONTH(p.created_at)",
            nativeQuery = true
    )
    List<Object[]> findMonthlyStatisticsForCurrentYear();

    @Query(
            value = "SELECT * FROM ananas.product WHERE DATE(sale_at) = CURDATE() ORDER BY sold_quantity DESC LIMIT 3",
            nativeQuery = true)
    List<Product> findTopSalesByDay();

    @Query(
            value =
                    "SELECT * FROM ananas.product WHERE WEEK(sale_at) = WEEK(CURDATE()) AND YEAR(sale_at) = YEAR(CURDATE()) ORDER BY sold_quantity DESC LIMIT 3",
            nativeQuery = true)
    List<Product> findTopSalesByWeek();

    @Query(
            value =
                    "SELECT * FROM ananas.product WHERE MONTH(sale_at) = MONTH(CURDATE()) AND YEAR(sale_at) = YEAR(CURDATE()) ORDER BY sold_quantity DESC LIMIT 3",
            nativeQuery = true)
    List<Product> findTopSalesByMonth();

    @Query(
            value =
                    "SELECT * FROM ananas.product WHERE YEAR(sale_at) = YEAR(CURDATE()) ORDER BY sold_quantity DESC LIMIT 3",
            nativeQuery = true)
    List<Product> findTopSalesByYear();

    @Query(
            value = "SELECT * FROM ananas.product WHERE DATE(sale_at) = CURDATE() ORDER BY sold_quantity ASC LIMIT 3",
            nativeQuery = true)
    List<Product> findLeastSalesByDay();

    @Query(
            value =
                    "SELECT * FROM ananas.product WHERE WEEK(sale_at) = WEEK(CURDATE()) AND YEAR(sale_at) = YEAR(CURDATE()) ORDER BY sold_quantity ASC LIMIT 3",
            nativeQuery = true)
    List<Product> findLeastSalesByWeek();

    @Query(
            value =
                    "SELECT * FROM ananas.product WHERE MONTH(sale_at) = MONTH(CURDATE()) AND YEAR(sale_at) = YEAR(CURDATE()) ORDER BY sold_quantity ASC LIMIT 3",
            nativeQuery = true)
    List<Product> findLeastSalesByMonth();

    @Query(
            value =
                    "SELECT * FROM ananas.product WHERE YEAR(sale_at) = YEAR(CURDATE()) ORDER BY sold_quantity ASC LIMIT 3",
            nativeQuery = true)
    List<Product> findLeastSalesByYear();
}
