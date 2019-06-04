package LightningProtection.service;

import LightningProtection.pojo.ta_project;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

import java.util.List;

public interface ProjectService {
    ta_project selectByPrimaryKey(Long id);
    List<ta_project> getProjectByExample();
    EasyUIDataGridResult getProjectList(int page, int rows);
    EasyUIDataGridResult getprojectList(int page, int rows);
    PLResult deleteProjectById(Long id);
    void addProject(ta_project taProject);
    void editProject(ta_project taProject);
    PLResult editproject(ta_project taProject);
}
