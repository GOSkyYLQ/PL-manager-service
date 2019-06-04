package LightningProtection.service;

import LightningProtection.pojo.ta_project_place;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface PlaceService {
    ta_project_place getPlaceById(int id);
    EasyUIDataGridResult getPlaceList(int page , int rows);
    PLResult deletePlaceById(Long id);
    void addPlace(ta_project_place taProjectPlace);
}
