package com.circulene.springjooqexample.controller;

import java.util.List;

import com.circulene.springjooqexample.dto.ProjectDto;
import com.circulene.springjooqexample.dto.ProjectIssueDto;
import com.circulene.springjooqexample.service.SampleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleController {
    
    private final SampleService service;

    @GetMapping("projects")
    public List<ProjectDto> getProjects() {
        return service.getProjects();
    }

    @GetMapping("projects/{id}")
    public ProjectDto getProject(@PathVariable("id") int id) {
        return service.getProject(id);
    }

    @GetMapping("projects/{id}/issues")
    public List<ProjectIssueDto> getProjectIssues(@PathVariable("id") int id) {
        return service.getProjectIssue(id);
    }
}