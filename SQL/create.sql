CREATE TABLE exam (
    examid     INTEGER NOT NULL,
    "date"     DATE,
    groupid    INTEGER NOT NULL,
    teacherid  INTEGER NOT NULL,
    subjectid  INTEGER NOT NULL
);

ALTER TABLE exam ADD CONSTRAINT exam_pk PRIMARY KEY ( examid );

CREATE TABLE "Group" (
    groupid  INTEGER NOT NULL,
    name     CHAR(40 CHAR)
);

ALTER TABLE "Group" ADD CONSTRAINT group_pk PRIMARY KEY ( groupid );

CREATE TABLE lesson (
    lessonid     INTEGER NOT NULL,
    name         CHAR(40 CHAR),
    "date"       DATE,
    timetableid  INTEGER NOT NULL
);

ALTER TABLE lesson ADD CONSTRAINT lesson_pk PRIMARY KEY ( lessonid );

CREATE TABLE mark (
    markid       INTEGER NOT NULL,
    value        INTEGER,
    indexnumber  INTEGER NOT NULL,
    teacherid    INTEGER NOT NULL,
    subjectid    INTEGER NOT NULL
);

ALTER TABLE mark ADD CONSTRAINT mark_pk PRIMARY KEY ( markid );

CREATE TABLE officeemployee (
    officeemployeeid  INTEGER NOT NULL,
    name              CHAR(30 CHAR),
    surname           CHAR(30 CHAR),
    age               INTEGER,
    phonenumber       CHAR(10 CHAR),
    mail              CHAR(30 CHAR)
);

ALTER TABLE officeemployee ADD CONSTRAINT officeemployee_pk PRIMARY KEY ( officeemployeeid );

CREATE TABLE proposal (
    proposalid    INTEGER NOT NULL,
    proposalname  CHAR(40 CHAR),
    "date"        DATE,
    "session"     INTEGER,
    income        INTEGER,
    avg           FLOAT(4),
    indexnumber   INTEGER NOT NULL
);

ALTER TABLE proposal ADD CONSTRAINT proposal_pk PRIMARY KEY ( proposalid );

CREATE TABLE student (
    indexnumber   INTEGER NOT NULL,
    name          CHAR(30 CHAR),
    surname       CHAR(30 CHAR),
    age           INTEGER,
    phonenumber   CHAR(10 CHAR),
    mail          CHAR(30 CHAR),
    fieldofstudy  CHAR(40 CHAR),
    groupid       INTEGER NOT NULL
);

ALTER TABLE student ADD CONSTRAINT student_pk PRIMARY KEY ( indexnumber );

CREATE TABLE subject (
    subjectid  INTEGER NOT NULL,
    name       CHAR(40 CHAR)
);

ALTER TABLE subject ADD CONSTRAINT subject_pk PRIMARY KEY ( subjectid );

CREATE TABLE teacher (
    teacherid    INTEGER NOT NULL,
    name         CHAR(30 CHAR),
    surname      CHAR(30 CHAR),
    age          INTEGER,
    phonenumber  CHAR(10 CHAR),
    mail         CHAR(30 CHAR)
);

ALTER TABLE teacher ADD CONSTRAINT teacher_pk PRIMARY KEY ( teacherid );

CREATE TABLE timetable (
    timetableid  INTEGER NOT NULL,
    groupid      INTEGER NOT NULL
);

CREATE UNIQUE INDEX timetable__idx ON
    timetable (
        groupid
    ASC );

ALTER TABLE timetable ADD CONSTRAINT timetable_pk PRIMARY KEY ( timetableid );

ALTER TABLE exam
    ADD CONSTRAINT exam_group_fk FOREIGN KEY ( groupid )
        REFERENCES "Group" ( groupid );

ALTER TABLE exam
    ADD CONSTRAINT exam_subject_fk FOREIGN KEY ( subjectid )
        REFERENCES subject ( subjectid );

ALTER TABLE exam
    ADD CONSTRAINT exam_teacher_fk FOREIGN KEY ( teacherid )
        REFERENCES teacher ( teacherid );

ALTER TABLE lesson
    ADD CONSTRAINT lesson_timetable_fk FOREIGN KEY ( timetableid )
        REFERENCES timetable ( timetableid );

ALTER TABLE mark
    ADD CONSTRAINT mark_student_fk FOREIGN KEY ( indexnumber )
        REFERENCES student ( indexnumber );

ALTER TABLE mark
    ADD CONSTRAINT mark_subject_fk FOREIGN KEY ( subjectid )
        REFERENCES subject ( subjectid );

ALTER TABLE mark
    ADD CONSTRAINT mark_teacher_fk FOREIGN KEY ( teacherid )
        REFERENCES teacher ( teacherid );

ALTER TABLE proposal
    ADD CONSTRAINT proposal_student_fk FOREIGN KEY ( indexnumber )
        REFERENCES student ( indexnumber );

ALTER TABLE student
    ADD CONSTRAINT student_group_fk FOREIGN KEY ( groupid )
        REFERENCES "Group" ( groupid );

ALTER TABLE timetable
    ADD CONSTRAINT timetable_group_fk FOREIGN KEY ( groupid )
        REFERENCES "Group" ( groupid );
