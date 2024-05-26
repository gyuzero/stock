package com.gyuzero.stock.service;

import com.gyuzero.stock.domain.Stock;
import com.gyuzero.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    // synchronized 해당 메소드는 1개의 thread 만 접근 가능
//    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        // Stock 조회
        // 재고를 감소
        // 갱신된 값을 저장

        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
