package LightningProtection.service;

import LightningProtection.pojo.ta_project_kance;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface KanceService {
    EasyUIDataGridResult getKanceList(int page, int rows);
    PLResult deleteKanceById(Long id);
    void addKance(ta_project_kance taKance);
}
