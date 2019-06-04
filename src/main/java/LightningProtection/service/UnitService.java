package LightningProtection.service;

import LightningProtection.pojo.ta_construction_unit;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface UnitService {
    ta_construction_unit getUnitById(int id);
    EasyUIDataGridResult getUnitList(int page ,int rows);
    PLResult deleteUnitById(Long id);
    void addUnit(ta_construction_unit taConstructionUnit);
}
