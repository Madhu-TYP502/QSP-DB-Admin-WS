package com.flinko.listner.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flinko.listner.dashboard.components.AutomationScriptsInfo;
import com.flinko.listner.dashboard.components.DashboardComponents;
import com.flinko.listner.dashboard.components.ManualTestCasesInfo;
import com.flinko.listner.dashboard.components.StudentsInfo;
import com.flinko.listner.dashboard.components.UserNotWrittenAny;
import com.flinko.listner.data.entity.FlinkoUserEntity;
import com.flinko.listner.data.model.SearchFilter;
import com.flinko.listner.repositories.FlinkoUsersRepository;
import com.mongodb.client.MongoClients;

@Service
public class TrainerProjectNewImpl implements TrainerProjectionServices {

	Logger logger = LoggerFactory.getLogger(TrainerProjectNewImpl.class);
	@Autowired
	FlinkoUsersRepository flinkoUsersRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	DashboardComponents dashboardComponents;

	private List<FlinkoUserEntity> filteredUsers = null;

	private List<FlinkoUserEntity> manualTestCaseWrittenUsersList;
	private List<FlinkoUserEntity> automationScriptsWrittenUsersList;
	private List<FlinkoUserEntity> usersNotWritenAnyScriptsList;

	boolean isCriteriaEmpty = true;
	
	private static int registeredUsersCount;

	@Override
	public ResponseEntity<DashboardComponents> getDashboardData(SearchFilter searchFilter) throws ParseException {

		buildInfo(searchFilter);//get data from queryFilters
		
		dashboardComponents = new DashboardComponents();
		
		StudentsInfo studentsInfo = new StudentsInfo();
		
		studentsInfo.setTotalStudents(filteredUsers.size());
		
		filteredUsers.forEach(user->{if(user.getIsRegistered()){registeredUsersCount++;}});
		
		studentsInfo.setFlinkoRegistered(registeredUsersCount);
		studentsInfo.setFlinkoNotRegistered(filteredUsers.size()-registeredUsersCount);
		studentsInfo.setStudentSet(filteredUsers);
		
		ManualTestCasesInfo manualTestCasesInfo = new ManualTestCasesInfo();
		manualTestCasesInfo.setManualTestCasesWrittenUsers(manualTestCaseWrittenUsersList);
		manualTestCasesInfo.setTotalStudentsWritten(manualTestCaseWrittenUsersList.size());
		manualTestCasesInfo.setTotalStudentNotWritten(manualTestCaseWrittenUsersList.size()-manualTestCasesInfo.getTotalStudentsWritten());
		
		//TO WORK ON
		manualTestCasesInfo.setAvgStepsPerTestCase(0);
		manualTestCasesInfo.setAvgTestCases(0);
		
		
		AutomationScriptsInfo automationScriptsInfo = new AutomationScriptsInfo();
		automationScriptsInfo.setAutomationScriptsWrittenUsers(automationScriptsWrittenUsersList);
		automationScriptsInfo.setTotalStudentsWritten(automationScriptsWrittenUsersList.size());
		automationScriptsInfo.setTotalStudentNotWritten(automationScriptsWrittenUsersList.size()-automationScriptsInfo.getTotalStudentsWritten());
		
		//TO WORK ON
		automationScriptsInfo.setAvgStepsperScript(0);
		automationScriptsInfo.setAvgStcripts(0);
		
		
		UserNotWrittenAny userNotWrittenAny = new UserNotWrittenAny();
		userNotWrittenAny.setUsersNOTWrittenAnyScripts(usersNotWritenAnyScriptsList);
		userNotWrittenAny.setUsersNOTWrittenAnyScriptsCount(usersNotWritenAnyScriptsList.size());
		
		//----------------------------------------------------------
		
		//set dashboardData
		dashboardComponents.setStudentsInfo(studentsInfo);
		dashboardComponents.setManualTestCases(manualTestCasesInfo);
		dashboardComponents.setAutomationScripts(automationScriptsInfo);
		dashboardComponents.setUserNotWrittenAny(userNotWrittenAny);

		return ResponseEntity.ok(dashboardComponents);
	}


	private void buildInfo(SearchFilter searchFilter) throws ParseException {

		MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "AdminDashboard");

		Query filter = buildFilterQuery(searchFilter);

		if (isCriteriaEmpty == false) {

			logger.info("EXECUTING : QUERY " + filter.toString());
			
			filteredUsers = mongoOps.find(filter, FlinkoUserEntity.class);
			
			filter.addCriteria(Criteria.where("batches.projects.scripts.scriptType").is("MANUAL"));
			
			logger.info("EXECUTING : QUERY " + filter.toString());

			manualTestCaseWrittenUsersList = mongoOps.find(filter, FlinkoUserEntity.class);

			isCriteriaEmpty = true;

		}

		Query filter2 = buildFilterQuery(searchFilter);

		if (isCriteriaEmpty == false) {

			filter2.addCriteria(Criteria.where("batches.projects.scripts.scriptType").is("AUTOMATION"));
			
			automationScriptsWrittenUsersList = mongoOps.find(filter2, FlinkoUserEntity.class);

			isCriteriaEmpty = true;

		}

		Query filter3 = buildFilterQuery(searchFilter);

		if (isCriteriaEmpty == false) {

			filter3.addCriteria(Criteria.where("batches.projects.scripts.scriptType").in(""));
			
			usersNotWritenAnyScriptsList = mongoOps.find(filter3, FlinkoUserEntity.class);
			
			isCriteriaEmpty = true;
		}

	}

	public ResponseEntity<List<FlinkoUserEntity>> getUsersByScriptCreatedDate(String startDate, String endDate)
			throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");

		MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "AdminDashboard");
		List<FlinkoUserEntity> result = mongoOps.find(
				Query.query(new Criteria().andOperator(
						Criteria.where("batches.projects.scripts.createDate").gte(dateFormat.parse(startDate)),
						Criteria.where("batches.projects.scripts.createDate").lte(dateFormat.parse(endDate)))),
				FlinkoUserEntity.class, "FlinkoUsers");
		return ResponseEntity.ok(result);
	}

	private Query buildFilterQuery(SearchFilter searchFilter) throws ParseException {
		Query query = new Query();
		if (searchFilter.getTrainer() != null && searchFilter.getTrainer().size() != 0) {

			query.addCriteria(Criteria.where("batches.trainer").in(searchFilter.getTrainer()));
			isCriteriaEmpty = false;
		}

		if (searchFilter.getBranch() != null && searchFilter.getBranch().size() != 0) {
			query.addCriteria(Criteria.where("batches.branch").in(searchFilter.getBranch()));
			isCriteriaEmpty = false;
		}

		if (searchFilter.getBatchCode() != null && searchFilter.getBatchCode().size() != 0) {
			query.addCriteria(Criteria.where("batches.batchCode").in(searchFilter.getBatchCode()));
			isCriteriaEmpty = false;
		}

		if (searchFilter.getProject() != null && searchFilter.getProject().size() != 0) {
			query.addCriteria(Criteria.where("batches.projects.projectName").in(searchFilter.getProject()));
			isCriteriaEmpty = false;
		}

		if (searchFilter.getPlatform() != null && searchFilter.getPlatform().size() != 0) {
			query.addCriteria(Criteria.where("batches.projects.scripts.platformType").in(searchFilter.getPlatform()));
			isCriteriaEmpty = false;
		}

		if (searchFilter.getdateRange() != null && searchFilter.getdateRange().size() != 0) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");

			query.addCriteria(Criteria.where("batches.projects.scripts.createDate")
					.gte(dateFormat.parse(searchFilter.getdateRange().get(0)))
					.lte(dateFormat.parse(searchFilter.getdateRange().get(1))));

			isCriteriaEmpty = false;
		}

		logger.info(query.toString());

		return query;
	}

}
