package LightningProtection.service.imp;

import LightningProtection.mapper.ProjectMapper;
import LightningProtection.pojo.ta_project;
import LightningProtection.pojo.ta_projectExample;
import LightningProtection.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ta_project getProjectById(int id){
        //ta_project taProject = projectMapper.selectByPrimaryKey(id);
        ta_projectExample example = new ta_projectExample();
        ta_projectExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<ta_project> list = projectMapper.selectByExample(example);
        ta_project taProject = null;
        if(list != null && list.size() > 0){
            taProject = list.get(0);
        }
        return taProject;
    }

    @Override
    public EasyUIDataGridResult getProjectList(int page, int rows){
        PageHelper.startPage(page,rows);
        ta_projectExample example = new ta_projectExample();
        List<ta_project> list = projectMapper.selectByExample(example);
        PageInfo<ta_project> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }
}