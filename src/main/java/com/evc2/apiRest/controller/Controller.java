package com.evc2.apiRest.controller;

import com.evc2.apiRest.entity.Factura;
import com.evc2.apiRest.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/factura")
public class Controller {

    private final FacturaService facturaService;

    @PostMapping("/calcularMontoPendiente")
    public ResponseEntity<String> calcularMontoPendiente(@RequestBody List<Factura> facturas) {
        double montoPendiente = 0;
        for (Factura factura : facturas) {
            // Verificar si la factura está pendiente de pago ("S") y agregar su monto al total
            if (factura.getEstadoFactura() == 'S') {
                montoPendiente += factura.getMontoFactura();
            }
            // Guardar la factura en la base de datos independientemente de su estado
            facturaService.guardarFactura(factura);
        }
        return ResponseEntity.ok("El monto de las facturas pendientes de pago es: " + montoPendiente);
    }


}
