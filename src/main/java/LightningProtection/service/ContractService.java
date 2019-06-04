package LightningProtection.service;

import LightningProtection.pojo.ta_contract;
import common.pojo.EasyUIDataGridResult;
import common.pojo.PLResult;

public interface ContractService {
    EasyUIDataGridResult getContractList(int page , int rows);
    PLResult deleteContractById(Long id);
    void addContract(ta_contract taContract);
}
