
package com.caso1.repository;

import com.caso1.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository 
        extends JpaRepository<Producto, Long>{
    
}
