package com.example.vetnet.servicio;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Droga;
import com.example.vetnet.repositorio.DrogaRepository;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DrogaService {

    @Autowired
    private DrogaRepository drogaRepository;

    public Droga SearchById(Long id) {
        return drogaRepository.findById(id).get();
    }

    public List<Droga> SearchAll() {
        return drogaRepository.findAll();
    }

    @jakarta.annotation.PostConstruct
    public void cargarDrogasAlInicio() throws IOException {
        String excelFilePath = "/MEDICAMENTOS_VETERINARIA.xlsx";
        InputStream is = getClass().getResourceAsStream(excelFilePath);
        if (is == null) {
            throw new RuntimeException("Archivo Excel no encontrado en recursos: " + excelFilePath);
        }
        cargarDrogasDesdeExcel(is);
    }

    public void cargarDrogasDesdeExcel(InputStream is) throws IOException {
        List<Droga> drogas = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0); 
            Iterator<Row> rows = sheet.iterator();
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                String nombre = currentRow.getCell(0).getStringCellValue();
                float precioVenta = (float) currentRow.getCell(1).getNumericCellValue();
                float precioCompra = (float) currentRow.getCell(2).getNumericCellValue();
                int unidadesDisponibles = (int) currentRow.getCell(3).getNumericCellValue();
                int unidadesVendidas = (int) currentRow.getCell(4).getNumericCellValue();

                Droga droga = new Droga(nombre, precioCompra, precioVenta, unidadesDisponibles, unidadesVendidas);
                drogas.add(droga);
            }
        }

        drogaRepository.saveAll(drogas);
    }

    public List<Droga> getTopExpensiveMedications() {
        return drogaRepository.findTopExpensiveMedications();
    }
}


