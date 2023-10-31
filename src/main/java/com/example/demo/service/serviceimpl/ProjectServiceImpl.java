package  com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProjInfoDao;
import com.example.demo.dao.ProjectDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.ClientOutput;
import com.example.demo.model.DevPhaseOutput;
import com.example.demo.model.DevTypeOutput;
import com.example.demo.model.ProjInfoOutput;
import com.example.demo.model.ProjectOutput;
import com.example.demo.model.ProjectStatusOutput;
import com.example.demo.model.ProjectTable;
import com.example.demo.model.TechnologyOutput;
import com.example.demo.model.UserInfoOutput;
import com.example.demo.service.ProjectService;

// import com.controlcenter.controlcenter.dao.ActivityLogDao;
// import microservice.microservice.dao.ClientDao;
// import microservice.microservice.dao.DevPhaseDao;
// import microservice.microservice.dao.DevTypeDao;
// import microservice.microservice.dao.ProjInfoDao;
// import microservice.microservice.dao.ProjectDao;
// import microservice.microservice.dao.ProjectManagerDao;
// import microservice.microservice.dao.ProjectPhaseDao;
// import microservice.microservice.dao.ProjectTechnologyDao;
// import microservice.microservice.dao.TechnologyDao;
// import microservice.microservice.dao.UserDao;
// import microservice.microservice.dao.UserProjectDao;
// // import com.controlcenter.controlcenter.model.ActivityLogInput;
// import microservice.microservice.model.ClientOutput;
// import microservice.microservice.model.DevPhaseOutput;
// import microservice.microservice.model.DevTypeOutput;
// import microservice.microservice.model.ProjInfoOutput;
// import microservice.microservice.model.ProjectOutput;
// import microservice.microservice.model.ProjectPhaseOutput;
// import microservice.microservice.model.ProjectStatusOutput;
// // import microservice.microservice.model.ProjectTable;
// import microservice.microservice.model.ProjectTechnologyOutput;
// import microservice.microservice.model.TechnologyOutput;
// import microservice.microservice.model.UserInfoOutput;
// // import microservice.microservice.model.UserOutput;
// import microservice.microservice.model.UserProjectOutput;
// import microservice.microservice.service.ProjectService;
// import com.controlcenter.controlcenter.shared.TimeFormatter;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProjInfoDao projInfoDao;

    public ProjectOutput getProjectById(String id){
        return projectDao.getProjectById(id);
    };
    // @Autowired
    // public ProjectService projectService;

    // @Autowired
    // public ActivityLogDao activityLogDao;

    // @Autowired
    // public TimeFormatter timeFormatter;

    // @Override
    // public ResponseEntity<List<ProjectTable>> projectTable() {
    //     return ResponseEntity.ok(projectDao.projectTable());
    // }

    @Override
    //Used ResponseEntity to leverage the use of ResponseEntity method to properly handle responses sent by this API.
    public List<ProjectTable> projectList() {

        return projectDao.projectList();
    }


    // get all managers of a project
    @Override
    public List<Map<String, Object>> getAllManagersOfProject(String proj_id) {

        List<UserInfoOutput> managerssOfProject = projectDao.getAllManagersOfProject(proj_id);
    
        List<Map<String, Object>> allManagers = managerssOfProject.stream()
                .map(manager -> {
                    Map<String, Object> currentManagers = new HashMap<>();
                    String fullName = manager.getFname() + " " + manager.getLname();
                    currentManagers.put("manager_name", fullName);
    
                    // Extract the first letter of the full name
                    char firstLetter = fullName.charAt(0);
                    currentManagers.put("first_letter", String.valueOf(firstLetter));
                    // currentManagers.put("color", getchi);
    
                    return currentManagers;
                }).collect(Collectors.toList());
    
        return allManagers;
    }

    // get all development phases of a project
    @Override
    public List<Map<String, Object>> getAllPhasesOfProject(String proj_id) {
        List<DevPhaseOutput> phasesOfProject = projectDao.getAllPhasesOfProject(proj_id);
        List<Map<String, Object>> allPhases = phasesOfProject.stream()
                .map(phase -> {
                    Map<String, Object> currentPhases = new HashMap<>();
                    currentPhases.put("dev_phase_name", phase.getDev_phase_name());
                    return currentPhases;
                }).collect(Collectors.toList());

        return allPhases;
    }

    // get all members of a project
    @Override
    public List<Map<String, Object>> getAllMembersOfProject(String proj_id) {
        List<UserInfoOutput> membersOfProject = projectDao.getAllMembersOfProject(proj_id);
    
        List<Map<String, Object>> allMembers = membersOfProject.stream()
                .map(member -> {
                    Map<String, Object> currentMembers = new HashMap<>();
                    String fullName = member.getFname() + " " + member.getLname();
                    currentMembers.put("member_name", fullName);
    
                    // Extract the first letter of the full name
                    char firstLetter = fullName.charAt(0);
                    currentMembers.put("first_letter", String.valueOf(firstLetter));
                    // currentMembers.put("color", getchi);
    
                    return currentMembers;
                }).collect(Collectors.toList());
    
        return allMembers;
    }
    @Override
    public List<Map<String, Object>> getAllMembersOfProjectForTable(String proj_id) {
        List<UserInfoOutput> membersOfProject = projectDao.getAllMembersOfProjectForTable(proj_id);

        List<Map<String, Object>> allMembers = membersOfProject.stream()
                .map(member -> {
                    UserInfoOutput user = userDao.getUserById(member.getEmp_id());
                    Map<String, Object> currentMembers = new HashMap<>();
                    currentMembers.put("emp_id", user.getEmp_id());
                    currentMembers.put("first_name", user.getFname());
                    currentMembers.put("last_name", user.getLname());
                    currentMembers.put("position_name", user.getPosition_name());
                    return currentMembers;
                }).collect(Collectors.toList());

        return allMembers;
    }
    

    // get all development technologies of a project
    @Override
    public List<Map<String, Object>> getAllTechnologiesOfProject(String proj_id) {
        List<TechnologyOutput> technologiesOfProject = projectDao.getAllTechnologiesOfProject(proj_id);
        List<Map<String, Object>> allTechnologies = technologiesOfProject.stream()
                .map(technology -> {
                    Map<String, Object> currentTechnologies = new HashMap<>();
                    currentTechnologies.put("tech_name", technology.getTech_name());
                    return currentTechnologies;
                }).collect(Collectors.toList());

        return allTechnologies;
    }

    // get the client of a project
    @Override
    public Map<String, Object> getClientOfProject(String proj_id) {
        ClientOutput clientOfProject = projectDao.getClientOfProject(proj_id);
        Map<String, Object> currentClient = new HashMap<>();
        currentClient.put("client_name", clientOfProject.getClient_name());
        return currentClient;
    }

    // get the development type of a project
    @Override
    public List<Map<String, Object>> getDevelopmentTypeOfProject(String proj_id) {
        List<DevTypeOutput> developmentTypeOfProject = projectDao.getDevelopmentTypeOfProject(proj_id);
        List<Map<String, Object>> allDevelopmentType = developmentTypeOfProject.stream()
                .map(developmentType -> {
                    Map<String, Object> currentDevelopmentType = new HashMap<>();
                    currentDevelopmentType.put("dev_type_id", developmentType.getDev_type_name());
                    return currentDevelopmentType;
                }).collect(Collectors.toList());

        return allDevelopmentType;
    }

    // get the status of a project
    @Override
    public Map<String, Object> getStatusOfProject(String proj_id) {
           ProjectStatusOutput statusOfProject = projectDao.getStatusOfProject(proj_id);
           Map<String, Object> currentStatus = new HashMap<>();
           currentStatus.put("status_code", statusOfProject.getProj_status_name());
           return currentStatus;
    }

    // @Override
    // public ResponseEntity<List<ProjectOutput>> getAllProject() {
    //     return ResponseEntity.ok(projectDao.getAllProject());
    // }

    // get the attributes of a project
    @Override
    public Map<String, Object> getAttributesOfProject(String proj_id) {
        ProjectOutput project = projectDao.getProjectById(proj_id);

        ProjInfoOutput projInfo = projInfoDao.getProjInfoById(proj_id);

        List<UserInfoOutput> projectManagers = projectDao.getAllManagersOfProject(proj_id);

        List<String> allManagers = projectManagers
                .stream()
                .map(manager -> {
                    return manager.getEmp_id();
                }).collect(Collectors.toList());

        List<DevTypeOutput> developmentTypes = projectDao.getDevelopmentTypeOfProject(proj_id);

        List<Long> allDevelopmentTypes = developmentTypes
                .stream()
                .map(developmentType -> {
                    return developmentType.getDev_type_id();
                }).collect(Collectors.toList());

        List<DevPhaseOutput> developmentPhases = projectDao.getAllPhasesOfProject(proj_id);

        List<Long> allDevelopmentPhases = developmentPhases
                .stream()
                .map(developmentPhase -> {
                    return developmentPhase.getDev_phase_id();
                }).collect(Collectors.toList());

        List<TechnologyOutput> technologies = projectDao.getAllTechnologiesOfProject(proj_id);

        List<Long> allTechnologies = technologies
                .stream()
                .map(technology -> {
                    return technology.getTech_id();
                }).collect(Collectors.toList());

        List<UserInfoOutput> members = projectDao.getAllMembersOfProjectForTable(proj_id);

        List<String> allMembers = members
                .stream()
                .map(member -> {
                    return member.getEmp_id();
                }).collect(Collectors.toList());

        Map<String, Object> projectAttributes = new HashMap<>();
        projectAttributes.put("proj_name", project.getProj_name());
        projectAttributes.put("proj_code", project.getProj_code());
        projectAttributes.put("proj_desc", project.getProj_description());
        projectAttributes.put("manager_emp_id", allManagers);
        projectAttributes.put("client_id", projInfo.getClient_id());
        projectAttributes.put("start_date", project.getStart_date());
        projectAttributes.put("end_date", project.getEnd_date());
        projectAttributes.put("dev_type_id", allDevelopmentTypes);
        projectAttributes.put("dev_phase_id", allDevelopmentPhases);
        projectAttributes.put("tech_id", allTechnologies);
        projectAttributes.put("status_code", projInfo.getProj_status_id());
        projectAttributes.put("member_emp_id", allMembers);

        return projectAttributes;
    }
}