package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.ProjectOutput;
import com.example.demo.model.ProjectTable;

// import com.controlcenter.controlcenter.model.ProjectInput;
// import microservice.microservice.model.ProjectOutput;
// import microservice.microservice.model.ProjectTable;

public interface ProjectService {

    public List<ProjectTable> projectList();

    // get all managers of a project
    public  List<Map<String, Object>> getAllManagersOfProject(String proj_id);

    // get all development phases of a project
    public List<Map<String, Object>> getAllPhasesOfProject(String proj_id);

    // get all members of a project
    public List<Map<String, Object>>  getAllMembersOfProject(String proj_id);
    
    public List<Map<String, Object>>  getAllMembersOfProjectForTable(String proj_id);

    // get all development technologies of a project
    public List<Map<String, Object>> getAllTechnologiesOfProject(String proj_id);

    // get the client of a project
    public Map<String, Object> getClientOfProject(String proj_id);

    // get the development type of a project
    public List<Map<String, Object>> getDevelopmentTypeOfProject(String proj_id);

    // get the status of a project
    public Map<String, Object>  getStatusOfProject(String proj_id);

    // get the attributes of a project
    public Map<String, Object> getAttributesOfProject(String proj_id);

    // public ResponseEntity<List<ProjectOutput>> getAllProject();

    public ProjectOutput getProjectById(String id);


}