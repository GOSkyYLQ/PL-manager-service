package LightningProtection.service.imp;

import LightningProtection.mapper.KanceMapper;
import LightningProtection.pojo.ta_project_kance;
import LightningProtection.pojo.ta_project_kanceExample;
import LightningProtection.service.KanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KanceServiceImp implements KanceService {
    @Autowired
    private KanceMapper kanceMapper;

    @Override
    public EasyUIDataGridResult getKanceList(int page, int rows){
        PageHelper.startPage(page,rows);
        ta_project_kanceExample example = new ta_project_kanceExample();
        List<ta_project_kance> list = kanceMapper.selectByExample(example);
        PageInfo<ta_project_kance> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public PLResult deleteKanceById(Long id) {
        if(kanceMapper.deleteByPrimaryKey(id)) {
            return PLResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public void addKance(ta_project_kance takance){
        kanceMapper.insertSelective(takance);
    }
}
