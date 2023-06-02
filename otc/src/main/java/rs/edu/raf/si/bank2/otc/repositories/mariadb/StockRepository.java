package rs.edu.raf.si.bank2.otc.repositories.mariadb;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.si.bank2.otc.models.mariadb.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findStockBySymbol(String symbol);
}