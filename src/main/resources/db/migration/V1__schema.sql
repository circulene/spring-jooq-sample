/* CREATE SEQUENCE IF NOT EXISTS default_seq; */

CREATE TABLE IF NOT EXISTS project (
    /* id INTEGER PRIMARY KEY DEFAULT nextval('default_seq'), */
    id INTEGER UNIQUE,
    name VARCHAR(255),
    version VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS release (
    /* id INTEGER PRIMARY KEY DEFAULT nextval('default_seq'), */
    id INTEGER UNIQUE, 
    name VARCHAR(255),
    version VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS project_release (
    /* id INTEGER PRIMARY KEY DEFAULT nextval('default_seq'), */
    id INTEGER UNIQUE,
    project_id INTEGER,
    release_id INTEGER,
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (release_id) REFERENCES release (id)
);

CREATE TABLE IF NOT EXISTS issue (
    /* id INTEGER PRIMARY KEY DEFAULT nextval('default_seq'), */
    id INTEGER UNIQUE,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS project_release_issue (
    /* id INTEGER PRIMARY KEY DEFAULT nextval('default_seq'), */
    id INTEGER UNIQUE,
    project_release_id INTEGER NOT NULL,
    issue_id INTEGER NOT NULL,
    FOREIGN KEY (project_release_id) REFERENCES project_release (id),
    FOREIGN KEY (issue_id) REFERENCES issue (id)
);

