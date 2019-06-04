package LightningProtection.service;

import LightningProtection.pojo.ta_assets;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface AssetsService {
    EasyUIDataGridResult getAssetsList(int page , int rows);
    PLResult deleteAssetsById(Long id);
    void addAssets(ta_assets taAssets);
}
