/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Steven.TreeCapitator.TreeCapitator.repository;

import com.Steven.TreeCapitator.TreeCapitator.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jstev
 */
public interface ArbolRepository 
        extends JpaRepository<Arbol, Long>{
    
}
