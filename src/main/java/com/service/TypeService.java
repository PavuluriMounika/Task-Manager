package com.service;

import com.dao.TypeDAO;
import com.dto.TypeDTO;

import java.util.List;

public class TypeService {

    private TypeDAO dao = new TypeDAO();

    public List<TypeDTO> getTypes() {
        return dao.getAllTypes();
    }
}