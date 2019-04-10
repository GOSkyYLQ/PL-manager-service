package LightningProtection.service.imp;

import LightningProtection.mapper.UnitMapper;
import LightningProtection.pojo.ta_construction_unit;
import LightningProtection.pojo.ta_construction_unitExample;
import LightningProtection.service.UnitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImp implements UnitService {
    @Autowired
    private UnitMapper unitMapper;

    @Override
    public ta_construction_unit getUnitById(int id){
        ta_construction_unitExample example = new ta_construction_unitExample();
        ta_construction_unitExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<ta_construction_unit> list = unitMapper.selectByExample(example);
        ta_construction_unit taConstructionUnit = null;
        if(list != null && list.size() > 0 ){
            taConstructionUnit = list.get(0);
        }
        return taConstructionUnit;
    }

    @Override
    public EasyUIDataGridResult getUnitList(int page ,int rows){
        PageHelper.startPage(page,rows);
        ta_construction_unitExample example = new ta_construction_unitExample();
        List<ta_construction_unit> list = unitMapper.selectByExample(example);
        PageInfo<ta_construction_unit> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }
}
