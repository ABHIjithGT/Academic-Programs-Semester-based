SET SERVEROUTPUT ON;


CREATE OR REPLACE TRIGGER prevent_delete_department
BEFORE DELETE ON DEPARTMENTS
FOR EACH ROW
DECLARE
    employee_count INT;
BEGIN
    SELECT COUNT(*) INTO employee_count
    FROM EMPLOYEES1
    WHERE DEPARTMENT_ID = :OLD.DEPARTMENT_ID;

    IF employee_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Cannot delete department. Employees are assigned to it.');
    END IF;
END;
/

