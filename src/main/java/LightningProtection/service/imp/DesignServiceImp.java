package LightningProtection.service.imp;

import LightningProtection.mapper.DesignMapper;
import LightningProtection.pojo.ta_project_design;
import LightningProtection.pojo.ta_project_designExample;
import LightningProtection.service.DesignService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DesignServiceImp implements DesignService {
    @Autowired
    private DesignMapper designMapper;

    @Override
    public EasyUIDataGridResult getDesignList(int page, int rows){
        PageHelper.startPage(page,rows);
        ta_project_designExample example = new ta_project_designExample();
        List<ta_project_design> list = designMapper.selectByExample(example);
        PageInfo<ta_project_design> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public PLResult deleteDesignById(Long id) {
        if(designMapper.deleteByPrimaryKey(id)) {
            return PLResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public void addDesign(ta_project_design tadesign){
        designMapper.insertSelective(tadesign);
    }
}
