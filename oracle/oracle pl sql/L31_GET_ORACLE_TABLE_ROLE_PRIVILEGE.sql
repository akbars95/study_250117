SELECT OWNER, COUNT(OWNER) AS OWNER_COUNT
FROM SYS.ALL_TABLES
GROUP BY OWNER
ORDER BY OWNER ASC, OWNER_COUNT ASC;


SELECT *
FROM SYS.DBA_TABLES;
SELECT OWNER, COUNT(OWNER) AS OWNER_COUNT
FROM SYS.DBA_TABLES
GROUP BY OWNER
ORDER BY OWNER ASC, OWNER_COUNT ASC;

SELECT *
FROM SYS.USER_TABLES
ORDER BY TABLE_NAME;--CURRENT USER TABLES
SELECT OWNER, COUNT(OWNER) AS OWNER_COUNT
FROM SYS.USER_TABLES
GROUP BY OWNER
ORDER BY OWNER ASC, OWNER_COUNT ASC;
--------------------------------------------------------------------------------
SELECT * FROM DBA_ROLES ORDER BY ROLE;

SELECT ORACLE_MAINTAINED, COUNT(ORACLE_MAINTAINED)
FROM DBA_ROLES
GROUP BY ORACLE_MAINTAINED;

SELECT * FROM DBA_ROLES ORDER BY ORACLE_MAINTAINED;

SELECT * FROM DBA_ROLES;--This view lists all roles that exist in the database.
SELECT * FROM DBA_ROLE_PRIVS;--DBA view lists roles granted to users and roles.

SELECT GRANTEE, COUNT(GRANTEE)
FROM DBA_ROLE_PRIVS
GROUP BY GRANTEE;

SELECT * FROM USER_ROLE_PRIVS;--USER view lists roles granted to the current user.
--------------------------------------------------------------------------------
SELECT * FROM SYS.DBA_SYS_PRIVS;

SELECT * 
FROM SYS.DBA_SYS_PRIVS
ORDER BY GRANTEE;

SELECT * FROM USER_SYS_PRIVS;
--------------------------------------------------------------------------------
SELECT * FROM ROLE_ROLE_PRIVS;
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

DBA_COL_PRIVS

ALL_COL_PRIVS

USER_COL_PRIVS

DBA view describes all column object grants in the database. ALL view describes all column object grants for which the current user or PUBLIC is the object owner, grantor, or grantee. USER view describes column object grants for which the current user is the object owner, grantor, or grantee.

ALL_COL_PRIVS_MADE

USER_COL_PRIVS_MADE

ALL view lists column object grants for which the current user is object owner or grantor. USER view describes column object grants for which the current user is the grantor.

ALL_COL_PRIVS_RECD

USER_COL_PRIVS_RECD

ALL view describes column object grants for which the current user or PUBLIC is the grantee. USER view describes column object grants for which the current user is the grantee.

DBA_TAB_PRIVS

ALL_TAB_PRIVS

USER_TAB_PRIVS

DBA view lists all grants on all objects in the database. ALL view lists the grants on objects where the user or PUBLIC is the grantee. USER view lists grants on all objects where the current user is the grantee.

ALL_TAB_PRIVS_MADE

USER_TAB_PRIVS_MADE

ALL view lists the all object grants made by the current user or made on the objects owned by the current user. USER view lists grants on all objects owned by the current user.

ALL_TAB_PRIVS_RECD

USER_TAB_PRIVS_RECD

ALL view lists object grants for which the user or PUBLIC is the grantee. USER view lists object grants for which the current user is the grantee.

DBA_ROLES

This view lists all roles that exist in the database.

DBA_ROLE_PRIVS

USER_ROLE_PRIVS

DBA view lists roles granted to users and roles. USER view lists roles granted to the current user.

DBA_SYS_PRIVS

USER_SYS_PRIVS

DBA view lists system privileges granted to users and roles. USER view lists system privileges granted to the current user.

ROLE_ROLE_PRIVS

This view describes roles granted to other roles. Information is provided only about roles to which the user has access.

ROLE_SYS_PRIVS

This view contains information about system privileges granted to roles. Information is provided only about roles to which the user has access.

ROLE_TAB_PRIVS

This view contains information about object privileges granted to roles. Information is provided only about roles to which the user has access.

SESSION_PRIVS

This view lists the privileges that are currently enabled for the user.

SESSION_ROLES

This view lists the roles that are currently enabled to the user.