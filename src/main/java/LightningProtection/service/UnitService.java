package LightningProtection.service;

import LightningProtection.pojo.ta_construction_unit;
import common.pojo.EasyUIDataGridResult;

public interface UnitService {
    ta_construction_unit getUnitById(int id);
    EasyUIDataGridResult getUnitList(int page ,int rows);
}
