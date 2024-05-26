package com.gyuzero.stock.repository;

import com.gyuzero.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 실무에서는 별도의 JDBC 사용
public interface LockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT get_lock(:key, 3000)", nativeQuery = true)
    void getLock(String key);

    @Query(value = "SELECT release_lock(:key)", nativeQuery = true)
    void releaseLock(String key);

}
