package LightningProtection.service;

import LightningProtection.pojo.ta_project;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface ProjectService {
    ta_project getProjectById(int id);
    EasyUIDataGridResult getProjectList(int page, int rows);
    PLResult deleteProjectById(Long id);
}
