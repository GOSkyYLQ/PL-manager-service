package LightningProtection.service;

import LightningProtection.pojo.ta_project;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface ProjectService {
    ta_project getProjectByExample(String pro_name);
    EasyUIDataGridResult getProjectList(int page, int rows,String pro_name,String pro_header);
    PLResult deleteProjectById(Long id);
}
