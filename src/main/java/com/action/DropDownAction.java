package com.action;

import com.dto.DropDownDTO;
import com.dto.TableDTO;
import com.service.DropDownService;
import com.service.TableService;
import java.util.List;

public class DropDownAction {

    private String type;
    private List<DropDownDTO> list;
    private int id;

    private DropDownService service = new DropDownService();

    private List<TableDTO> tableData;   // JSON will come here
    private TableService services = new TableService();

    private List<TableDTO> tableList;

    // Load page
    public String execute() {
        return "success";
    }

    // Load dropdown data
    public String getData() {
        list = service.getDropDown(type);
        return "success";
    }

    // ✅ SAVE TABLE (FIXED)
    public String saveTable() {
        try {
            System.out.println("Received Data Size: " + (tableData != null ? tableData.size() : 0));

            if (tableData != null && !tableData.isEmpty()) {
                services.saveData(tableData);
                System.out.println("Data saved successfully!");
            } else {
                System.out.println("No data received!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    // Fetch table data
    public String fetchTable() {
        tableList = services.getAllData();
        return "success";
    }

    // Getters & Setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DropDownDTO> getList() {
        return list;
    }

    public void setList(List<DropDownDTO> list) {
        this.list = list;
    }

    public List<TableDTO> getTableData() {
        return tableData;
    }

    public void setTableData(List<TableDTO> tableData) {
        this.tableData = tableData;
    }

    public List<TableDTO> getTableList() {
        return tableList;
    }

    public void setTableList(List<TableDTO> tableList) {
        this.tableList = tableList;
    }
    
   public String deleteRow(){

        services.deleteById(id);

        return "success";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}