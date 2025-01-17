package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ProjectService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class ProjectInfoController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String iBringYouToLife(Model model, HttpSession httpSession) {
        if(httpSession.getAttribute("principal") == null) {
            return "loginProj";
        }
        model.addAttribute("listOfProjects", projectService.projectList());
        return "ProjectTable";
    }
    @GetMapping("/project")
    public String index(Model model, HttpSession httpSession) {

        if(httpSession.getAttribute("principal") == null) {
            return "loginProj";
        }

        //session
        model.addAttribute("principal", httpSession.getAttribute("principal"));
        // model.addAttribute("listOfProjects", projectService.projectList());
        model.addAttribute("topNavigation", "fragments/TopNav :: TopNav");
        model.addAttribute("projectTable", "fragments/ProjectTable :: projectTable");
        model.addAttribute("projectMembers", "fragments/ProjectMembersTable :: projectMembersTable");
        return "index";
    }

    @GetMapping("/project-table")
    public String projectTable(Model model, HttpSession httpSession) {
        if(httpSession.getAttribute("principal") == null) {
            return "loginProj";
        }
        model.addAttribute("listOfProjects", projectService.projectList());
        return "fragments/ProjectTable :: projectTable";
    }
    
    @GetMapping("/project-members/{proj_id}")
    public String projectList(@PathVariable String proj_id, Model model, HttpSession httpSession) {
        if(httpSession.getAttribute("principal") == null) {
            return "loginProj";
        }
        model.addAttribute("projectMembers", projectService.getAllMembersOfProjectForTable(proj_id));
        model.addAttribute("projectInfo", projectService.getProjectById(proj_id));
        return "fragments/ProjectMembersTable :: projectMembersTable";
    }

    @GetMapping("/project/{proj_id}")
    public String getAttributes(@PathVariable String proj_id, Model model, HttpSession httpSession) {

        if(httpSession.getAttribute("principal") == null) {
            return "loginProj";
        }

        model.addAttribute("projectInfo", projectService.getAttributesOfProject(proj_id));
        model.addAttribute("clientName", projectService.getClientOfProject(proj_id));
        model.addAttribute("devPhase", projectService.getAllPhasesOfProject(proj_id));
        model.addAttribute("devType", projectService.getDevelopmentTypeOfProject(proj_id));
        model.addAttribute("tech", projectService.getAllTechnologiesOfProject(proj_id));
        model.addAttribute("status", projectService.getStatusOfProject(proj_id));
        model.addAttribute("projManager", projectService.getAllManagersOfProject(proj_id));
        model.addAttribute("members", projectService.getAllMembersOfProject(proj_id));
        
        return "fragments/Project :: Project";
    }

    @GetMapping("/top-nav")
    public String topNav(Model model, HttpSession httpSession) {

        if(httpSession.getAttribute("principal") == null) {
            return "loginProj";
        }
        //session
        model.addAttribute("principal", httpSession.getAttribute("principal"));

        return "fragments/TopNav :: TopNav";
    }

    @GetMapping("/error-page")
    public String errorPage() {
        return "fragments/out_error :: ErrorPage";
    }

}
