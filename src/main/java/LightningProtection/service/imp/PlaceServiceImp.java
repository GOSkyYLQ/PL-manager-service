package LightningProtection.service.imp;

import LightningProtection.mapper.PlaceMapper;
import LightningProtection.pojo.ta_project_place;
import LightningProtection.pojo.ta_project_placeExample;
import LightningProtection.service.PlaceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlaceServiceImp implements PlaceService {
    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public ta_project_place getPlaceById(int id){
        ta_project_placeExample example = new ta_project_placeExample();
        ta_project_placeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<ta_project_place> list = placeMapper.selectByExample(example);
        ta_project_place taConstructionPlace = null;
        if(list != null && list.size() > 0 ){
            taConstructionPlace = list.get(0);
        }
        return taConstructionPlace;
    }

    @Override
    public EasyUIDataGridResult getPlaceList(int page ,int rows){
        PageHelper.startPage(page,rows);
        ta_project_placeExample example = new ta_project_placeExample();
        List<ta_project_place> list = placeMapper.selectByExample(example);
        PageInfo<ta_project_place> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public PLResult deletePlaceById(Long id) {
        if(placeMapper.deleteByPrimaryKey(id)) {
            return PLResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public void addPlace(ta_project_place project_place){
        placeMapper.insertSelective(project_place);
    }
}
