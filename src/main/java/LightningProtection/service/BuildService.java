package LightningProtection.service;

import LightningProtection.pojo.ta_project_build;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface BuildService {
    EasyUIDataGridResult getBuildList(int page, int rows);
    PLResult deleteBuildById(Long id);
    void addBuild(ta_project_build taBuild);
}
