INSERT INTO project (id, name, version) VALUES (1, 'project1', '1.0.0');
INSERT INTO project (id, name, version) VALUES (2, 'project2', '1.0.0');

INSERT INTO release (id, name, version) VALUES (1, 'release1', '1.0.0');
INSERT INTO release (id, name, version) VALUES (2, 'release2', '0.1.0');
INSERT INTO release (id, name, version) VALUES (3, 'release3', '0.0.1');

INSERT INTO project_release (id, project_id, release_id) VALUES (1, 1, 1);
INSERT INTO project_release (id, project_id, release_id) VALUES (2, 1, 2);
INSERT INTO project_release (id, project_id, release_id) VALUES (3, 2, 1);
INSERT INTO project_release (id, project_id, release_id) VALUES (4, 2, 3);

INSERT INTO issue (id, name) VALUES (1, 'issue1');
INSERT INTO issue (id, name) VALUES (2, 'issue2');
INSERT INTO issue (id, name) VALUES (3, 'issue3');
INSERT INTO issue (id, name) VALUES (4, 'issue4');

INSERT INTO project_release_issue (id, project_release_id, issue_id) VALUES (1, 1, 1);
INSERT INTO project_release_issue (id, project_release_id, issue_id) VALUES (2, 1, 2);
/* INSERT INTO project_release_issue (id, project_release_id, issue_id) VALUES (3, 2, 2); */ 
INSERT INTO project_release_issue (id, project_release_id, issue_id) VALUES (3, 3, 3);
INSERT INTO project_release_issue (id, project_release_id, issue_id) VALUES (4, 4, 1);
INSERT INTO project_release_issue (id, project_release_id, issue_id) VALUES (5, 4, 2);
INSERT INTO project_release_issue (id, project_release_id, issue_id) VALUES (6, 4, 3);
