package LightningProtection.service;

import LightningProtection.pojo.ta_project;
import common.pojo.EasyUIDataGridResult;

public interface ProjectService {
    ta_project getProjectById(int id);
    EasyUIDataGridResult getProjectList(int page, int rows);
}
