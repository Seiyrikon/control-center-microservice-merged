package com.example.demo.controller;

import java.util.Map;
import java.util.List;
// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProjectOutput;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String testApi() {
        return "Hello World";
    }

    @GetMapping("/attribute/{proj_id}")
    public Map<String, Object> getAttributes(@PathVariable String proj_id) {
        return projectService.getAttributesOfProject(proj_id);
    }

    @GetMapping("/test/{proj_id}")
       public Map<String,Object> getClientOfProject(@PathVariable String proj_id) {
        return projectService.getClientOfProject(proj_id);
    }

    @GetMapping("/devPhase/{proj_id}")
        public List<Map<String, Object>>  getAllPhasesOfProject(@PathVariable String proj_id) {
        return projectService.getAllPhasesOfProject(proj_id);
    }
    
    @GetMapping("/devType/{proj_id}")
        public List<Map<String, Object>> getDevelopmentTypeOfProject(@PathVariable String proj_id) {
        return projectService.getDevelopmentTypeOfProject(proj_id);
    }   

      @GetMapping("/tech/{proj_id}")
        public List<Map<String, Object>> getAllTechnologiesOfProject(@PathVariable String proj_id) {
        return projectService.getAllTechnologiesOfProject(proj_id);
    }

    @GetMapping("/status/{proj_id}")
        public Map<String, Object> getStatusOfProject(@PathVariable String proj_id) {
        return projectService.getStatusOfProject(proj_id);
    }

    @GetMapping("/desc/{proj_id}")
        public ProjectOutput getProjectById(@PathVariable String proj_id) {
        return projectService.getProjectById(proj_id);
    }

     @GetMapping("/manager/{proj_id}")
        public List<Map<String,Object>> getAllManagersOfProject(@PathVariable String proj_id) {
        return projectService.getAllManagersOfProject(proj_id);
    }
}
