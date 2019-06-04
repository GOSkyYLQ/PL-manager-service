package LightningProtection.service.imp;

import LightningProtection.mapper.BuildMapper;
import LightningProtection.pojo.ta_project_build;
import LightningProtection.pojo.ta_project_buildExample;
import LightningProtection.service.BuildService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BuildServiceImp implements BuildService {
    @Autowired
    private BuildMapper buildMapper;

    @Override
    public EasyUIDataGridResult getBuildList(int page, int rows){
        PageHelper.startPage(page,rows);
        ta_project_buildExample example = new ta_project_buildExample();
        List<ta_project_build> list = buildMapper.selectByExample(example);
        PageInfo<ta_project_build> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public PLResult deleteBuildById(Long id) {
        if(buildMapper.deleteByPrimaryKey(id)) {
            return PLResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public void addBuild(ta_project_build tabuild){
        buildMapper.insertSelective(tabuild);
    }
}
