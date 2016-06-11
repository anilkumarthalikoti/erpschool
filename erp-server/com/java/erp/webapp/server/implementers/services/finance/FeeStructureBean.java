package com.java.erp.webapp.server.implementers.services.finance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.erp.webapp.database.finance.FeeStructure;
import com.java.erp.webapp.database.finance.FeeStructurePk;
import com.java.erp.webapp.request.finance.FeeStructureRequest;
import com.java.erp.webapp.server.implementers.services.common.BaseBean;
import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;
import com.java.erp.webapp.server.interfaces.services.finance.FeeStructureBeanI;
@Service
public class FeeStructureBean extends BaseBean implements FeeStructureBeanI {

	@Override
	public Response getFeeStrucutre(FeeStructureRequest request) throws Exception {
		// TODO Auto-generated method stub
		Response result=new Result();
		List<Object>resultHolder=new ArrayList<Object>();
 resultHolder=getResult(resultHolder);
		result.setResultList(resultHolder);
		return result;
	}
	@Override
	public Response saveFeeStrucutre(FeeStructureRequest request) throws Exception {
		// TODO Auto-generated method stub
		Response result=new Result();
		for(Long batchId:request.getBatchs()){
			for(Long finId:request.getFinancialYears()){
                    FeeStructurePk pk=new FeeStructurePk();
                    pk.setAcYearId(finId);
                    pk.setMappingId(batchId);
                    FeeStructure fs=new FeeStructure();
                    fs.setId(pk);
                    fs.setApr(request.getApr());
                    fs.setMay(request.getMay());
                    fs.setJun(request.getJun());
                    fs.setJul(request.getJul());
                    fs.setAug(request.getAug());
                    fs.setSep(request.getSep());
                    fs.setOct(request.getOct());
                    fs.setNov(request.getNov());
                    fs.setDecember(request.getDec());
                    fs.setJan(request.getJan());
                    fs.setFeb(request.getFeb());
                    fs.setMar(request.getMar());
                    fs.setAdmissionFee(request.getAdmissionFee());
                    fs.setRefundAmount(request.getRefundAmount());
                     getFeeStructureDao().merge(fs);
                     getFeeStructureDao().flush();
			}
		}
		List<Object>resultHolder=new ArrayList<Object>();
 resultHolder=getResult(resultHolder);
		result.setResultList(resultHolder);
		return result;
	}
private List getResult(List resultHolder) throws Exception{
	resultHolder.add(0,getBatchDetailsDao().getAllBatchDetails());
	resultHolder.add(1, getAdmissionAuthorizationDao()
			.getAdmissionAuthorizationList());
	return resultHolder;
}
}
