package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ProjectService;

@Controller
@RequestMapping("/index")
public class ProjectInfoController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{proj_id}")
    public String getAttributes(@PathVariable String proj_id, Model model) {

        model.addAttribute("projectInfo", projectService.getAttributesOfProject(proj_id));
        model.addAttribute("clientName", projectService.getClientOfProject(proj_id));
        model.addAttribute("devPhase", projectService.getAllPhasesOfProject(proj_id));
        model.addAttribute("devType", projectService.getDevelopmentTypeOfProject(proj_id));
        model.addAttribute("tech", projectService.getAllTechnologiesOfProject(proj_id));
        model.addAttribute("status", projectService.getStatusOfProject(proj_id));
        model.addAttribute("projManager", projectService.getAllManagersOfProject(proj_id));
        model.addAttribute("members", projectService.getAllMembersOfProject(proj_id));

        System.out.println(projectService.getAttributesOfProject("1"));
        
        return "index";

        
    }
}
