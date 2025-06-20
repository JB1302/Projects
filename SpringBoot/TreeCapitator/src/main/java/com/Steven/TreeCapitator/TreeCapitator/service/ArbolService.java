/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Steven.TreeCapitator.TreeCapitator.service;

import com.Steven.TreeCapitator.TreeCapitator.domain.Arbol;
import com.Steven.TreeCapitator.TreeCapitator.repository.ArbolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Definir como un servicio
public class ArbolService {

    //Crea y inyecta objetos automaticamente
    @Autowired

    //Enlazar el repositorio
    private ArbolRepository arbolRepository;

    //Metodo para leer toda la tabla
    @Transactional(readOnly = true)
    public List<Arbol> getArboles() {

        var lista = arbolRepository.findAll();
        return lista;
    }

    //Gettter funcional
    @Transactional(readOnly = true)
    public Arbol getArbolPorId(Arbol arbol) {
        return arbolRepository.findById(arbol.getId_especie())
                .orElse(null);
    }

    //Post de guardado (Mas Seguro)
    @Transactional
    public void save(Arbol arbol) {
        arbolRepository.save(arbol);
    }

    //Post de Dele (Mas seguro)
    @Transactional
    public boolean delete(Arbol arbol) {
        try {
            arbolRepository.delete(arbol);
            arbolRepository.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
