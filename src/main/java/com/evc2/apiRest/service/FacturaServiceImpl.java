package com.evc2.apiRest.service;

import com.evc2.apiRest.entity.Factura;
import com.evc2.apiRest.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }
}
