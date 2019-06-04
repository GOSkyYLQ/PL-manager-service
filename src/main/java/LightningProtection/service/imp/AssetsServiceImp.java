package LightningProtection.service.imp;

import LightningProtection.mapper.AssetsMapper;
import LightningProtection.pojo.ta_assets;
import LightningProtection.pojo.ta_assetsExample;
import LightningProtection.service.AssetsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsServiceImp implements AssetsService {
    @Autowired
    private AssetsMapper assetsMapper;

    @Override
    public EasyUIDataGridResult getAssetsList(int page , int rows){
        PageHelper.startPage(page,rows);
        ta_assetsExample example = new ta_assetsExample();
        List<ta_assets> list = assetsMapper.selectByExample(example);
        PageInfo<ta_assets> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public PLResult deleteAssetsById(Long id) {
        if(assetsMapper.deleteByPrimaryKey(id)) {
            return PLResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public void addAssets(ta_assets assets){
        assetsMapper.insertSelective(assets);
    }
}
