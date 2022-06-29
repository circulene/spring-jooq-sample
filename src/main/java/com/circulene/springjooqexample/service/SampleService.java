package com.circulene.springjooqexample.service;

import static com.circulene.springjooqexample.model.tables.Issue.ISSUE;
import static com.circulene.springjooqexample.model.tables.Project.PROJECT;
import static com.circulene.springjooqexample.model.tables.ProjectRelease.PROJECT_RELEASE;
import static com.circulene.springjooqexample.model.tables.ProjectReleaseIssue.PROJECT_RELEASE_ISSUE;
import static com.circulene.springjooqexample.model.tables.Release.RELEASE;

import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.jooq.Record5;
import org.jooq.Result;
import org.springframework.stereotype.Service;

import com.circulene.springjooqexample.dto.ProjectDto;
import com.circulene.springjooqexample.dto.ProjectIssueDto;
import com.circulene.springjooqexample.model.tables.records.ProjectRecord;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final DSLContext create;

    public List<ProjectDto> getProjects() {
        Result<ProjectRecord> result = create.selectFrom(PROJECT).fetch();
        return result.stream()
            .map((r) -> ProjectDto.builder()
                .id(r.getId())
                .name(r.getName())
                .version(r.getVersion())
                .build())
            .collect(Collectors.toList());
    }

    public ProjectDto getProject(int id) {
        Result<ProjectRecord> result = create.selectFrom(PROJECT).where(PROJECT.ID.eq(id)).fetch();
        ProjectRecord r = result.get(0);
        return ProjectDto.builder()
            .id(r.getId())
            .name(r.getValue(PROJECT.NAME))
            .version(r.getValue(PROJECT.VERSION))
            .build();
    }

    public List<ProjectIssueDto> getProjectIssue(Integer id) {
        Result<Record5<String, String, String, String, String>> result = 
            create.select(PROJECT.NAME, PROJECT.VERSION, 
                RELEASE.NAME, RELEASE.VERSION, ISSUE.NAME)
                .from(PROJECT_RELEASE_ISSUE)
                .join(PROJECT_RELEASE).on(PROJECT_RELEASE.ID.eq(PROJECT_RELEASE_ISSUE.PROJECT_RELEASE_ID))
                .join(PROJECT).on(PROJECT.ID.eq(PROJECT_RELEASE.PROJECT_ID))
                .join(RELEASE).on(RELEASE.ID.eq(PROJECT_RELEASE.RELEASE_ID))
                .join(ISSUE).on(ISSUE.ID.eq(PROJECT_RELEASE_ISSUE.ISSUE_ID))
                .where(PROJECT.ID.eq(id))
            .fetch();
        return result.stream()
            .map((r) -> ProjectIssueDto.builder()
                .projectName(r.getValue(PROJECT.NAME))
                .projectVersion(r.getValue(PROJECT.VERSION))
                .releaseName(r.getValue(RELEASE.NAME))
                .releaseVersion(r.getValue(RELEASE.VERSION))
                .issueName(r.getValue(ISSUE.NAME))
                .build())
            .collect(Collectors.toList());
    }
}