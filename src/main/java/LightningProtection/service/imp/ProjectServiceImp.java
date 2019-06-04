package LightningProtection.service.imp;

import LightningProtection.mapper.ProjectMapper;
import LightningProtection.pojo.ta_project;
import LightningProtection.pojo.ta_projectExample;
import LightningProtection.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ta_project selectByPrimaryKey(Long id){
        ta_project taProject = projectMapper.selectByPrimaryKey(id);
        return taProject;
    }

    @Override
    public List<ta_project> getProjectByExample(){
        //ta_project taProject = projectMapper.selectByPrimaryKey();
        ta_projectExample example = new ta_projectExample();
//        //ta_projectExample.Criteria criteria = example.createCriteria();
//        ///criteria.andPro_nameEqualTo(pro_name);
        List<ta_project> list = projectMapper.selectByExample(example);
////        ta_project taProject = null;
////        if(list != null && list.size() > 0){
////            for(int i = 0;i < list.size();i++)
////            {
////                taProject = list.get(i);
////            }
////        }
        return list;
    }

    @Override
    public void editProject(ta_project taProject){
        projectMapper.updateByPrimaryKeySelective(taProject);
    }
    @Override
    public PLResult editproject(ta_project taProject){
        taProject.setPro_status("审核通过");
        if(projectMapper.UpdateByPrimaryKeySelective(taProject)){
            return PLResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public EasyUIDataGridResult getProjectList(int page, int rows){
        PageHelper.startPage(page,rows);
        ta_projectExample example = new ta_projectExample();
        ta_projectExample.Criteria criteria = example.createCriteria();
        criteria.andPro_statusNotEqualTo("审核未通过");
        List<ta_project> list = projectMapper.selectByExample(example);
        PageInfo<ta_project> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public EasyUIDataGridResult getprojectList(int page, int rows){
        PageHelper.startPage(page,rows);
        ta_projectExample example = new ta_projectExample();
        ta_projectExample.Criteria criteria = example.createCriteria();
        criteria.andPro_statusEqualTo("审核未通过");
        List<ta_project> list = projectMapper.selectByExample(example);
        PageInfo<ta_project> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public PLResult deleteProjectById(Long id) {
        if(projectMapper.deleteByPrimaryKey(id)) {
            return PLResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public void addProject(ta_project taproject){
        taproject.setPro_status("审核未通过");
       projectMapper.insertSelective(taproject);
    }
}
