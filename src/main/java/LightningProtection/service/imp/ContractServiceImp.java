package LightningProtection.service.imp;

import LightningProtection.mapper.ContractMapper;
import LightningProtection.pojo.ta_contract;
import LightningProtection.pojo.ta_contractExample;
import LightningProtection.service.ContractService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractServiceImp implements ContractService {
    @Autowired
    private ContractMapper contractMapper;

//    @Override
//    public ta_contract getContractById(int id){
//        ta_contractExample example = new ta_contractExample();
//        ta_contractExample.Criteria criteria = example.createCriteria();
//        criteria.andIdEqualTo(id);
//        List<ta_contract> list = contractMapper.selectByExample(example);
//        ta_contract taContract = null;
//        if(list != null && list.size() > 0 ){
//            taContract = list.get(0);
//        }
//        return taContract;
//    }

    @Override
    public EasyUIDataGridResult getContractList(int page , int rows){
        PageHelper.startPage(page,rows);
        ta_contractExample example = new ta_contractExample();
        List<ta_contract> list = contractMapper.selectByExample(example);
        PageInfo<ta_contract> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public PLResult deleteContractById(Long id) {
        if(contractMapper.deleteByPrimaryKey(id)) {
            return PLResult.ok();
        }else {
            return null;
        }
    }

    @Override
    public void addContract(ta_contract contract){
        contractMapper.insertSelective(contract);
    }
}
