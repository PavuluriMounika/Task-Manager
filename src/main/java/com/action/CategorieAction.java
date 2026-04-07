package com.action;

import com.dto.CategorieDTO;
import com.service.CategorieService;
import com.validation.BasicChecks;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator; // FIX 1: Correct Validator import (NOT com.opensymphony)

public class CategorieAction {
    
    private int catId; 
    private List<CategorieDTO> categoryList; 
    private List<CategorieDTO> itemList;     
    private int itemId;
    
    // FIX 2: Define these fields so 'save()' can see them
    private CategorieDTO cateo = new CategorieDTO(); 
    private String message; 
    
    private CategorieService service = new CategorieService();
    
    public String display() {
        categoryList = service.getCategories();
        return "input"; 
    }

    public String execute() {
        itemList = service.getItemsByCategory(catId);  
        return "success";
    }

    // save to db 
    public String save() {
        // Prepare the DTO with the current IDs from the form
        cateo.setCatId(catId);
        cateo.setId(itemId);

        // 1. Get the Validator (using javax.validation)
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        // 2. Validate the DTO
        Set<ConstraintViolation<CategorieDTO>> violations = validator.validate(cateo, BasicChecks.class);

        // 3. If there is an error, grab the message
        if (!violations.isEmpty()) {
            this.message = violations.iterator().next().getMessage();
            return "success"; 
        }

        // 4. No errors? Save to DB
        service.saveSelection(cateo);
        this.message = "Data saved successfully!";
        return "success";
    }

    // --- Getters and Setters ---
    public int getCatId() { return catId; }
    public void setCatId(int catId) { this.catId = catId; }

    public List<CategorieDTO> getCategoryList() { return categoryList; }
    public void setCategoryList(List<CategorieDTO> categoryList) { this.categoryList = categoryList; }

    public List<CategorieDTO> getItemList() { return itemList; }
    public void setItemList(List<CategorieDTO> itemList) { this.itemList = itemList; }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    // FIX 3: Add getters/setters for the new fields so Struts/JSP can read them
    public CategorieDTO getCateo() { return cateo; }
    public void setCateo(CategorieDTO cateo) { this.cateo = cateo; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}