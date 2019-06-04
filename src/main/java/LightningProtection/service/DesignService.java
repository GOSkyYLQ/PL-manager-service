package LightningProtection.service;


import LightningProtection.pojo.ta_project_design;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface DesignService {
    EasyUIDataGridResult getDesignList(int page, int rows);
    PLResult deleteDesignById(Long id);
    void addDesign(ta_project_design taDesign);
}
